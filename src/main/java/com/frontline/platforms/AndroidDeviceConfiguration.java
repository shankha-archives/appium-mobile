package com.frontline.platforms;


import com.frontline.config.Log;
import com.frontline.config.MatrixResult;
import com.frontline.config.Utility;
import com.frontline.manager.DeviceManager;
import com.frontline.utils.CommandPrompt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidDeviceConfiguration {
    private CommandPrompt cmd = new CommandPrompt();

    private Map<String, String> devices = new HashMap<>();

    public static ArrayList<String> deviceSerial = new ArrayList<>();

    public static List<String> validDeviceIds = new ArrayList<>();

    public void startADB() throws Exception {
        String output = this.cmd.runCommand("adb start-server");
        String[] lines = output.split("\n");
        if (lines[0].contains("internal or external command"))
            Log.INFO("Please set ANDROID_HOME in your system variables");
    }

    public void stopADB() throws Exception {
        this.cmd.runCommand("adb kill-server");
    }

    public Map<String, String> getDevices() throws Exception {
        getDeviceInfo();
        return this.devices;
    }

    public void getDeviceInfo() throws InterruptedException, IOException {
        int i = 0;
        String devicesheet = System.getProperty("user.dir") + File.separator + "testdata" + File.separator + "deviceSheet.csv";
        Log.INFO(devicesheet);
        MatrixResult matrixResult = Utility.instance().readCSV(devicesheet);
        for (MatrixResult.MatrixValue mV : matrixResult) {
            if ("Yes".equals(mV.getValue("Selected"))) {
                String deviceID = mV.getValue("deviceName");
                String deviceName = mV.getValue("model");
                String osVersion = mV.getValue("version");
                if (deviceID.length() < 30) {
                    this.devices.put("deviceID" + i, deviceID);
                    this.devices.put("deviceName" + i, deviceName);
                    this.devices.put("osVersion" + i, osVersion);
                    deviceSerial.add(deviceID);
                    i++;
                }
            }
        }
    }

    public ArrayList<String> getDeviceSerial() throws Exception {
        String devicesheet = System.getProperty("user.dir") + File.separator + "testdata" + File.separator + "deviceSheet.csv";
        MatrixResult matrixResult = Utility.instance().readCSV(devicesheet);
        for (MatrixResult.MatrixValue mV : matrixResult) {
            if ("Yes".equals(mV.getValue("Selected"))) {
                String deviceID = mV.getValue("deviceName");
                if (deviceID.length() < 30) {
                    if (validDeviceIds.size() > 0) {
                        if (validDeviceIds.contains(deviceID)) {
                            deviceSerial.add(deviceID);
                            Log.INFO("Adding android device: " + deviceID);
                        }
                        continue;
                    }
                    Log.INFO("Adding all android devices: " + deviceID);
                    deviceSerial.add(deviceID);
                }
            }
        }
        return deviceSerial;
    }

    public String getDeviceModel() {
        String deviceModelName = null;
        String devicesheet = System.getProperty("user.dir") + File.separator + "testdata" + File.separator + "deviceSheet.csv";
        MatrixResult matrixResult = Utility.instance().readCSV(devicesheet);
        for (MatrixResult.MatrixValue mV : matrixResult) {
            if ("Yes".equals(mV.getValue("Selected"))) {
                String deviceid = mV.getValue("deviceName");
                if (deviceid.equalsIgnoreCase(DeviceManager.getDeviceUDID()))
                    deviceModelName = mV.getValue("model");
            }
        }
        return deviceModelName.trim();
    }

    public String deviceOS() {
        String deviceOSLevel = null;
        String devicesheet = System.getProperty("user.dir") + File.separator + "testdata" + File.separator + "deviceSheet.csv";
        MatrixResult matrixResult = Utility.instance().readCSV(devicesheet);
        for (MatrixResult.MatrixValue mV : matrixResult) {
            if ("Yes".equals(mV.getValue("Selected"))) {
                String deviceid = mV.getValue("deviceName");
                if (deviceid.equalsIgnoreCase(DeviceManager.getDeviceUDID()))
                    deviceOSLevel = mV.getValue("version");
            }
        }
        return deviceOSLevel;
    }

    public void closeRunningApp(String deviceID, String app_package) throws InterruptedException, IOException {
        this.cmd.runCommand("adb -s " + deviceID + " shell am force-stop " + app_package);
    }

    public void clearAppData(String deviceID, String app_package) throws InterruptedException, IOException {
        this.cmd.runCommand("adb -s " + deviceID + " shell pm clear " + app_package);
    }

    public void removeApkFromDevices(String deviceID, String app_package) throws Exception {
        this.cmd.runCommand("adb -s " + deviceID + " uninstall " + app_package);
    }

    public String screenRecord(String fileName) throws IOException, InterruptedException {
        return "adb -s " + DeviceManager.getDeviceUDID() + " shell screenrecord --bit-rate 3000000 /sdcard/" + fileName + ".mp4";
    }

    public boolean checkIfRecordable() throws IOException, InterruptedException {
        String screenrecord = this.cmd.runCommand("adb -s " + DeviceManager.getDeviceUDID() + " shell ls /system/bin/screenrecord");
        if (screenrecord.trim().equals("/system/bin/screenrecord"))
            return true;
        return false;
    }

    public String getDeviceManufacturer() throws IOException, InterruptedException {
        return this.cmd.runCommand("adb -s " + DeviceManager.getDeviceUDID() + " shell getprop ro.product.manufacturer")

                .trim();
    }

    public AndroidDeviceConfiguration pullVideoFromDevice(String fileName, String destination) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(new String[] { "adb", "-s", DeviceManager.getDeviceUDID(), "pull", "/sdcard/" + fileName + ".mp4", destination });
        Process pc = pb.start();
        pc.waitFor();
        Log.INFO("Exited with Code::" + pc.exitValue());
        Log.INFO("Done");
        Thread.sleep(5000L);
        return new AndroidDeviceConfiguration();
    }

    public void removeVideoFileFromDevice(String fileName) throws IOException, InterruptedException {
        this.cmd.runCommand("adb -s " + DeviceManager.getDeviceUDID() + " shell rm -f /sdcard/" + fileName + ".mp4");
    }

    public void setValidDevices(List<String> deviceID) {
        deviceID.forEach(deviceList -> {
            if (deviceList.length() < 40)
                validDeviceIds.add(deviceList);
        });
    }

    public String getDeviceResolution() throws IOException, InterruptedException {
        return this.cmd.runCommand("adb -s " + DeviceManager.getDeviceUDID() + "shell wm size")
                .split(":")[1].replace("\n", "");
    }
}
