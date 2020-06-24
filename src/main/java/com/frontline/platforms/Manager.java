package com.frontline.platforms;

import java.util.List;

public interface Manager {
    Device getDevice(String paramString) throws Exception;

    List<Device> getDevices() throws Exception;
}
