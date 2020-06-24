package com.frontline.platforms;
import com.frontline.config.ConfigFileManager;
import com.frontline.config.Log;
import com.frontline.config.MatrixResult;
import com.frontline.config.Utility;
import com.frontline.manager.DeviceManager;
import com.frontline.utils.AvailablePorts;
import com.frontline.utils.CommandPrompt;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class IOSDeviceConfiguration {
    public static ArrayList<String> deviceUDIDiOS = new ArrayList<>();

    private final ConfigFileManager prop;

    CommandPrompt commandPrompt = new CommandPrompt();

    AvailablePorts ap = new AvailablePorts();

    public HashMap<String, String> deviceMap = new HashMap<>();

    public Process p;

    public Process p1;

    public static List<String> validDeviceIds = new ArrayList<>();

    private SimManager simulatorManager;

    public static final int IOS_UDID_LENGTH = 40;

    public static final int SIM_UDID_LENGTH = 36;

    String profile = "system_profiler SPUSBDataType | sed -n -E -e '/(iPhone|iPad)/,/Serial/s/ *Serial Number: *(.+)/\\1/p'";

    public static ConcurrentHashMap<Long, Integer> iosDebugProxyProcess = new ConcurrentHashMap<>();

    public IOSDeviceConfiguration() throws IOException {
        this.prop = ConfigFileManager.getInstance();
        this.simulatorManager = new SimManager();
    }

    public ArrayList<String> getIOSUDID() {
        String devicesheet = System.getProperty("user.dir") + File.separator + "testdata" + File.separator + "deviceSheet.csv";
        MatrixResult matrixResult = Utility.instance().readCSV(devicesheet);
        for (MatrixResult.MatrixValue mV : matrixResult) {
            if ("Yes".equals(mV.getValue("Selected"))) {
                String deviceID = mV.getValue("deviceName");
                if (deviceID.length() > 26) {
                    if (validDeviceIds.size() > 0) {
                        if (validDeviceIds.contains(deviceID)) {
                            deviceUDIDiOS.add(deviceID);
                            Log.INFO("Adding ios device with user specified: " + deviceID);
                        }
                        continue;
                    }
                    Log.INFO("Adding all ios devices: " + deviceID);
                    deviceUDIDiOS.add(deviceID);
                }
            }
        }
        return deviceUDIDiOS;
    }

    public void installApp(String UDID, String appPath) throws InterruptedException, IOException {
        Log.INFO("Installing App on device********" + UDID);
        this.commandPrompt.runCommand("ideviceinstaller --udid " + UDID + " --install " + appPath);
    }

    public void unInstallApp(String UDID, String bundleID) throws InterruptedException, IOException {
        Log.INFO("Uninstalling App on device*******" + UDID);
        Log.INFO("ideviceinstaller --udid " + UDID + " -U " + bundleID);
        this.commandPrompt.runCommand("ideviceinstaller --udid " + UDID + " -U " + bundleID);
    }

    public boolean checkIfAppIsInstalled(String bundleID) throws InterruptedException, IOException {
        boolean appAlreadyExists = this.commandPrompt.runCommand("ideviceinstaller --list-apps").contains(bundleID);
        return appAlreadyExists;
    }

    public String getIOSDeviceProductTypeAndVersion() throws InterruptedException, IOException {
        if (DeviceManager.getDeviceUDID().length() == 40)
            return this.commandPrompt
                    .runCommandThruProcessBuilder("ideviceinfo --udid " +
                            DeviceManager.getDeviceUDID() + " | grep ProductType");
        return this.simulatorManager.getSimulatorDetails(DeviceManager.getDeviceUDID()).getName();
    }

    public String getDeviceName() throws InterruptedException, IOException {
        if (DeviceManager.getDeviceUDID().length() == 40)
            return this.commandPrompt.runCommand("idevicename --udid " +
                    DeviceManager.getDeviceUDID());
        return this.simulatorManager.getSimulatorDetails(DeviceManager.getDeviceUDID()).getName();
    }

    public String getIOSDeviceProductVersion() throws InterruptedException, IOException {
        if (DeviceManager.getDeviceUDID().length() == 40)
            return this.commandPrompt
                    .runCommandThruProcessBuilder("ideviceinfo --udid " +
                            DeviceManager.getDeviceUDID() + " | grep ProductVersion")
                    .replace("\n", "");
        return this.simulatorManager.getSimulatorDetails(DeviceManager.getDeviceUDID())
                .getOsVersion();
    }

    public boolean checkiOSDevice() throws Exception {
        String getIOSDeviceID = this.commandPrompt.runCommand("idevice_id --list");
        return getIOSDeviceID.contains(DeviceManager.getDeviceUDID());
    }

    public HashMap<String, String> setIOSWebKitProxyPorts() {
        try {
            int webkitproxyport = this.ap.getPort();
            this.deviceMap.put(DeviceManager.getDeviceUDID(), Integer.toString(webkitproxyport));
        } catch (InterruptedException|IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.deviceMap;
    }

    public String startIOSWebKit() throws IOException, InterruptedException {
        setIOSWebKitProxyPorts();
        String serverPath = this.prop.getProperty("APPIUM_JS_PATH");
        File file = new File(serverPath);
        File currentPath = new File(file.getParent());
        file = new File(currentPath + "/../..");
        String ios_web_lit_proxy_runner = file.getCanonicalPath() + "/bin/ios-webkit-debug-proxy-launcher.js";
        int port = 0;
        try {
            port = this.ap.getPort();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String webkitRunner = ios_web_lit_proxy_runner + " -c " + DeviceManager.getDeviceUDID() + ":" + port + " -d";
        this.p1 = java.lang.Runtime.getRuntime().exec(webkitRunner);
        Log.INFO("WebKit Proxy is started on device " +
                DeviceManager.getDeviceUDID() + " and with port number " + port + " and in thread " +

                Thread.currentThread().getId());
        iosDebugProxyProcess.put(Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(getPid(this.p1)));
        Log.INFO("Process ID's:" + iosDebugProxyProcess);
        return String.valueOf(port);
    }

    public long getPidOfProcess(Process p) {
        long pid = -1L;
        try {
            if (this.p1.getClass().getName().equals("java.lang.UNIXProcess")) {
                Field f = this.p1.getClass().getDeclaredField("pid");
                f.setAccessible(true);
                pid = f.getLong(this.p1);
                f.setAccessible(false);
            }
        } catch (Exception e) {
            pid = -1L;
        }
        return pid;
    }

    public int getPid(Process process) {
        try {
            Class<?> cProcessImpl = process.getClass();
            Field fPid = cProcessImpl.getDeclaredField("pid");
            if (!fPid.isAccessible())
                fPid.setAccessible(true);
            return fPid.getInt(process);
        } catch (Exception e) {
            return -1;
        }
    }

    public void destroyIOSWebKitProxy() throws IOException, InterruptedException {
        Thread.sleep(3000L);
        if (((Integer)iosDebugProxyProcess.get(Long.valueOf(Thread.currentThread().getId()))).intValue() != -1) {
            String process = "pgrep -P " + iosDebugProxyProcess.get(Long.valueOf(Thread.currentThread().getId()));
            Process p2 = java.lang.Runtime.getRuntime().exec(process);
            BufferedReader r = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            String command = "kill -9 " + r.readLine();
            Log.INFO("Kills webkit proxy");
            Log.INFO("******************" + command);
            java.lang.Runtime.getRuntime().exec(command);
        }
    }

    public void checkExecutePermissionForIOSDebugProxyLauncher() throws IOException {
        String serverPath = this.prop.getProperty("APPIUM_JS_PATH");
        File file = new File(serverPath);
        File currentPath = new File(file.getParent());
        file = new File(currentPath + "/../..");
        File executePermission = new File(file.getCanonicalPath() + "/bin/ios-webkit-debug-proxy-launcher.js");
        if (executePermission.exists())
            if (!executePermission.canExecute()) {
                executePermission.setExecutable(true);
                Log.INFO("Access Granted for iOSWebKitProxyLauncher");
            } else {
                Log.INFO("iOSWebKitProxyLauncher File already has access to execute");
            }
    }

    public void setValidDevices(List<String> deviceID) {
        deviceID.forEach(deviceList -> {
            if (deviceList.length() == 40)
                validDeviceIds.add(deviceList);
        });
    }

    public static ArrayList<String> getDeviceUDIDiOS() {
        return deviceUDIDiOS;
    }
}
