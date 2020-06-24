package com.frontline.platforms;

import java.io.IOException;
import java.util.List;

public interface ISimulatorManager {
    String getSimulatorState(String paramString1, String paramString2, String paramString3) throws Throwable;

    Device getDevice(String paramString1, String paramString2, String paramString3) throws Throwable;

    String getSimulatorUDID(String paramString1, String paramString2, String paramString3) throws Throwable;

    List<Device> getAllSimulators(String paramString) throws InterruptedException, IOException;

    void deleteSimulator(String paramString1, String paramString2, String paramString3) throws Throwable;

    void createSimulator(String paramString1, String paramString2, String paramString3, String paramString4) throws Throwable;

    void uninstallAppFromSimulator(String paramString1, String paramString2, String paramString3, String paramString4) throws Throwable;

    void installAppOnSimulator(String paramString1, String paramString2, String paramString3, String paramString4) throws Throwable;

    void bootSimulator(String paramString1, String paramString2, String paramString3) throws Throwable;

    Device getSimulatorDetailsFromUDID(String paramString) throws Throwable;

    void captureScreenshot(String paramString1, String paramString2, String paramString3, String paramString4) throws IOException, InterruptedException;

    boolean shutDownAllBootedSimulators() throws IOException, InterruptedException;

    List<Device> getAllBootedSimulators(String paramString) throws InterruptedException, IOException;

    void uploadMediaToSimulator(String paramString1, String paramString2, String paramString3, String paramString4) throws Throwable;

    void startScreenRecording(String paramString) throws IOException;

    void stopScreenRecording() throws IOException, InterruptedException;

    Process startScreenRecording(String paramString1, String paramString2) throws IOException;
}

