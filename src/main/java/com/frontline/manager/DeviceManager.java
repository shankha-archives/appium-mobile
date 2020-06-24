package com.frontline.manager;

import com.frontline.platforms.AndroidDeviceConfiguration;
import com.frontline.platforms.IOSDeviceConfiguration;
import com.frontline.utils.MobilePlatform;
import java.io.IOException;

public class DeviceManager {
    private static ThreadLocal<String> deviceUDID = new ThreadLocal<>();

    private IOSDeviceConfiguration iosDeviceConfiguration;

    private AndroidDeviceConfiguration androidDeviceConfiguration;

    public DeviceManager() {
        try {
            this.iosDeviceConfiguration = new IOSDeviceConfiguration();
            this.androidDeviceConfiguration = new AndroidDeviceConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDeviceUDID() {
        return deviceUDID.get();
    }

    protected static void setDeviceUDID(String UDID) {
        deviceUDID.set(UDID);
    }

    public static MobilePlatform getMobilePlatform() {
        if (getDeviceUDID().length() != 40)
            if (getDeviceUDID().length() != 36)
                return MobilePlatform.ANDROID;
        return MobilePlatform.IOS;
    }

    public String getDeviceModel() throws InterruptedException, IOException {
        if (getMobilePlatform().equals(MobilePlatform.ANDROID))
            return this.androidDeviceConfiguration.getDeviceModel();
        if (getMobilePlatform().equals(MobilePlatform.IOS))
            return this.iosDeviceConfiguration.getIOSDeviceProductTypeAndVersion();
        throw new IllegalArgumentException("DeviceModel is Empty");
    }

    public String getDeviceCategory() throws Exception {
        if (IOSDeviceConfiguration.deviceUDIDiOS.contains(getDeviceUDID()))
            return this.iosDeviceConfiguration.getDeviceName().replace(" ", "_");
        return this.androidDeviceConfiguration.getDeviceModel();
    }

    public String getDeviceVersion() {
        if (getMobilePlatform().equals(MobilePlatform.ANDROID))
            return this.androidDeviceConfiguration.deviceOS();
        if (getMobilePlatform().equals(MobilePlatform.IOS))
            try {
                return this.iosDeviceConfiguration.getIOSDeviceProductVersion();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        throw new IllegalArgumentException("DeviceVersion is Empty");
    }
}

