package com.frontline.config;

import java.io.File;

public class ReadSystemEnvPath {
    private static boolean find(String name, File dir) {
        if (!dir.isDirectory())
            return false;
        for (String aFile : dir.list()) {
            if (aFile.contains(name))
                return true;
        }
        return false;
    }

    private static String[] listPaths() {
        return System.getenv("PATH")
                .split(System.getProperty("path.separator"));
    }

    public static String getExepath(String exeName) {
        for (String aPath : listPaths()) {
            if (find(exeName, new File(aPath)))
                return aPath;
        }
        return "";
    }
}
