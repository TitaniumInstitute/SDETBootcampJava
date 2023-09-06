package com.ti.baseuimobile.model;

import lombok.Getter;

@Getter
public class DriverOptions {
    private String appName;

    private String deviceName;

    private String appActivity;

    public DriverOptions setAppName(String appName) {
        this.appName = System.getProperty("user.dir")+"/src/test/resources/apps/"+appName;
        return this;
    }

    public DriverOptions setDeviceName(String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    public DriverOptions setAppActivity(String appActivity) {
        this.appActivity = appActivity;
        return this;
    }
}
