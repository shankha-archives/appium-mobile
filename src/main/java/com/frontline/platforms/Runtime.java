package com.frontline.platforms;


import org.json.JSONObject;

public class Runtime {
    private final String buildversion;

    private final boolean isAvailable;

    private final String name;

    private final String identifier;

    private final String version;

    private final String os;

    public Runtime(JSONObject runtimeJSON) {
        this.buildversion = runtimeJSON.getString("buildversion");
        this.name = runtimeJSON.getString("name");
        this.version = runtimeJSON.getString("version");
        this.identifier = runtimeJSON.getString("identifier");
        this.isAvailable = runtimeJSON.getString("availability").equals("(available)");
        this.os = this.name.split(" ")[0];
    }

    public String getBuildversion() {
        return this.buildversion;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public String getName() {
        return this.name;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getVersion() {
        return this.version;
    }

    public String getOs() {
        return this.os;
    }
}
