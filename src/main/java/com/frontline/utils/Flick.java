package com.frontline.utils;


import com.frontline.config.Log;
import com.frontline.manager.DeviceManager;
import com.frontline.platforms.AndroidDeviceConfiguration;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

public class Flick extends CommandPrompt {
    public static ConcurrentHashMap<Long, Integer> androidScreenRecordProcess = new ConcurrentHashMap<>();

    AndroidDeviceConfiguration androidDeviceConfiguration = new AndroidDeviceConfiguration();

    Process screenRecord;

    public void stopVideoRecording(String className, String methodName, String videoFileName) throws IOException, InterruptedException {
        Log.INFO("**************Stopping Video Recording**************");
        flickRecordingCommand("stop", className, methodName, videoFileName);
    }

    public void startVideoRecording(String className, String methodName, String videoFileName) throws IOException, InterruptedException {
        Log.INFO("**************Starting Video Recording**************");
        flickRecordingCommand("start", className, methodName, videoFileName);
    }

    public void flickRecordingCommand(String command, String className, String methodName, String videoFileName) throws IOException, InterruptedException {
        String videoPath = System.getProperty("user.dir");
        if (DeviceManager.getDeviceUDID().length() != 40) {
            String videoLocationAndroid = videoPath + "/target/screenshot/android/" + DeviceManager.getDeviceUDID() + "/" + className + "/" + methodName;
            fileDirectoryCheck(videoLocationAndroid);
            if (command.equals("start")) {
                try {
                    if (!this.androidDeviceConfiguration.getDeviceManufacturer().equals("unknown") && this.androidDeviceConfiguration
                            .checkIfRecordable()) {
                        this
                                .screenRecord = Runtime.getRuntime().exec(this.androidDeviceConfiguration.screenRecord(methodName));
                        Log.INFO("ScreenRecording has started..." +
                                Thread.currentThread().getId());
                        androidScreenRecordProcess
                                .put(Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(getPid(this.screenRecord)));
                        Thread.sleep(1000L);
                    } else {
                        String android = "flick video -a " + command + " -p android -u " + DeviceManager.getDeviceUDID();
                        runCommandThruProcess(android);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (!this.androidDeviceConfiguration.getDeviceManufacturer().equals("unknown") && this.androidDeviceConfiguration
                    .checkIfRecordable()) {
                stopRecording();
                this.androidDeviceConfiguration
                        .pullVideoFromDevice(methodName, videoLocationAndroid)
                        .removeVideoFileFromDevice(methodName);
            } else {
                String android = "flick video -a " + command + " -p android -o " + videoLocationAndroid + " -n " + videoFileName + " -u " + DeviceManager.getDeviceUDID() + " --trace";
                runCommandThruProcess(android);
                Log.INFO("Stopping Video recording on Emulator");
                Thread.sleep(10000L);
            }
        } else {
            String ios, videoLocationIOS = videoPath + "/target/screenshot/iOS/" + DeviceManager.getDeviceUDID() + "/" + className + "/" + methodName;
            fileDirectoryCheck(videoLocationIOS);
            if (command.equals("start")) {
                ios = "flick video -a " + command + " -p ios -u " + DeviceManager.getDeviceUDID();
            } else {
                ios = "flick video -a " + command + " -p ios -o " + videoLocationIOS + " -n " + videoFileName + " -u " + DeviceManager.getDeviceUDID();
            }
            System.out.println(ios);
            try {
                runCommand(ios);
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fileDirectoryCheck(String folderPath) {
        File f = new File(folderPath);
        f.mkdirs();
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

    public void stopRecording() throws IOException {
        Integer processId = androidScreenRecordProcess.get(Long.valueOf(Thread.currentThread().getId()));
        if (processId.intValue() != -1) {
            String process = "pgrep -P " + processId;
            Process p2 = Runtime.getRuntime().exec(process);
            BufferedReader r = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            String command = "kill " + processId;
            Log.INFO("Stopping Video Recording");
            Log.INFO("******************" + command);
            try {
                runCommandThruProcess(command);
                Thread.sleep(10000L);
                Log.INFO("Killed video recording with exit code :" + command);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

