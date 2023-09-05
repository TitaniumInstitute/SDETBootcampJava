package com.ti.appium;

import com.ti.baseuimobile.DeviceOSType;
import com.ti.baseuimobile.MobileDriverFactory;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeTest
    @Parameters({"deviceOsType","appName","ipAddress","deviceName"})
    public void setup(String deviceOsType, String appName, String ipAddress, String deviceName){
    //public void setup(String ... deviceSetup){
        MobileDriverFactory.setAppName(appName);
        MobileDriverFactory.setDeviceName(deviceName);
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withArgument(() -> "--use-plugins", "element-wait@2.0.3,gestures@3.0.0")
                .withIPAddress(ipAddress)
                .usingAnyFreePort()
                .build();

        if (deviceOsType.equals(DeviceOSType.ANDROID.toString())){
            MobileDriverFactory.setAppActivity("com.swaglabsmobileapp.MainActivity");
        }
        MobileDriverFactory.getInstance().setMobileDriver(DeviceOSType.valueOf(deviceOsType),service);
        /*MobileDriverFactory.setAppName("Android.SauceLabs.Mobile.Sample.apk");
        MobileDriverFactory.setDeviceName("S21 plus API 30");
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        MobileDriverFactory.setAppActivity("com.swaglabsmobileapp.MainActivity");
        MobileDriverFactory.getInstance().setMobileDriver(DeviceOSType.ANDROID,service);*/
    }

    @AfterTest
    public void turndown(){
        MobileDriverFactory.getInstance().removeMobileDriver();
    }
}
