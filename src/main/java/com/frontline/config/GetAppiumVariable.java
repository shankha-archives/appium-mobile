package com.frontline.config;

import java.io.IOException;

public class GetAppiumVariable {
    public static String appiumJsPath;

    public static String nodePath;

    static {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("mac")) {
                nodePath = ReadSystemEnvPath.getExepath("node") + "/node";
                appiumJsPath = nodePath = ReadSystemEnvPath.getExepath("appium") + "/appium";
            } else {
                nodePath = ReadSystemEnvPath.getExepath("node.exe") + "node.exe";
                appiumJsPath = System.getProperty("user.home") + ConfigFileManager.getInstance().getProperty("APPIUM_JS_PATH");
                appiumJsPath = appiumJsPath.replaceAll("\\\\", "/");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
