package com.frontline.manager;


import com.frontline.config.ConfigFileManager;
import com.frontline.config.Log;
import com.frontline.platforms.AndroidDeviceConfiguration;
import com.frontline.platforms.IOSDeviceConfiguration;
import com.frontline.report.ExtentManager;
import com.github.lalyos.jfiglet.FigletFont;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppiumManager {
    private ConfigFileManager configFileManager;

    private DeviceAllocationManager deviceAllocationManager;

    protected int deviceCount = 0;

    Map<String, String> devices = new HashMap<>();

    ArrayList<String> iOSdevices = new ArrayList<>();

    private AndroidDeviceConfiguration androidDevice;

    private IOSDeviceConfiguration iosDevice;

    private MyTestExecutor myTestExecutor;

    List<Class> testcases;

    ExtentManager extentManager;

    public AppiumManager() throws IOException {
        this.deviceAllocationManager = DeviceAllocationManager.getInstance();
        this.configFileManager = ConfigFileManager.getInstance();
        this.iosDevice = new IOSDeviceConfiguration();
        this.androidDevice = new AndroidDeviceConfiguration();
        this.myTestExecutor = new MyTestExecutor();
        this.extentManager = new ExtentManager();
    }

    public AppiumManager(List<String> validDeviceIds) throws IOException {
        this.iosDevice = new IOSDeviceConfiguration();
        this.androidDevice = new AndroidDeviceConfiguration();
        this.configFileManager = ConfigFileManager.getInstance();
        this.androidDevice.setValidDevices(validDeviceIds);
        this.iosDevice.setValidDevices(validDeviceIds);
        this.deviceAllocationManager = DeviceAllocationManager.getInstance();
        this.myTestExecutor = new MyTestExecutor();
        this.extentManager = new ExtentManager();
    }

    public boolean runner(String pack, List<String> tests) throws Exception {
        figlet(this.configFileManager.getProperty("RUNNER"));
        return triggerTest(pack, tests);
    }

    public boolean runner(String pack) throws Exception {
        return runner(pack, new ArrayList<>());
    }

    public boolean triggerTest(String pack, List<String> tests) throws Exception {
        return parallelExecution(pack, tests);
    }

    public boolean parallelExecution(String pack, List<String> tests) throws Exception {
        String operSys = System.getProperty("os.name").toLowerCase();
        String platform = (System.getenv("Platform") != null) ? System.getenv("Platform") : this.configFileManager.getProperty("Platform");
        File f = new File(System.getProperty("user.dir") + "/target/appiumlogs/");
        if (!f.exists()) {
            Log.INFO("creating directory: Logs");
            boolean result = false;
            try {
                f.mkdir();
                result = true;
            } catch (SecurityException se) {
                se.printStackTrace();
            }
        }
        if ((this.androidDevice.getDevices() != null && platform.equalsIgnoreCase("android")) || platform.equalsIgnoreCase("Both")) {
            this.devices = this.androidDevice.getDevices();
            this.deviceCount = this.devices.size() / 3;
            File adb_logs = new File(System.getProperty("user.dir") + "/target/adblogs/");
            if (!adb_logs.exists()) {
                Log.INFO("creating directory: ADBLogs");
                boolean result = false;
                try {
                    adb_logs.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    se.printStackTrace();
                }
            }
            createSnapshotFolderAndroid("android");
        }
        if ((operSys.contains("mac") && platform.equalsIgnoreCase("iOS")) || platform.equalsIgnoreCase("Both"))
            if (this.deviceAllocationManager.getDevices().size() > 0) {
                this.iosDevice.checkExecutePermissionForIOSDebugProxyLauncher();
                this.iOSdevices = this.deviceAllocationManager.getDevices();
                this.deviceCount = this.iOSdevices.size();
                createSnapshotFolderiOS("iPhone");
            }
        if (this.deviceCount == 0) {
            figlet("No Devices Connected");
            System.exit(0);
        }
        Log.INFO("********************************************\n");
        Log.INFO("Total Number of devices detected::" + this.deviceCount + "\n");
        Log.INFO("********************************************\n");
        Log.INFO("starting running tests in threads");
        this.testcases = (List)new ArrayList<>();
        boolean hasFailures = false;
        if (this.configFileManager.getProperty("FRAMEWORK").equalsIgnoreCase("cucumber")) {
            deleteOutputDirectory();
            if (this.configFileManager.getProperty("RUNNER").equalsIgnoreCase("distribute")) {
                this.myTestExecutor
                        .constructXmlSuiteDistributeCucumber(this.deviceCount, this.deviceAllocationManager.getDevices());
                hasFailures = this.myTestExecutor.runMethodParallel();
            } else if (this.configFileManager.getProperty("RUNNER").equalsIgnoreCase("parallel")) {
                this.myTestExecutor
                        .constructXmlSuiteForParallelCucumber(this.deviceCount, this.deviceAllocationManager
                                .getDevices());
                hasFailures = this.myTestExecutor.runMethodParallel();
            }
        }
        return hasFailures;
    }

    public void createSnapshotFolderAndroid(String platform) throws Exception {
        for (int i = 1; i <= this.devices.size() / 3; i++) {
            String deviceSerial = this.devices.get("deviceID" + i);
            if (deviceSerial != null) {
                createPlatformDirectory(platform);
                File file = new File(System.getProperty("user.dir") + "/target/screenshot/" + platform + "/" + deviceSerial);
                if (!file.exists())
                    if (file.mkdir()) {
                        Log.INFO("Android " + deviceSerial + " Directory is created!");
                    } else {
                        Log.INFO("Failed to create directory!");
                    }
            }
        }
    }

    public void createSnapshotFolderiOS(String platform) {
        for (int i = 0; i < this.iOSdevices.size(); i++) {
            String deviceSerial = this.iOSdevices.get(i);
            createPlatformDirectory(platform);
            File file = new File(System.getProperty("user.dir") + "/target/screenshot/" + platform + "/" + deviceSerial);
            if (!file.exists())
                if (file.mkdir()) {
                    Log.INFO("IOS " + deviceSerial + " Directory is created!");
                } else {
                    Log.INFO("Failed to create directory!");
                }
        }
    }

    public void createPlatformDirectory(String platform) {
        File file2 = new File(System.getProperty("user.dir") + "/target/screenshot");
        if (!file2.exists())
            file2.mkdir();
        File file3 = new File(System.getProperty("user.dir") + "/target/screenshot/" + platform);
        if (!file3.exists())
            file3.mkdir();
    }

    public void deleteOutputDirectory() {
        File outputfile = new File(System.getProperty("user.dir") + "/src/test/java/output/");
        if (outputfile.exists()) {
            for (File file : outputfile.listFiles())
                file.delete();
            outputfile.delete();
        }
    }

    public static void figlet(String text) {
        String asciiArt1 = null;
        try {
            asciiArt1 = FigletFont.convertOneLine(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(asciiArt1);
    }
}
