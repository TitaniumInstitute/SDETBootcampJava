package com.ti.appium.patronesdediseño;

import com.ti.appium.BaseTest;
import com.ti.baseuimobile.MobileDriverFactory;
import org.testng.annotations.Test;

public class MobileDriverFactoryExample extends BaseTest {
    @Test
    void exampleTest() throws InterruptedException {
        MobileDriverFactory.getInstance().getMobileDriver();
        Thread.sleep(1500);
    }
}
