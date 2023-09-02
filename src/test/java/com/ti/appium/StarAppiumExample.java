package com.ti.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.lang.reflect.GenericArrayType;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class StarAppiumExample {
    AndroidDriver androidDriver;
    IOSDriver iosDriver;

    @Test(enabled = false)
    void androidLaunchExample() throws URISyntaxException, MalformedURLException, InterruptedException {
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("S231 plus API 30");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/ApiDemos-debug.apk");

        androidDriver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
        Thread.sleep(1000);
        androidDriver.quit();
        service.stop();
    }

    @Test
    void iosLaunchExample() throws URISyntaxException, MalformedURLException, InterruptedException {
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start();
        XCUITestOptions options = new XCUITestOptions();
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        options.setDeviceName("iPhone 14");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/UIKitCatalog.app");
        options.setWdaLaunchTimeout(Duration.ofSeconds(30));

        iosDriver = new IOSDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
        Thread.sleep(1000);
        iosDriver.quit();
        service.stop();
    }
}
