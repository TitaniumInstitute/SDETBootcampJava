package com.ti.appium.patronesdediseño;

import com.ti.appium.BaseTest;
import com.ti.baseuimobile.MobileDriverFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

public class MobileDriverFactoryExample extends BaseTest {
    AppiumDriver driver;
    @Test
    void exampleTest() throws InterruptedException {
        driver = MobileDriverFactory.getInstance().getMobileDriver();
        Thread.sleep(1500);
    }
}
