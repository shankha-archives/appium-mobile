package com.frontline.manager;

import com.frontline.config.ConfigFileManager;
import com.frontline.config.Log;
import com.frontline.platforms.IOSDeviceConfiguration;
import com.frontline.utils.AvailablePorts;
import com.frontline.utils.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.Platform;

public class AppiumServerManager {
    private AvailablePorts ap;

    private IOSDeviceConfiguration iosDeviceConfiguration;

    private ConfigFileManager configFileManager;

    private static ThreadLocal<AppiumDriverLocalService> appiumDriverLocalService = new ThreadLocal<>();

    ServerArgument webKitProxy;

    private static AppiumDriverLocalService getServer() {
        return appiumDriverLocalService.get();
    }

    private static void setServer(AppiumDriverLocalService server) {
        appiumDriverLocalService.set(server);
    }

    public AppiumServerManager() throws IOException {
        this.webKitProxy = new ServerArgument() {
            public String getArgument() {
                return "--webkit-debug-proxy-port";
            }
        };
        this.iosDeviceConfiguration = new IOSDeviceConfiguration();
        this.ap = new AvailablePorts();
        this.configFileManager = ConfigFileManager.getInstance();
    }

    public String chromeDriverPath() {
        String chromepath = null;
        Platform current = Platform.getCurrent();
        if (this.configFileManager.containsKey("CHROMEDRIVER") && this.configFileManager.getProperty("CHROMEDRIVER") != null && this.configFileManager.getProperty("CHROMEDRIVER") != "") {
            chromepath = this.configFileManager.getProperty("CHROMEDRIVER");
        } else if (Platform.MAC.is(current) || Platform.LINUX.is(current)) {
            chromepath = System.getProperty("user.dir") + "/lib/chromedriver";
        } else {
            chromepath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
        }
        return chromepath;
    }

    private void startAppiumServerForAndroid(String methodName) throws Exception {
        Log.INFO("*****************************************\n");
        Log.INFO("Starting Appium Server for Android Device::" + DeviceManager.getDeviceUDID() + "\n");
        Log.INFO("*****************************************\n");
        int port = this.ap.getPort();
        int bootstrapPort = this.ap.getPort();
        AppiumServiceBuilder builder = (new AppiumServiceBuilder()).withAppiumJS(new File((String)ConfigFileManager.configFileMap.get("APPIUM_JS_PATH"))).withArgument((ServerArgument)GeneralServerFlag.LOG_LEVEL, "info").withLogFile(new File(System.getProperty("user.dir") + "/target/appiumlogs/" + DeviceManager.getDeviceUDID() + "__" + methodName + ".txt")).withArgument((ServerArgument)AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, Integer.toString(bootstrapPort)).withIPAddress("127.0.0.1").withArgument((ServerArgument)AndroidServerFlag.SUPPRESS_ADB_KILL_SERVER).usingPort(port);
        AppiumDriverLocalService appiumDriverLocalService = (AppiumDriverLocalService)builder.build();
        appiumDriverLocalService.start();
        setServer(appiumDriverLocalService);
    }

    private void startAppiumServerForAndroidWeb(String methodName) throws Exception {
        Log.INFO("*******************************************\n");
        Log.INFO("Starting Appium Server for Android Device::" + DeviceManager.getDeviceUDID() + "\n");
        Log.INFO("*******************************************\n");
        int port = this.ap.getPort();
        int chromePort = this.ap.getPort();
        int bootstrapPort = this.ap.getPort();
        AppiumServiceBuilder builder = (new AppiumServiceBuilder()).withAppiumJS(new File((String)ConfigFileManager.configFileMap.get("APPIUM_JS_PATH"))).withArgument((ServerArgument)GeneralServerFlag.LOG_LEVEL, "info").withLogFile(new File(System.getProperty("user.dir") + "/target/appiumlogs/" + DeviceManager.getDeviceUDID() + "__" + methodName + ".txt")).withArgument((ServerArgument)AndroidServerFlag.CHROME_DRIVER_PORT, Integer.toString(chromePort)).withArgument((ServerArgument)AndroidServerFlag.CHROME_DRIVER_EXECUTABLE, chromeDriverPath()).withArgument((ServerArgument)AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, Integer.toString(bootstrapPort)).withIPAddress("127.0.0.1").withArgument((ServerArgument)AndroidServerFlag.SUPPRESS_ADB_KILL_SERVER).usingPort(port);
        AppiumDriverLocalService appiumDriverLocalService = (AppiumDriverLocalService)builder.build();
        appiumDriverLocalService.start();
        setServer(appiumDriverLocalService);
    }

    private void startAppiumServerForIOS(String methodName) throws Exception {
        String webKitPort = this.iosDeviceConfiguration.startIOSWebKit();
        System.out
                .println("****************************************\n");
        System.out.println("Starting Appium Server for IOS::" + DeviceManager.getDeviceUDID() + "\n");
        System.out
                .println("***************************************\n");
        File classPathRoot = new File(System.getProperty("user.dir"));
        int port = this.ap.getPort();
        AppiumServiceBuilder builder = (new AppiumServiceBuilder()).withAppiumJS(new File((String)ConfigFileManager.configFileMap.get("APPIUM_JS_PATH"))).withArgument((ServerArgument)GeneralServerFlag.LOG_LEVEL, "info").withLogFile(new File(System.getProperty("user.dir") + "/target/appiumlogs/" + DeviceManager.getDeviceUDID() + "__" + methodName + ".txt")).withArgument(this.webKitProxy, webKitPort).withIPAddress("127.0.0.1").withArgument((ServerArgument)GeneralServerFlag.LOG_LEVEL, "debug").withArgument((ServerArgument)GeneralServerFlag.TEMP_DIRECTORY, (new File(String.valueOf(classPathRoot))).getAbsolutePath() + "/target/tmp_" + port).usingPort(port);
        AppiumDriverLocalService appiumDriverLocalService = (AppiumDriverLocalService)builder.build();
        appiumDriverLocalService.start();
        setServer(appiumDriverLocalService);
    }

    public URL getAppiumUrl() {
        return getServer().getUrl();
    }

    private void destroyAppiumNode() {
        getServer().stop();
        if (getServer().isRunning()) {
            System.out.println("AppiumServer didn't shut... Trying to quit again....");
            getServer().stop();
        }
    }

    public void startAppiumServer(String methodName) throws Exception {
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            if (DeviceManager.getMobilePlatform().equals(MobilePlatform.IOS)) {
                startAppiumServerForIOS(methodName);
            } else if (this.configFileManager.getProperty("APP_TYPE").equalsIgnoreCase("web")) {
                startAppiumServerForAndroidWeb(methodName);
            } else {
                startAppiumServerForAndroid(methodName);
            }
        } else if (this.configFileManager.getProperty("APP_TYPE").equalsIgnoreCase("web")) {
            startAppiumServerForAndroidWeb(methodName);
        } else {
            startAppiumServerForAndroid(methodName);
        }
    }

    public void stopAppiumServer() throws IOException, InterruptedException {
        destroyAppiumNode();
        if (DeviceManager.getMobilePlatform().equals(MobilePlatform.IOS))
            this.iosDeviceConfiguration.destroyIOSWebKitProxy();
    }
}
