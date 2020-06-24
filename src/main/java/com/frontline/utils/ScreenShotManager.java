package com.frontline.utils;

import com.frontline.config.Log;
import com.frontline.manager.AppiumDriverManager;
import com.frontline.manager.DeviceManager;
import com.frontline.platforms.AndroidDeviceConfiguration;
import com.frontline.platforms.IOSDeviceConfiguration;
import org.apache.commons.io.FileUtils;
import org.im4java.core.IM4JavaException;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class ScreenShotManager {
    private String screenShotNameWithTimeStamp;

    private ImageUtils imageUtils;

    private String capturedScreen;

    private String failedScreen;

    private String framedFailedScreen;

    private String framedCapturedScreen;

    public String getFramedCapturedScreen() {
        return this.framedCapturedScreen;
    }

    public void setFramedCapturedScreen(String framedCapturedScreen) {
        this.framedCapturedScreen = framedCapturedScreen;
    }

    public String getCapturedScreen() {
        return this.capturedScreen;
    }

    public void setCapturedScreen(String capturedScreen) {
        this.capturedScreen = capturedScreen;
    }

    public String getFramedFailedScreen() {
        return this.framedFailedScreen;
    }

    public void setFramedFailedScreen(String framedFailedScreen) {
        this.framedFailedScreen = framedFailedScreen;
    }

    public String getFailedScreen() {
        return this.failedScreen;
    }

    public void setFailedScreen(String failedScreen) {
        this.failedScreen = failedScreen;
    }

    public ScreenShotManager() {
        this.imageUtils = new ImageUtils();
    }

    public String captureScreenShot(int status, String className, String methodName, String deviceModel) throws IOException, InterruptedException {
        String getDeviceModel = null;
        Log.INFO("Current Running Thread Status" +
                AppiumDriverManager.getDriver().getSessionId());
        File scrFile = (File)AppiumDriverManager.getDriver().getScreenshotAs(OutputType.FILE);
        this.screenShotNameWithTimeStamp = currentDateAndTime();
        if (DeviceManager.getMobilePlatform().equals(MobilePlatform.ANDROID)) {
            getDeviceModel = this.screenShotNameWithTimeStamp + deviceModel;
            screenShotAndFrame(status, scrFile, methodName, className, getDeviceModel, "android", deviceModel);
        } else if (DeviceManager.getMobilePlatform().equals(MobilePlatform.IOS)) {
            getDeviceModel = this.screenShotNameWithTimeStamp + deviceModel;
            screenShotAndFrame(status, scrFile, methodName, className, getDeviceModel, "iOS", deviceModel);
        }
        return getDeviceModel;
    }

    public void captureScreenShot(String screenShotName) throws InterruptedException, IOException {
        String className = (new Exception()).getStackTrace()[1].getClassName();
        String deviceModel = null;
        if (DeviceManager.getMobilePlatform().equals(MobilePlatform.ANDROID)) {
            deviceModel = (new AndroidDeviceConfiguration()).getDeviceModel();
        } else if (DeviceManager.getMobilePlatform().equals(MobilePlatform.IOS)) {
            deviceModel = (new IOSDeviceConfiguration()).getIOSDeviceProductTypeAndVersion();
        }
        captureScreenShot(1, className, screenShotName, deviceModel);
    }

    private String currentDateAndTime() {
        LocalDateTime rightNow = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.getDefault());
        return dateTimeFormatter.format(rightNow).replaceAll("[- .:,]", "_");
    }

    private void screenShotAndFrame(int status, File scrFile, String methodName, String className, String model, String platform, String deviceModel) {
        setFailedScreen("screenshot/" + platform + "/" +
                DeviceManager.getDeviceUDID() + "/" + className + "/" + methodName + "/" + this.screenShotNameWithTimeStamp + deviceModel + "_" + methodName + "_failed.jpeg");
        setCapturedScreen("screenshot/" + platform + "/" +
                DeviceManager.getDeviceUDID() + "/" + className + "/" + methodName + "/" + this.screenShotNameWithTimeStamp + deviceModel + "_" + methodName + "_results.jpeg");
        setFramedCapturedScreen("screenshot/" + platform + "/" + DeviceManager.getDeviceUDID() + "/" + className + "/" + methodName + "/" + model + "_" + methodName + "_results_framed.jpeg");
        setFramedFailedScreen("screenshot/" + platform + "/" +
                DeviceManager.getDeviceUDID() + "/" + className + "/" + methodName + "/" + model + "_failed_" + methodName + "_framed.jpeg");
        try {
            File framePath = new File(System.getProperty("user.dir") + "/src/test/resources/frames/");
            if (status == 2) {
                FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/target/" +
                        getFailedScreen().trim()));
            } else {
                FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/target/" +
                        getCapturedScreen().trim()));
            }
            File[] files1 = framePath.listFiles();
            if (framePath.exists())
                for (int i = 0; i < files1.length; i++) {
                    if (files1[i].isFile()) {
                        Path p = Paths.get(files1[i].toString(), new String[0]);
                        String fileName = p.getFileName().toString().toLowerCase();
                        if (model.toLowerCase()
                                .contains(fileName.split(".png")[0].toLowerCase()))
                            try {
                                if (status == 2) {
                                    String str = System.getProperty("user.dir") + "/target/" + getFailedScreen();
                                    this.imageUtils.wrapDeviceFrames(files1[i].toString(), str,
                                            System.getProperty("user.dir") + "/target/" +
                                                    getFramedFailedScreen());
                                    deleteFile(str);
                                    break;
                                }
                                String screenToFrame = System.getProperty("user.dir") + "/target/" + getCapturedScreen();
                                this.imageUtils.wrapDeviceFrames(files1[i].toString(), screenToFrame,
                                        System.getProperty("user.dir") + "/target/" +
                                                getFramedCapturedScreen());
                                deleteFile(screenToFrame);
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
        }
    }

    private void deleteFile(String screenToFrame) {
        File fileToDelete = new File(screenToFrame);
        if (fileToDelete.exists())
            fileToDelete.delete();
    }
}
