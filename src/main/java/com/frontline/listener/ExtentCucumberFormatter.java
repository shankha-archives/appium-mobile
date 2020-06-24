package com.frontline.listener;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.frontline.config.ConfigFileManager;
import com.frontline.config.Log;
import com.frontline.manager.*;
import com.frontline.platforms.AndroidDeviceConfiguration;
import com.frontline.platforms.IOSDeviceConfiguration;
import com.frontline.report.ExtentManager;
import com.frontline.report.ExtentTestManager;
import com.frontline.utils.ImageUtils;
import com.frontline.utils.MobilePlatform;
import com.frontline.utils.XpathXML;
import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.im4java.core.IM4JavaException;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExtentCucumberFormatter implements Reporter, Formatter {
    private final DeviceAllocationManager deviceAllocationManager;

    public AppiumServerManager appiumServerManager;

    public AppiumDriverManager appiumDriverManager;

    public DeviceSingleton deviceSingleton;

    public ReportManager reportManager;

    public LinkedList<Step> testSteps;

    public AppiumDriver<MobileElement> appium_driver;

    private AndroidDeviceConfiguration androidDevice;

    private IOSDeviceConfiguration iosDevice;

    public String deviceModel;

    public ImageUtils imageUtils = new ImageUtils();

    public XpathXML xpathXML = new XpathXML();

    private ConfigFileManager prop;

    public static String feature_name;

    private static final Map<String, String> MIME_TYPES_EXTENSIONS = new HashMap<String, String>() {

    };

    public ExtentCucumberFormatter() throws Exception {
        this.reportManager = new ReportManager();
        this.appiumServerManager = new AppiumServerManager();
        this.appiumDriverManager = new AppiumDriverManager();
        this.deviceAllocationManager = DeviceAllocationManager.getInstance();
        this.deviceSingleton = DeviceSingleton.getInstance();
        try {
            this.iosDevice = new IOSDeviceConfiguration();
            this.androidDevice = new AndroidDeviceConfiguration();
            this.prop = ConfigFileManager.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void before(Match match, Result result) {}

    public void result(Result result) {
        if ("passed".equals(result.getStatus())) {
            ((ExtentTest)this.reportManager.test.get()).log(Status.PASS, ((Step)this.testSteps.poll()).getName());
        } else if ("failed".equals(result.getStatus())) {
            String failed_StepName = ((Step)this.testSteps.poll()).getName();
            ((ExtentTest)this.reportManager.test.get()).log(Status.FAIL, result.getErrorMessage());
            String context = AppiumDriverManager.getDriver().getContext();
            boolean contextChanged = false;
            if ("Android".equalsIgnoreCase(AppiumDriverManager.getDriver()
                    .getSessionDetails().get("platform")
                    .toString()) &&
                    !"NATIVE_APP".equals(context)) {
                AppiumDriverManager.getDriver().context("NATIVE_APP");
                contextChanged = true;
            }
            File scrFile = (File)AppiumDriverManager.getDriver().getScreenshotAs(OutputType.FILE);
            if (contextChanged)
                AppiumDriverManager.getDriver().context(context);
            if (DeviceManager.getMobilePlatform().equals(MobilePlatform.ANDROID)) {
                this.deviceModel = this.androidDevice.getDeviceModel();
                screenShotAndFrame(failed_StepName, scrFile, "android");
            } else if (DeviceManager.getMobilePlatform().equals(MobilePlatform.IOS)) {
                try {
                    this
                            .deviceModel = this.iosDevice.getIOSDeviceProductTypeAndVersion();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                screenShotAndFrame(failed_StepName, scrFile, "iPhone");
            }
            try {
                attachScreenShotToReport(failed_StepName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("skipped".equals(result.getStatus())) {
            ((ExtentTest)this.reportManager.test.get()).log(Status.SKIP, ((Step)this.testSteps.poll()).getName());
        } else if ("undefined".equals(result.getStatus())) {
            ((ExtentTest)this.reportManager.test.get()).log(Status.WARNING, ((Step)this.testSteps.poll()).getName());
        }
    }

    public void after(Match match, Result result) {}

    public void match(Match match) {}

    public void embedding(String s, byte[] bytes) {}

    public void write(String s) {}

    public void syntaxError(String s, String s1, List<String> list, String s2, Integer integer) {}

    public void uri(String s) {}

    public void feature(Feature feature) {
        feature_name = feature.getName();
        Log.INFO("Feature Name: " + feature_name);
        String[] tagsArray = getTagArray(feature.getTags());
        String tags = String.join(",", (CharSequence[])tagsArray);
    }

    private String[] getTagArray(List<Tag> tags) {
        String[] tagArray = new String[tags.size()];
        for (int i = 0; i < tags.size(); i++)
            tagArray[i] = ((Tag)tags.get(i)).getName();
        return tagArray;
    }

    public void scenarioOutline(ScenarioOutline scenarioOutline) {}

    public void examples(Examples examples) {}

    public void startOfScenarioLifeCycle(Scenario scenario) {
        try {
            createAppiumInstance(scenario);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        this.testSteps = new LinkedList<>();
        Log.INFO(this.testSteps.toString());
    }

    public void createAppiumInstance(Scenario scenario) throws Throwable {
        String[] tagsArray = getTagArray(scenario.getTags());
        String tags = String.join(",", (CharSequence[])tagsArray);
        if (this.prop.getProperty("RUNNER").equalsIgnoreCase("parallel")) {
            this.deviceAllocationManager.getNextAvailableDeviceId();
            String[] deviceThreadNumber = Thread.currentThread().getName().toString().split("_");
            Log.INFO(Integer.parseInt(deviceThreadNumber[1]) + this.prop
                    .getProperty("RUNNER"));
            try {
                this.deviceAllocationManager.allocateDevice(this.xpathXML
                        .parseXML(
                                Integer.parseInt(deviceThreadNumber[1])), this.deviceSingleton
                        .getDeviceUDID());
                if (DeviceManager.getDeviceUDID() == null)
                    Log.INFO("No devices are free to run test or Failed to run test");
                this.reportManager.createParentNodeExtent(feature_name + "_" + scenario.getName(), tags.toString())
                        .assignCategory(new String[] { tags });
                this.appiumServerManager.startAppiumServer(feature_name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.deviceAllocationManager.allocateDevice("", this.deviceSingleton
                        .getDeviceUDID());
                this.reportManager.createParentNodeExtent(feature_name, "")
                        .assignCategory(new String[] { tags });
                this.appiumServerManager.startAppiumServer(feature_name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            startAppiumServer(scenario, tags);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startAppiumServer(Scenario scenario, String tags) throws Throwable {
        this.reportManager.createChildNodeWithCategory(scenario.getName(), tags);
        this.appiumDriverManager.startAppiumDriverInstance();
    }

    public void background(Background background) {}

    public void scenario(Scenario scenario) {
        Log.INFO("#################################################");
        Log.INFO("\t\tScenario: " + scenario.getName() + "\t\t");
        Log.INFO("#################################################");
    }

    public void step(Step step) {
        this.testSteps.add(step);
    }

    public void endOfScenarioLifeCycle(Scenario scenario) {
        ExtentManager.getExtent().flush();
        AppiumDriverManager.getDriver().quit();
    }

    public void done() {}

    public void close() {}

    public void eof() {
        ExtentManager.getExtent().flush();
        try {
            this.deviceAllocationManager.freeDevice();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void screenShotAndFrame(String failed_StepName, File scrFile, String device) {
        try {
            File framePath = new File(System.getProperty("user.dir") + "/src/test/resources/frames/");
            FileUtils.copyFile(scrFile, new File(
                    System.getProperty("user.dir") + "/target/screenshot/" + device + "/" +
                            DeviceManager.getDeviceUDID() + "/" + this.deviceModel + "/failed_" + failed_StepName

                            .replaceAll(" ", "_") + ".jpeg"));
            File[] files1 = framePath.listFiles();
            if (framePath.exists())
                for (int i = 0; i < files1.length; i++) {
                    if (files1[i].isFile()) {
                        Path p = Paths.get(files1[i].toString(), new String[0]);
                        String fileName = p.getFileName().toString().toLowerCase();
                        if (this.deviceModel.toString().toLowerCase()
                                .contains(fileName.split(".png")[0].toLowerCase()))
                            try {
                                this.imageUtils.wrapDeviceFrames(files1[i]
                                                .toString(),
                                        System.getProperty("user.dir") + "/target/screenshot/" + device + "/" +

                                                DeviceManager.getDeviceUDID()
                                                        .replaceAll("\\W", "_") + "/" + this.deviceModel + "/failed_" + failed_StepName

                                                .replaceAll(" ", "_") + ".jpeg",
                                        System.getProperty("user.dir") + "/target/screenshot/" + device + "/" +

                                                DeviceManager.getDeviceUDID()
                                                        .replaceAll("\\W", "_") + "/" + this.deviceModel + "/failed_" + failed_StepName

                                                .replaceAll(" ", "_") + "_framed.jpeg");
                                break;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (IM4JavaException e) {
                                e.printStackTrace();
                            }
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
            Log.INFO("Resource Directory was not found");
        }
    }

    public void attachScreenShotToReport(String stepName) throws IOException {
        String platform = null;
        if (DeviceManager.getMobilePlatform().equals(MobilePlatform.ANDROID)) {
            platform = "android";
        } else if (DeviceManager.getMobilePlatform().equals(MobilePlatform.IOS)) {
            platform = "iPhone";
        }
        File framedImageAndroid = new File(System.getProperty("user.dir") + "/target/screenshot/" + platform + "/" + DeviceManager.getDeviceUDID() + "/" + this.deviceModel + "/failed_" + stepName.replaceAll(" ", "_") + "_framed.jpeg");
        if (framedImageAndroid.exists()) {
            ((ExtentTest)this.reportManager.test.get()).log(Status.INFO, "Snapshot below: " +
                    ExtentTestManager.getTest().addScreenCaptureFromPath(
                            System.getProperty("user.dir") + "/target/screenshot/" + platform + "/" +

                                    DeviceManager.getDeviceUDID() + "/" + this.deviceModel + "/failed_" + stepName

                                    .replaceAll(" ", "_") + "_framed.jpeg"));
        } else {
            try {
                if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                    ((ExtentTest)this.reportManager.test.get()).log(Status.INFO, "Snapshot below: " +
                            ExtentTestManager.getTest().addScreenCaptureFromPath(
                                    System.getProperty("user.dir") + "/target/screenshot/" + platform + "/" +

                                            DeviceManager.getDeviceUDID() + "/" + this.deviceModel + "/failed_" + stepName

                                            .replaceAll(" ", "_") + ".jpeg"));
                } else {
                    ((ExtentTest)this.reportManager.test.get()).log(Status.INFO, "Snapshot below: " +
                            ExtentTestManager.getTest().addScreenCaptureFromPath("screenshot/" + platform + "/" +

                                    DeviceManager.getDeviceUDID() + "/" + this.deviceModel + "/failed_" + stepName

                                    .replaceAll(" ", "_") + ".jpeg"));
                }
            } catch (UncheckedIOException exception) {
                Log.INFO("Catch the UncheckedIOException");
            }
        }
    }

    public void deleteOutputDirectory() {
        File delete_output = new File(System.getProperty("user.dir") + "/src/test/java/output/");
        File[] files = delete_output.listFiles();
        for (File file : files)
            file.delete();
        if (delete_output.exists())
            delete_output.delete();
    }
}
