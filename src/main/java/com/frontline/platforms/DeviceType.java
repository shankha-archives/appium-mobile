package com.frontline.platforms;

public class DeviceType {
    private String name;

    private String identifier;

    public DeviceType(String name, String identifier) {
        this.name = name;
        this.identifier = identifier;
    }

    public String getName() {
        return this.name;
    }

    public String getIdentifier() {
        return this.identifier;
    }
}
