package com.frontline.platforms;

public class SimManager {
    private SimulatorManager simulatorManager = new SimulatorManager();

    public Device getSimulatorDetails(String UDID) {
        Device iOS = null;
        try {
            iOS = this.simulatorManager.getSimulatorDetailsFromUDID(UDID);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return iOS;
    }

    public class Simulator {
        private String OS;

        private String DeviceName;

        public String getOS() {
            return this.OS;
        }

        public void setOS(String OS) {
            this.OS = OS;
        }

        public String getDeviceName() {
            return this.DeviceName;
        }

        public void setDeviceName(String deviceName) {
            this.DeviceName = deviceName;
        }
    }
}
