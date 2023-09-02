package com.ti.appium.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URI;

public class AndroidBaseTest {
    protected AndroidDriver driver;
    AppiumDriverLocalService service;

    @BeforeTest
    void setup() throws Exception {
        service = new AppiumServiceBuilder()
                .withArgument(() -> "--use-plugins", "element-wait@2.0.3,gestures@3.0.0")
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("S21 plus API 30");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/ApiDemos-debug.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
    }

    @AfterTest
    void tearDown() {
        driver.quit();
        service.stop();
    }
}
