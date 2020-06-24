package com.frontline.utils;

import com.frontline.config.Log;
import com.frontline.platforms.AndroidDeviceConfiguration;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.madgag.gif.fmsware.AnimatedGifEncoder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.Operation;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageUtils {
    public void wrapDeviceFrames(String deviceFrame, String deviceScreenToBeFramed, String framedDeviceScreen) throws InterruptedException, IOException, IM4JavaException {
        IMOperation op = new IMOperation();
        op.addImage(new String[] { deviceFrame });
        op.addImage(new String[] { deviceScreenToBeFramed });
        op.gravity("center");
        op.composite();
        op.opaque("none");
        op.addImage(new String[] { framedDeviceScreen });
        ConvertCmd cmd = new ConvertCmd();
        cmd.run((Operation)op, new Object[0]);
    }

    public static List<TestResults> creatResultsSet() throws Exception {
        List<TestResults> testResultList = new ArrayList<>();
        File dir = new File(System.getProperty("user.dir") + "/target/screenshot");
        File[] oSList = dir.listFiles();
        for (File oFile : oSList) {
            File[] dList = oFile.listFiles();
            for (File dFile : dList) {
                TestResults testResult = new TestResults();
                if (dFile.isDirectory()) {
                    testResult.setDeviceUDID(dFile.getName());
                    List<TestCases> testCaseList = new ArrayList<>();
                    File[] tList = dFile.listFiles();
                    for (File tFile : tList) {
                        TestCases testCase = new TestCases();
                        if (tFile.isDirectory()) {
                            testCase.setTestCase(tFile.getName());
                            File[] mList = tFile.listFiles();
                            List<Testmethods> testMethodList = new ArrayList<>();
                            for (File mFile : mList) {
                                Testmethods testMethod = new Testmethods();
                                testMethod.setMethodName(mFile.getName());
                                if (mFile.isDirectory()) {
                                    File[] sList = mFile.listFiles();
                                    String filePath = null;
                                    for (File sFile : sList) {
                                        if (sFile.isFile() && sFile.getCanonicalPath().contains("result")) {
                                            filePath = sFile.getCanonicalPath();
                                            testResult.setDeviceName(sFile.getName().split("_")[1]);
                                            testResult.setDeviceOS((new AndroidDeviceConfiguration()).deviceOS());
                                        }
                                    }
                                    testMethod.setScreenShots(filePath);
                                }
                                if (testMethod.getScreenShots() != null)
                                    testMethodList.add(testMethod);
                            }
                            if (testMethodList.size() > 0)
                                testCase.setTestMethod(testMethodList);
                        }
                        if (testCase.testMethod != null)
                            testCaseList.add(testCase);
                    }
                    testResult.setTestCases(testCaseList);
                }
                testResultList.add(testResult);
            }
        }
        Log.INFO("Writing the Test Results into JSON");
        FileWriter writer = new FileWriter(new File("Report.json"));
        TestWriteUtils.GSON.toJson(testResultList, writer);
        writer.close();
        return testResultList;
    }

    public static void createJSonForHtml() throws IOException {
        File dir = new File(System.getProperty("user.dir") + "/target/screenshot/");
        List<File> files = (List<File>)FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        JsonArray mainObj = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        FileWriter file1 = new FileWriter("test.json");
        for (File file : files) {
            if (file.getCanonicalFile().toString().contains("results")) {
                JsonObject ja = new JsonObject();
                String deviceName = file.getName().split("_")[0];
                String deviceModel = file.getName().split("_")[1];
                String screenName = file.getName().split("_")[2];
                String imagePath = file.getPath().toString();
                ja.addProperty("Device Name", deviceName);
                ja.addProperty("Device Model", deviceModel);
                ja.addProperty("Screen Name", screenName);
                ja.addProperty("Image Path", imagePath);
                jsonObject.add(deviceName, (JsonElement)ja);
            }
        }
        mainObj.add((JsonElement)jsonObject);
        file1.write(mainObj.toString());
        file1.flush();
        file1.close();
    }

    public static void createAnimatedGif(List<File> testScreenshots, File animatedGif) throws IOException {
        AnimatedGifEncoder encoder = new AnimatedGifEncoder();
        encoder.start(animatedGif.getAbsolutePath());
        encoder.setDelay(1500);
        encoder.setQuality(3);
        encoder.setRepeat(0);
        encoder.setTransparent(Color.WHITE);
        int width = 0;
        int height = 0;
        for (File testScreenshot : testScreenshots) {
            BufferedImage bufferedImage = ImageIO.read(testScreenshot);
            width = Math.max(bufferedImage.getWidth(), width);
            height = Math.max(bufferedImage.getHeight(), height);
        }
        encoder.setSize(width, height);
        for (File testScreenshot : testScreenshots)
            encoder.addFrame(ImageIO.read(testScreenshot));
        encoder.finish();
    }

    public static void createGif() throws IOException {
        File[] files = (new File(System.getProperty("user.dir") + "/target/screenshot/")).listFiles();
        showFiles(files);
    }

    public static void showFiles(File[] files) throws IOException {
        int imageAdded = 0;
        List<File> gifDevices = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                showFiles(file.listFiles());
            } else {
                Log.INFO("File: " + file.getName());
                int length = stringContainsItemFromList("results", Arrays.asList(file.getParentFile().list()));
                if (file.getName().contains("results")) {
                    gifDevices.add(file);
                    imageAdded++;
                    if (imageAdded == length) {
                        Log.INFO("Create Gif");
                        String GifFileName = file.getParent().substring(file.getParent().lastIndexOf("/") + 1);
                        createAnimatedGif(gifDevices, new File(file.getParent() + "/" + GifFileName + ".gif"));
                    }
                }
            }
        }
    }

    public static int stringContainsItemFromList(String inputString, List<String> items) {
        int j = 0;
        for (int i = 0; i < items.size(); i++) {
            if (((String)items.get(i)).contains(inputString))
                j++;
        }
        return j;
    }

    @Test
    public void testApp() throws IOException {
        createJSonForHtml();
    }
}
