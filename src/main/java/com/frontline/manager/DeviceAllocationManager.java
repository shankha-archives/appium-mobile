package com.frontline.manager;


import com.frontline.config.ConfigFileManager;
import com.frontline.config.Log;
import com.frontline.platforms.AndroidDeviceConfiguration;
import com.frontline.platforms.IOSDeviceConfiguration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class DeviceAllocationManager {
    private ArrayList<String> devices = new ArrayList<>();

    private ConcurrentHashMap<String, Boolean> deviceMapping = new ConcurrentHashMap<>();

    private static DeviceAllocationManager instance;

    private static AndroidDeviceConfiguration androidDevice;

    private static IOSDeviceConfiguration iosDevice;

    private DeviceAllocationManager() {
        try {
            iosDevice = new IOSDeviceConfiguration();
            androidDevice = new AndroidDeviceConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initializeDevices();
    }

    public static DeviceAllocationManager getInstance() {
        if (instance == null)
            instance = new DeviceAllocationManager();
        return instance;
    }

    private void initializeDevices() {
        String platform = (System.getenv("Platform") != null) ? System.getenv("Platform") : (String)ConfigFileManager.configFileMap.get("Platform");
        if (platform == null)
            throw new IllegalArgumentException("Please execute with Platform environment:: Platform=android/ios/both mvn clean -Dtest=Runner test");
        try {
            if ((System.getProperty("os.name").toLowerCase().contains("mac") && platform
                    .equalsIgnoreCase("iOS")) || platform
                    .equalsIgnoreCase("Both")) {
                if (iosDevice.getIOSUDID() != null) {
                    Log.INFO("Adding iOS devices");
                    if (IOSDeviceConfiguration.validDeviceIds.size() > 0) {
                        this.devices.addAll(IOSDeviceConfiguration.validDeviceIds);
                    } else {
                        this.devices.addAll(IOSDeviceConfiguration.deviceUDIDiOS);
                    }
                }
                if (platform.equalsIgnoreCase("android") || platform
                        .equalsIgnoreCase("Both"))
                    getAndroidDeviceSerial();
            } else {
                getAndroidDeviceSerial();
            }
            for (String device : this.devices)
                this.deviceMapping.put(device, Boolean.valueOf(true));
            Log.INFO(this.deviceMapping.toString());
        } catch (IOException e) {
            e.printStackTrace();
            Log.INFO("Failed to initialize framework");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAndroidDeviceSerial() throws Exception {
        if (androidDevice.getDeviceSerial() != null) {
            Log.INFO("Adding Android devices");
            if (AndroidDeviceConfiguration.validDeviceIds.size() > 0) {
                Log.INFO("Adding Devices from DeviceList Provided");
                this.devices.addAll(AndroidDeviceConfiguration.validDeviceIds);
            } else {
                this.devices.addAll(AndroidDeviceConfiguration.deviceSerial);
            }
        }
    }

    public ArrayList<String> getDevices() {
        return this.devices;
    }

    public synchronized String getNextAvailableDeviceId() {
        ConcurrentHashMap.KeySetView<String, Boolean> devices = this.deviceMapping.keySet();
        int i = 0;
        for (String device : devices) {
            Thread t = Thread.currentThread();
            t.setName("Thread_" + i);
            i++;
            if (((Boolean)this.deviceMapping.get(device)).booleanValue()) {
                this.deviceMapping.put(device, Boolean.valueOf(false));
                return device;
            }
        }
        return "";
    }

    public void freeDevice() {
        this.deviceMapping.put(DeviceManager.getDeviceUDID(), Boolean.valueOf(true));
    }

    public void allocateDevice(String device, String deviceUDID) {
        if (device.isEmpty()) {
            DeviceManager.setDeviceUDID(deviceUDID);
        } else {
            DeviceManager.setDeviceUDID(device);
        }
    }
}

