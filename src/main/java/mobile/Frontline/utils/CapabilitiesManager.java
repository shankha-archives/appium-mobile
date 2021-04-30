package mobile.Frontline.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try {
            utils.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();

            if (params.getEnvironmentName().equalsIgnoreCase("Cloud")) {
                String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
                String username = System.getenv("BROWSERSTACK_USERNAME");
                String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
                String app = System.getenv("BROWSERSTACK_APP_ID");

                caps.setCapability("browserstack.user", username);
                caps.setCapability("browserstack.key", accessKey);
                caps.setCapability("build", buildName);
                caps.setCapability("name", params.gettestName());

                caps.setCapability("app", app);
                caps.setCapability("device", params.getDeviceName());
//                caps.setCapability("device", "Google Pixel 3");
//                caps.setCapability("os_version", "9.0");
                caps.setCapability("os_version", params.getOSversion());

            }
            else if (params.getEnvironmentName().equalsIgnoreCase("Local") && params.getPlatformName().equalsIgnoreCase("Android"))
            {     caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
            caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());

            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
            caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
            caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
            caps.setCapability("systemPort", params.getSystemPort());
            caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
            //String androidAppUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
            String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                    + File.separator + "resources" + File.separator + "apps" + File.separator + "frontline.apk";
            utils.log().info("appUrl is" + androidAppUrl);
            caps.setCapability("app", androidAppUrl);
        }
        else if(params.getEnvironmentName().equalsIgnoreCase("Local") && params.getPlatformName().equalsIgnoreCase("iOS"))
        {    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
        caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
                    //String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
                    String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "Frontline.app";
                    utils.log().info("appUrl is" + iOSAppUrl);
                    caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
                    caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
                    caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
                    caps.setCapability("app", iOSAppUrl);
            }
            return caps;
        }
        catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
}
