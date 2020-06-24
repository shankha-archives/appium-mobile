package com.frontline.manager;

import com.frontline.config.ConfigFileManager;
import com.frontline.config.Log;
import com.frontline.platforms.IOSDeviceConfiguration;
import com.frontline.platforms.SimulatorManager;
import com.frontline.utils.AvailablePorts;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class DesiredCapabilityManager {
    private final ConfigFileManager configFileManager = ConfigFileManager.getInstance();

    private IOSDeviceConfiguration iosDevice = new IOSDeviceConfiguration();

    private AvailablePorts availablePorts = new AvailablePorts();

    private SimulatorManager simulatorManager = new SimulatorManager();

    public DesiredCapabilityManager() throws IOException {
    }

    public DesiredCapabilities androidNative() {
        Log.INFO("Setting Android Desired Capabilities:");
        DesiredCapabilities androidCapabilities = new DesiredCapabilities();
        androidCapabilities.setCapability("platformName", "Android");
        androidCapabilities.setCapability("deviceName", "Android");
        if (!this.configFileManager.getProperty("ANDROID_APP_PATH").isEmpty()) {
            Path path = FileSystems.getDefault().getPath(this.configFileManager.getProperty("ANDROID_APP_PATH"), new String[0]);
            if (!path.getParent().isAbsolute()) {
                androidCapabilities.setCapability("app", path.normalize().toAbsolutePath().toString());
            } else {
                androidCapabilities.setCapability("app", this.configFileManager.getProperty("ANDROID_APP_PATH"));
            }
        }
        Log.INFO(DeviceManager.getDeviceUDID() + Thread.currentThread().getId());
        androidCapabilities.setCapability("noReset", this.configFileManager.getProperty("NO_RESET"));
        androidCapabilities.setCapability("udid",
                DeviceManager.getDeviceUDID());
        if (androidCapabilities.getCapability("automationName") == null || androidCapabilities
                .getCapability("automationName")
                .toString() != "UIAutomator2") {
            androidCapabilities.setCapability("automationName", "UIAutomator2");
            try {
                androidCapabilities.setCapability("systemPort",
                        Integer.valueOf(this.availablePorts.getPort()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        appPackage(androidCapabilities);
        return androidCapabilities;
    }

    public DesiredCapabilities androidWeb() {
        Log.INFO("Setting Android Desired Capabilities:");
        DesiredCapabilities androidWebCapabilities = new DesiredCapabilities();
        androidWebCapabilities.setCapability("deviceName", "Android");
        androidWebCapabilities
                .setCapability("browserName", this.configFileManager
                        .getProperty("BROWSER_TYPE"));
        androidWebCapabilities.setCapability("takesScreenshot", true);
        androidWebCapabilities.setCapability("nativeWebScreenshot", true);
        androidWebCapabilities.setCapability("acceptSslCerts", true);
        if (androidWebCapabilities.getCapability("automationName") == null || androidWebCapabilities
                .getCapability("automationName")
                .toString() != "UIAutomator2") {
            androidWebCapabilities.setCapability("automationName", "UIAutomator2");
            try {
                androidWebCapabilities.setCapability("systemPort",
                        Integer.valueOf(this.availablePorts.getPort()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        androidWebCapabilities.setCapability("udid", DeviceManager.getDeviceUDID());
        return androidWebCapabilities;
    }

    public DesiredCapabilities iosWeb() throws Throwable {
        DesiredCapabilities iOSCapabilities = new DesiredCapabilities();
        Log.INFO("Setting iOS Desired Capabilities:");
        iOSCapabilities.setCapability("platformName", "iOS");
        iOSCapabilities
                .setCapability("browserName", "Safari");
        iOSCapabilities.setCapability("takesScreenshot", true);
        iOSCapabilities.setCapability("nativeWebScreenshot", true);
        iOSCapabilities.setCapability("acceptSslCerts", true);
        String version = this.iosDevice.getIOSDeviceProductVersion();
        if (DeviceManager.getDeviceUDID().length() == 36) {
            iOSCapabilities.setCapability("deviceName", this.simulatorManager
                    .getSimulatorDetailsFromUDID(
                            DeviceManager.getDeviceUDID()).getName());
            iOSCapabilities.setCapability("platformVersion", this.simulatorManager
                    .getSimulatorDetailsFromUDID(DeviceManager.getDeviceUDID())
                    .getOsVersion());
        } else {
            iOSCapabilities.setCapability("webkitDebugProxyPort", (new IOSDeviceConfiguration())
                    .startIOSWebKit());
        }
        if (Float.valueOf(version.substring(0, version.length() - 2)).floatValue() >= 10.0D) {
            iOSCapabilities.setCapability("automationName", "XCuiTest");
            iOSCapabilities.setCapability("wdaLocalPort",
                    Integer.valueOf(this.availablePorts.getPort()));
        }
        iOSCapabilities.setCapability("noReset", this.configFileManager.getProperty("NO_RESET"));
        iOSCapabilities.setCapability("udid",
                DeviceManager.getDeviceUDID());
        appPackageBundle(iOSCapabilities);
        return iOSCapabilities;
    }

    public DesiredCapabilities iosNative() throws Throwable {
        DesiredCapabilities iOSCapabilities = new DesiredCapabilities();
        Log.INFO("Setting iOS Desired Capabilities:");
        iOSCapabilities.setCapability("platformName", "iOS");
        if (!this.configFileManager.getProperty("IOS_APP_PATH").isEmpty()) {
            Path path = FileSystems.getDefault().getPath(this.configFileManager.getProperty("IOS_APP_PATH"), new String[0]);
            if (!path.getParent().isAbsolute()) {
                iOSCapabilities.setCapability("app", path.normalize().toAbsolutePath().toString());
            } else {
                iOSCapabilities.setCapability("app", this.configFileManager.getProperty("IOS_APP_PATH"));
            }
        }
        String version = this.iosDevice.getIOSDeviceProductVersion();
        if (DeviceManager.getDeviceUDID().length() == 36) {
            iOSCapabilities.setCapability("deviceName", this.simulatorManager
                    .getSimulatorDetailsFromUDID(
                            DeviceManager.getDeviceUDID()).getName());
            iOSCapabilities.setCapability("platformVersion", this.simulatorManager
                    .getSimulatorDetailsFromUDID(DeviceManager.getDeviceUDID())
                    .getOsVersion());
        } else {
            iOSCapabilities.setCapability("webkitDebugProxyPort", (new IOSDeviceConfiguration())
                    .startIOSWebKit());
        }
        if (Float.valueOf(version.substring(0, version.length() - 2)).floatValue() >= 10.0D) {
            iOSCapabilities.setCapability("automationName", "XCuiTest");
            iOSCapabilities.setCapability("wdaLocalPort",
                    Integer.valueOf(this.availablePorts.getPort()));
        }
        iOSCapabilities.setCapability("noReset", this.configFileManager.getProperty("NO_RESET"));
        iOSCapabilities.setCapability("udid",
                DeviceManager.getDeviceUDID());
        appPackageBundle(iOSCapabilities);
        return iOSCapabilities;
    }

    public void appPackage(DesiredCapabilities desiredCapabilities) {
        if (this.configFileManager.getProperty("ANDROID_APP_PACKAGE") != null) {
            desiredCapabilities.setCapability("appPackage", this.configFileManager
                    .getProperty("ANDROID_APP_PACKAGE"));
            desiredCapabilities.setCapability("appActivity", this.configFileManager
                    .getProperty("ANDROID_APP_ACTIVITY"));
        }
    }

    private void appPackageBundle(DesiredCapabilities iOSCapabilities) {
        if (this.configFileManager.getProperty("IOS_APP_PACKAGE") != null)
            iOSCapabilities
                    .setCapability("bundleId", this.configFileManager
                            .getProperty("IOS_APP_PACKAGE"));
    }
}
