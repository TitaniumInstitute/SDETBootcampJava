package com.ti.frameworks.datadriven.testcases.mobileui;

import com.ti.appium.patronesdediseño.pf.LoginScreen;
import com.ti.baseuimobile.BaseScreen;
import com.ti.baseuimobile.DeviceOSType;
import com.ti.baseuimobile.MobileDriverFactory;
import com.ti.baseuimobile.model.DriverOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

public class BaseMobileTest extends BaseScreen {
    AppiumDriverLocalService service;
    @BeforeSuite
    public void startService(){
        try {
            service = new AppiumServiceBuilder()
                    .withArgument(() -> "--use-plugins", "element-wait@2.0.3,gestures@3.0.0")
                    .withIPAddress("127.0.0.1")
                    .usingAnyFreePort()
                    .build();

            service.start();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @BeforeTest
    @Parameters({"deviceOsType","appName","ipAddress","deviceName"})
    public void setup(String deviceOsType, String appName, String ipAddress, String deviceName){
        DriverOptions options = new DriverOptions();
        options.setAppName(appName).setDeviceName(deviceName).setAppActivity("com.swaglabsmobileapp.MainActivity");

        MobileDriverFactory.getInstance().setMobileDriver(DeviceOSType.valueOf(deviceOsType),options);
    }

    @AfterTest
    public void turndown(){
        MobileDriverFactory.getInstance().removeMobileDriver();
    }

    @AfterSuite
    public void stopServer(){
        if(service!=null){
            service.stop();
        }
    }
}
