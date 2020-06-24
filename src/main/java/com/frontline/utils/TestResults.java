package com.frontline.utils;

import java.util.List;

public class TestResults {
    private String deviceName;

    private String deviceModel;

    private String deviceUDID;

    private String screensShotPath;

    private String deviceOS;

    private List<TestCases> testCases;

    public String getScreensShotPath() {
        return this.screensShotPath;
    }

    public void setScreensShotPath(String screensShotPath) {
        this.screensShotPath = screensShotPath;
    }

    public String getDeviceOS() {
        return this.deviceOS;
    }

    public void setDeviceOS(String deviceOS) {
        this.deviceOS = deviceOS;
    }

    public String getDeviceUDID() {
        return this.deviceUDID;
    }

    public void setDeviceUDID(String deviceUDID) {
        this.deviceUDID = deviceUDID;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public List<TestCases> getTestCases() {
        return this.testCases;
    }

    public void setTestCases(List<TestCases> testCases) {
        this.testCases = testCases;
    }
}

