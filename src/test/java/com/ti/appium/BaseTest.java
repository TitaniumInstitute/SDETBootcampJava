package com.ti.appium;

import com.ti.baseuimobile.DeviceOSType;
import com.ti.baseuimobile.MobileDriverFactory;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeTest
    public void setup(){
        MobileDriverFactory.setAppName("Android.SauceLabs.Mobile.Sample.apk");
        MobileDriverFactory.setDeviceName("S21 plus API 30");
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        MobileDriverFactory.setAppActivity("com.swaglabsmobileapp.MainActivity");
        MobileDriverFactory.getInstance().setMobileDriver(DeviceOSType.ANDROID,service);
    }

    @AfterTest
    public void turndown(){
        MobileDriverFactory.getInstance().removeMobileDriver();
    }
}
