package com.frontline.manager;
import com.frontline.config.ConfigFileManager;
import com.frontline.platforms.IOSDeviceConfiguration;
import com.frontline.utils.DesiredCapabilityBuilder;
import com.frontline.utils.MobilePlatform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Optional;

public class AppiumDriverManager {
    private static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();

    private IOSDeviceConfiguration iosDeviceConfiguration = new IOSDeviceConfiguration();

    private DesiredCapabilityManager desiredCapabilityManager = new DesiredCapabilityManager();

    private AppiumServerManager appiumServerManager = new AppiumServerManager();

    private DesiredCapabilityBuilder desiredCapabilityBuilder = new DesiredCapabilityBuilder();

    private ConfigFileManager prop = ConfigFileManager.getInstance();

    public AppiumDriverManager() throws IOException {
    }

    public static AppiumDriver getDriver() {
        return appiumDriver.get();
    }

    protected static void setDriver(AppiumDriver driver) {
        appiumDriver.set(driver);
    }

    private AppiumDriver<MobileElement> getMobileAndroidElementAppiumDriver(Optional<DesiredCapabilities> androidCaps) {
        DesiredCapabilities desiredCapabilities = androidCaps.isPresent() ? androidCaps.get() : this.desiredCapabilityManager.androidNative();
        return (AppiumDriver<MobileElement>)new AndroidDriver(this.appiumServerManager.getAppiumUrl(), (Capabilities)desiredCapabilities);
    }

    private AppiumDriver<MobileElement> getMobileiOSElementAppiumDriver(Optional<DesiredCapabilities> iOSCaps) throws Throwable {
        DesiredCapabilities desiredCapabilities = iOSCaps.isPresent() ? iOSCaps.get() : this.desiredCapabilityManager.iosNative();
        return (AppiumDriver<MobileElement>)new IOSDriver(this.appiumServerManager.getAppiumUrl(), (Capabilities)desiredCapabilities);
    }

    public void startAppiumDriverInstance(Optional<DesiredCapabilities> iosCaps, Optional<DesiredCapabilities> androidCaps) throws Throwable {
        String platform = (System.getenv("Platform") != null) ? System.getenv("Platform") : this.prop.getProperty("Platform");
        if (((String)ConfigFileManager.configFileMap.get("APP_TYPE")).equalsIgnoreCase("web")) {
            if ((System.getProperty("os.name").toLowerCase().contains("mac") && platform
                    .equalsIgnoreCase("iOS")) || platform
                    .equalsIgnoreCase("Both")) {
                if (IOSDeviceConfiguration.deviceUDIDiOS
                        .contains(DeviceManager.getDeviceUDID())) {
                    IOSDriver iOSDriver = new IOSDriver(this.appiumServerManager.getAppiumUrl(), (Capabilities)this.desiredCapabilityManager.iosWeb());
                    setDriver((AppiumDriver)iOSDriver);
                } else if (!IOSDeviceConfiguration.deviceUDIDiOS.contains(DeviceManager.getDeviceUDID())) {
                    AndroidDriver androidDriver = new AndroidDriver(this.appiumServerManager.getAppiumUrl(), (Capabilities)this.desiredCapabilityManager.androidWeb());
                    setDriver((AppiumDriver)androidDriver);
                }
            } else {
                AndroidDriver androidDriver = new AndroidDriver(this.appiumServerManager.getAppiumUrl(), (Capabilities)this.desiredCapabilityManager.androidWeb());
                setDriver((AppiumDriver)androidDriver);
            }
        } else if ((System.getProperty("os.name").toLowerCase().contains("mac") && platform
                .equalsIgnoreCase("iOS")) || platform
                .equalsIgnoreCase("Both")) {
            if (IOSDeviceConfiguration.deviceUDIDiOS
                    .contains(DeviceManager.getDeviceUDID())) {
                AppiumDriver<MobileElement> currentDriverSession = getMobileiOSElementAppiumDriver(iosCaps);
                setDriver(currentDriverSession);
            } else if (!IOSDeviceConfiguration.deviceUDIDiOS.contains(DeviceManager.getDeviceUDID())) {
                AppiumDriver<MobileElement> currentDriverSession = getMobileAndroidElementAppiumDriver(androidCaps);
                setDriver(currentDriverSession);
            }
        } else {
            AppiumDriver<MobileElement> currentDriverSession = getMobileAndroidElementAppiumDriver(androidCaps);
            setDriver(currentDriverSession);
        }
    }

    public void startAppiumDriverInstance() throws Throwable {
        DesiredCapabilities iOS = null;
        DesiredCapabilities android = null;
        if (DeviceManager.getMobilePlatform().equals(MobilePlatform.ANDROID)) {
            android = getDesiredAndroidCapabilities(android);
        } else {
            iOS = getDesiredIOSCapabilities(iOS);
        }
        System.out.println("Caps generated" + android + iOS);
        startAppiumDriverInstance(Optional.ofNullable(iOS), Optional.ofNullable(android));
        Thread.sleep(3000L);
    }

    public DesiredCapabilities getDesiredIOSCapabilities(DesiredCapabilities iOS) throws Throwable {
        this.desiredCapabilityBuilder
                .buildDesiredCapability("iOS");
        iOS = DesiredCapabilityBuilder.getDesiredCapability();
        return iOS;
    }

    public DesiredCapabilities getDesiredAndroidCapabilities(DesiredCapabilities android) throws Throwable {
        this.desiredCapabilityBuilder
                .buildDesiredCapability("android");
        android = DesiredCapabilityBuilder.getDesiredCapability();
        return android;
    }

    public void stopAppiumDriver() {
        getDriver().quit();
    }
}
