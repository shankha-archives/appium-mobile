package com.frontline.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Log {
    public static final Logger logger = LogManager.getLogger(Log.class);

    public static void INFO(String log) {
        System.setProperty("org.uncommon.reporting.escape-output", "false");
        int getLineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String getMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(sdf
                .format(cal.getTime()) + " [INFO] [" + getMethodName + ":" + getLineNumber + "] - " + log);
    }

    public static void INFO(int log) {
        System.setProperty("org.uncommon.reporting.escape-output", "false");
        int getLineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String getMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(sdf
                .format(cal.getTime()) + " [INFO] [" + getMethodName + ":" + getLineNumber + "] - " + String.valueOf(log));
    }

    public static void ERROR(String log) {
        System.setProperty("org.uncommon.reporting.escape-output", "false");
        int getLineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String getMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(sdf.format(cal.getTime()) + " [ERROR] [" + getMethodName + ":" + getLineNumber + "] - " + log);
    }
}

