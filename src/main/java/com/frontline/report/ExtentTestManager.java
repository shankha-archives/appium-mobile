package com.frontline.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.util.Properties;

public class ExtentTestManager {
    public static Properties prop = new Properties();

    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports extent = ExtentManager.getExtent();

    private static ExtentTest test;

    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }

    public static synchronized ExtentTest createTest(String name, String description, String deviceId) {
        test = extent.createTest(name, description).assignCategory(new String[] { deviceId });
        extentTest.set(test);
        return getTest();
    }

    public static synchronized ExtentTest createTest(String name, String description) {
        return createTest(name, description, String.valueOf(Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest createTest(String name) {
        return createTest(name, "Sample Test");
    }
}
