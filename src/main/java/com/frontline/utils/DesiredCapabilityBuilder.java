package com.frontline.utils;


import com.frontline.config.ConfigFileManager;
import com.frontline.manager.DesiredCapabilityManager;
import com.frontline.manager.DeviceManager;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

public class DesiredCapabilityBuilder {
    public static ThreadLocal<DesiredCapabilities> desiredCapabilitiesThreadLocal = new ThreadLocal<>();

    private DesiredCapabilityManager capabilities = new DesiredCapabilityManager();

    public DesiredCapabilityBuilder() throws IOException {
    }

    public static DesiredCapabilities getDesiredCapability() {
        return desiredCapabilitiesThreadLocal.get();
    }

    public DesiredCapabilities buildDesiredCapability(String platform) throws Throwable {
        boolean[] flag = { false };
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        if (DeviceManager.getMobilePlatform().equals(MobilePlatform.ANDROID) && !flag[0]) {
            if (((String)ConfigFileManager.configFileMap.get("APP_TYPE")).equalsIgnoreCase("web")) {
                desiredCapabilities = this.capabilities.androidWeb();
            } else {
                desiredCapabilities = this.capabilities.androidNative();
            }
        } else if (DeviceManager.getMobilePlatform().equals(MobilePlatform.IOS)) {
            if (((String)ConfigFileManager.configFileMap.get("APP_TYPE")).equalsIgnoreCase("web")) {
                desiredCapabilities = this.capabilities.iosWeb();
            } else {
                desiredCapabilities = this.capabilities.iosNative();
            }
        }
        desiredCapabilities.setCapability("udid",
                DeviceManager.getDeviceUDID());
        desiredCapabilitiesThreadLocal.set(desiredCapabilities);
        return desiredCapabilities;
    }
}

