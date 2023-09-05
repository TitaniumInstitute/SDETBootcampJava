package com.ti.appium.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class IOSBaseTest {
    protected IOSDriver iosDriver;
    AppiumDriverLocalService service;

    @BeforeTest
    public void setup() throws URISyntaxException, MalformedURLException {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start();
        XCUITestOptions options = new XCUITestOptions();
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        options.setDeviceName("iPhone 14");
        //options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/UIKitCatalog.app");
        //options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/TestApp.app");
        options.setWdaLaunchTimeout(Duration.ofSeconds(30));

        iosDriver = new IOSDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
    }

    @AfterTest
    public void turndown(){
        iosDriver.quit();
        service.stop();
    }
}
