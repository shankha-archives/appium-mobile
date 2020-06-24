package com.frontline.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommandPromptUtil {
    public String runCommandThruProcess(String command) throws InterruptedException, IOException {
        BufferedReader br = getBufferedReader(command);
        String allLine = "";
        String line;
        while ((line = br.readLine()) != null)
            allLine = allLine + "" + line + "\n";
        return allLine;
    }

    public List<String> runCommand(String command) throws InterruptedException, IOException {
        BufferedReader br = getBufferedReader(command);
        List<String> allLine = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null)
            allLine.add(line.replaceAll("[\\[\\](){}]", "_").split("_")[1]);
        return allLine;
    }

    private BufferedReader getBufferedReader(String command) throws IOException {
        List<String> commands = new ArrayList<>();
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            commands.add("/bin/sh");
            commands.add("-c");
        } else {
            commands.add("cmd.exe");
            commands.add("/c");
        }
        commands.add(command);
        ProcessBuilder builder = new ProcessBuilder(commands);
        Process process = builder.start();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        return new BufferedReader(isr);
    }

    public Process execForProcessToExecute(String cmd) throws IOException {
        Process pr = null;
        List<String> commands = new ArrayList<>();
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            commands.add("/bin/sh");
            commands.add("-c");
        } else {
            commands.add("cmd.exe");
            commands.add("/c");
        }
        commands.add(cmd);
        ProcessBuilder builder = new ProcessBuilder(commands);
        pr = builder.start();
        return pr;
    }

    public String runProcessCommandToGetDeviceID(String command) throws InterruptedException, IOException {
        BufferedReader br = getBufferedReader(command);
        String allLine = "";
        String line;
        while ((line = br.readLine()) != null)
            allLine = allLine.trim() + "" + line.trim() + "\n";
        return allLine.trim();
    }
}

