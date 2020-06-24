package com.frontline.platforms;


import com.frontline.config.Log;
import com.frontline.utils.CommandPromptUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SimulatorManager implements ISimulatorManager {
    private final CommandPromptUtil commandPromptUtil;

    String ANSI_RED_BACKGROUND = "\033[41m";

    Process screenRecordProcess;

    public SimulatorManager() {
        this.commandPromptUtil = new CommandPromptUtil();
    }

    public List<Device> getAllSimulators(String osType) throws InterruptedException, IOException {
        List<Device> devices = getAllAvailableSimulators();
        List<Device> deviceListForOS = (List<Device>)devices.stream().filter(device -> osType.equals(device.getOs())).collect(toList());
        return deviceListForOS;
    }

    public Device getDevice(String deviceName, String osVersion, String osType) throws Throwable {
        List<Device> allSimulators = getAllSimulators(osType);
        Optional<Device> device = allSimulators.stream().filter(d -> (deviceName.equals(d.getName()) && osVersion.equals(d.getOsVersion()) && osType.equals(d.getOs()))).findFirst();
        return device.<Throwable>orElseThrow(() -> new RuntimeException("Device Not found with deviceName-" + deviceName + " osVersion-" + osVersion + " osType-" + osType));
    }

    public String getSimulatorUDID(String deviceName, String osVersion, String osType) throws Throwable {
        Device device = getDevice(deviceName, osVersion, osType);
        return device.getUdid();
    }

    public String getSimulatorState(String deviceName, String osVersion, String osType) throws Throwable {
        Device device = getDevice(deviceName, osVersion, osType);
        return device.getState();
    }

    public void bootSimulator(String deviceName, String osVersion, String osType) throws Throwable {
        String simulatorUDID = getSimulatorUDID(deviceName, osVersion, osType);
        this.commandPromptUtil.runCommandThruProcess("xcrun simctl boot " + simulatorUDID);
        Log.INFO(this.ANSI_RED_BACKGROUND + "Waiting for Simulator to Boot Completely.....");
        this.commandPromptUtil.runCommandThruProcess("xcrun simctl launch booted com.apple.springboard");
        this.commandPromptUtil.runCommandThruProcess("open -a Simulator --args -CurrentDeviceUDID " + simulatorUDID);
    }

    public Device getSimulatorDetailsFromUDID(String UDID) throws Throwable {
        List<Device> allSimulators = null;
        try {
            allSimulators = getAllAvailableSimulators();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Optional<Device> device = allSimulators.stream().filter(d -> UDID.equals(d.getUdid())).findFirst();
        return device.<Throwable>orElseThrow(() -> new RuntimeException("Device Not found"));
    }

    public void captureScreenshot(String UDID, String fileName, String fileDestination, String format) throws IOException, InterruptedException {
        String xcodeVersion = this.commandPromptUtil.runCommandThruProcess("xcodebuild -version").split("(\\n)|(Xcode)")[1].trim();
        if (Float.valueOf(xcodeVersion).floatValue() < 8.2D) {
            new RuntimeException("Screenshot capture is only supported with xcode version 8.2 and above");
        } else {
            this.commandPromptUtil.runCommandThruProcess("xcrun simctl io " + UDID + " screenshot " + fileDestination + "/" + fileName + "." + format);
        }
    }

    public boolean shutDownAllBootedSimulators() throws IOException, InterruptedException {
        List<String> bootedDevices = this.commandPromptUtil.runCommand("xcrun simctl list | grep Booted");
        bootedDevices
                .forEach(bootedUDID -> {
                    try {
                        this.commandPromptUtil.runCommandThruProcess("xcrun simctl shutdown " + bootedUDID);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        String bootedDeviceCountAfterShutDown = this.commandPromptUtil.runCommandThruProcess("xcrun simctl list | grep Booted | wc -l");
        if (Integer.valueOf(bootedDeviceCountAfterShutDown.trim()).intValue() == 0) {
            Log.INFO(this.ANSI_RED_BACKGROUND + "All Booted Simulators Shut...");
            return true;
        }
        Log.INFO(this.ANSI_RED_BACKGROUND + "Simulators that needs to be ShutDown are" + this.commandPromptUtil
                .runCommand("xcrun simctl list | grep Booted"));
        return false;
    }

    public List<Device> getAllBootedSimulators(String osType) throws InterruptedException, IOException {
        List<Device> allSimulators = getAllSimulators(osType);
        List<Device> bootedSim = (List<Device>)allSimulators.stream().filter(device -> device.getState().equalsIgnoreCase("Booted")).collect(Collectors.toList());
        return bootedSim;
    }

    public void uploadMediaToSimulator(String deviceName, String osVersion, String osType, String filePath) throws Throwable {
        String simulatorUDID = getSimulatorUDID(deviceName, osVersion, osType);
        String execute = "xcrun simctl addmedia " + simulatorUDID + " " + filePath;
        this.commandPromptUtil.execForProcessToExecute(execute).waitFor();
    }

    public void startScreenRecording(String pathWithFileName) throws IOException {
        Log.INFO("xcrun simctl io booted recordVideo " + pathWithFileName);
        this
                .screenRecordProcess = this.commandPromptUtil.execForProcessToExecute("xcrun simctl io booted recordVideo " + pathWithFileName);
        System.out.println(this.screenRecordProcess);
    }

    public Process startScreenRecording(String UDID, String pathWithFileName) throws IOException {
        Log.INFO("xcrun simctl io " + UDID + " recordVideo " + pathWithFileName);
        this
                .screenRecordProcess = this.commandPromptUtil.execForProcessToExecute("xcrun simctl io " + UDID + " recordVideo " + pathWithFileName);
        return this.screenRecordProcess;
    }

    public void stopScreenRecording() throws IOException, InterruptedException {
        Integer processId = Integer.valueOf(getPid(this.screenRecordProcess));
        String command = "kill -9 " + processId;
        Log.INFO("Stopping Video Recording" + command);
        this.commandPromptUtil.execForProcessToExecute(command);
    }

    public void installAppOnSimulator(String deviceName, String osVersion, String osType, String appPath) throws Throwable {
        String simulatorUDID = getSimulatorUDID(deviceName, osVersion, osType);
        String execute = "xcrun simctl install " + simulatorUDID + " " + appPath;
        this.commandPromptUtil.execForProcessToExecute(execute).waitFor();
    }

    public void uninstallAppFromSimulator(String deviceName, String osVersion, String osType, String bundleID) throws Throwable {
        String simulatorUDID = getSimulatorUDID(deviceName, osVersion, osType);
        String execute = "xcrun simctl uninstall " + simulatorUDID + " " + bundleID;
        this.commandPromptUtil.execForProcessToExecute(execute).waitFor();
    }

    public void createSimulator(String simName, String deviceName, String osVersion, String osType) throws Throwable {
        List<DeviceType> deviceTypes = getAllDeviceTypes();
        DeviceType deviceType = deviceTypes.stream().filter(d -> deviceName.equals(d.getName())).findFirst().get();
        List<IOSRuntime> deviceIOSRuntimes = getAllRuntimes();
        IOSRuntime IOSRuntime = deviceIOSRuntimes.stream().filter(r -> (osType.equals(r.getOs()) && osVersion.equals(r.getVersion()))).findFirst().get();
        this.commandPromptUtil.runCommandThruProcess("xcrun simctl create " + simName + " " + deviceType.getIdentifier() + " " + IOSRuntime
                .getIdentifier());
    }

    public void deleteSimulator(String deviceName, String osVersion, String osType) throws Throwable {
        String simulatorUDID = getSimulatorUDID(deviceName, osVersion, osType);
        this.commandPromptUtil.runCommandThruProcess("xcrun simctl delete " + simulatorUDID);
    }

    public List<Device> getAllAvailableSimulators() throws IOException, InterruptedException {
        CommandPromptUtil commandPromptUtil = new CommandPromptUtil();
        String simulatorJsonString = commandPromptUtil.runCommandThruProcess("xcrun simctl list -j devices");
        JSONObject simulatorsJson = new JSONObject(simulatorJsonString);
        JSONObject devicesByTypeJson = (JSONObject)simulatorsJson.get("devices");
        Iterator<String> keys = devicesByTypeJson.keys();
        List<Device> deviceList = new ArrayList<>();
        while (keys.hasNext()) {
            String key = keys.next();
            JSONArray devicesJson = (JSONArray)devicesByTypeJson.get(key);
            devicesJson.forEach(deviceJson -> deviceList.add(new Device((JSONObject)deviceJson, key)));
        }
        return deviceList;
    }

    private List<DeviceType> getAllDeviceTypes() throws IOException, InterruptedException {
        CommandPromptUtil commandPromptUtil = new CommandPromptUtil();
        String deviceTypesJSONString = commandPromptUtil.runCommandThruProcess("xcrun simctl list -j devicetypes");
        JSONObject devicesTypesJSON = new JSONObject(deviceTypesJSONString);
        JSONArray devicesTypes = devicesTypesJSON.getJSONArray("devicetypes");
        List<DeviceType> deviceTypes = new ArrayList<>();
        devicesTypes.forEach(deviceType -> {
            String name = ((JSONObject)deviceType).getString("name");
            String identifier = ((JSONObject)deviceType).getString("identifier");
            deviceTypes.add(new DeviceType(name, identifier));
        });
        return deviceTypes;
    }

    private List<IOSRuntime> getAllRuntimes() throws IOException, InterruptedException {
        CommandPromptUtil commandPromptUtil = new CommandPromptUtil();
        String runtimesJSONString = commandPromptUtil.runCommandThruProcess("xcrun simctl list -j runtimes");
        JSONArray runtimesJSON = (new JSONObject(runtimesJSONString)).getJSONArray("runtimes");
        List<IOSRuntime> IOSRuntimes = new ArrayList<>();
        runtimesJSON.forEach(runtime -> IOSRuntimes.add(new IOSRuntime((JSONObject)runtime)));
        return IOSRuntimes;
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

    private static <T> Collector<T, ?, List<T>> toList() {
        return Collectors.toCollection(ArrayList::new);
    }
}

