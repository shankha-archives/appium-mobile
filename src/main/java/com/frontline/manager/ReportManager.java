package com.frontline.manager;

import com.frontline.report.ExtentTestManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.io.IOException;

public class ReportManager {
    private DeviceManager deviceManager;

    public ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();

    public ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public ExtentTest parent;

    public ExtentTest child;

    public String category = null;

    public ReportManager() {
        this.deviceManager = new DeviceManager();
    }

    public ExtentTest createParentNodeExtent(String methodName, String testDescription) throws IOException, InterruptedException {
        this.parent = ExtentTestManager.createTest(methodName, testDescription, this.deviceManager
                .getDeviceModel() +
                DeviceManager.getDeviceUDID());
        this.parentTest.set(this.parent);
        ExtentTestManager.getTest().log(Status.INFO, "<a target=\"_parent\" href=appiumlogs/" +

                DeviceManager.getDeviceUDID() + "__" + methodName + ".txt>AppiumServerLogs</a>");
        return this.parent;
    }

    public void createChildNodeWithCategory(String methodName, String tags) {
        this
                .child = ((ExtentTest)this.parentTest.get()).createNode(methodName, this.category + DeviceManager.getDeviceUDID()).assignCategory(new String[] { tags });
        this.test.set(this.child);
    }
}

