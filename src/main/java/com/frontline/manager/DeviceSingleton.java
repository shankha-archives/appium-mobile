package com.frontline.manager;

public class DeviceSingleton {
    private static DeviceSingleton instance;

    private static DeviceAllocationManager deviceID = null;

    public static DeviceSingleton getInstance() {
        if (instance == null) {
            instance = new DeviceSingleton();
            deviceID = DeviceAllocationManager.getInstance();
        }
        return instance;
    }

    public String getDeviceUDID() {
        return deviceID.getNextAvailableDeviceId();
    }
}
