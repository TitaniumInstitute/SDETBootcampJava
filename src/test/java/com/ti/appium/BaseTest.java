package com.ti.appium;

import com.ti.appium.patronesdediseño.pf.LoginScreen;
import com.ti.baseuimobile.BaseScreen;
import com.ti.baseuimobile.DeviceOSType;
import com.ti.baseuimobile.MobileDriverFactory;
import com.ti.baseuimobile.model.DriverOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

public class BaseTest extends BaseScreen {
    AppiumDriverLocalService service;
    Map<String,String> userCredentials = new HashMap<>();
    @BeforeTest
    @Parameters({"deviceOsType","appName","ipAddress","deviceName"})
    public void setup(String deviceOsType, String appName, String ipAddress, String deviceName){
    //public void setup(String ... deviceSetup){
        DriverOptions options = new DriverOptions();
        options.setAppName(appName).setDeviceName(deviceName).setAppActivity("com.swaglabsmobileapp.MainActivity");

        service = new AppiumServiceBuilder()
                .withArgument(() -> "--use-plugins", "element-wait@2.0.3,gestures@3.0.0")
                .withIPAddress(ipAddress)
                .usingAnyFreePort()
                .build();

        service.start();
        MobileDriverFactory.getInstance().setMobileDriver(DeviceOSType.valueOf(deviceOsType),options);
        /*MobileDriverFactory.setAppName("Android.SauceLabs.Mobile.Sample.apk");
        MobileDriverFactory.setDeviceName("S21 plus API 30");
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        MobileDriverFactory.setAppActivity("com.swaglabsmobileapp.MainActivity");
        MobileDriverFactory.getInstance().setMobileDriver(DeviceOSType.ANDROID,service);*/
        userCredentials.put("username","standard_user");
        userCredentials.put("password","secret_sauce");

        actualScreen = getInstance(LoginScreen.class);
        actualScreen.as(LoginScreen.class)
                .loginAs(userCredentials.get("username"))
                .withPassword(userCredentials.get("password"))
                .submitLogin();

    }

    @AfterTest
    public void turndown(){
        MobileDriverFactory.getInstance().removeMobileDriver();
        service.stop();
    }
}
