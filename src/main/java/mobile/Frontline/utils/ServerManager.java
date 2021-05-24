package mobile.Frontline.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ServerManager {
    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    Utils utils = new Utils();
    Properties props = new PropertyManager().getProps();

    public ServerManager() throws IOException {
    }

    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void startServer(){
        utils.log().info("starting appium server");
        AppiumDriverLocalService server = WindowsGetAppiumService();
        server.start();
        if(server == null || !server.isRunning()){
            utils.log().fatal("Appium server not started. ABORT!!!");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
//        server.clearOutPutStreams();
        this.server.set(server);
        utils.log().info("Appium server started");
    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }

    public AppiumDriverLocalService WindowsGetAppiumService() {
        GlobalParams params = new GlobalParams();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(params.getPlatformName() + "_"
                        + params.getDeviceName() + File.separator + "Server.log")));
    }

//    public AppiumDriverLocalService MacGetAppiumService() {
//        GlobalParams params = new GlobalParams();
//        HashMap<String, String> environment = new HashMap<String, String>();
//       // environment.put("PATH", "/Program Files/Java/jdk1.8.0_181/Contents/Home/bin:D:/sdk-tools-windows-4333796/tools:D:/sdk-tools-windows-4333796/platform-tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin" + System.getenv("PATH"));
//       // environment.put("ANDROID_HOME", "D:/sdk-tools-windows-4333796");
//        //environment.put("JAVA_HOME", "/Program Files/Java/jdk1.8.0_181/Contents/Home");
//        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingDriverExecutable(new File(getClass().getResource(props.getProperty("node_path")).getPath()))
//                //.usingDriverExecutable(new File("C:/Program Files/nodejs/node"))
//                .withAppiumJS((new File(getClass().getResource(props.getProperty("aapium_path")).getPath())))
//               // .withAppiumJS(new File("Users/Rupa.kumari/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
//                .usingAnyFreePort()
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//                .withEnvironment(environment)
//                .withLogFile(new File(params.getPlatformName() + "_"
//                        + params.getDeviceName() + File.separator + "Server.log")));
//    }
}