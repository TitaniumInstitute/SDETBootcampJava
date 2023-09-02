package com.ti.appium.android;

import com.ti.appium.android.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class LocatorsExample extends AndroidBaseTest {
    @Test
    void verifyWifiSettingsAreModified() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//*[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("//*[@text='WiFi settings']")).click();
        Thread.sleep(1500);
    }
}
