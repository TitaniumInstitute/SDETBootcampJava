package com.ti.appium.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

public class AppiumActionsExample extends AndroidBaseTest {

    @Test
    void miscellaneous() throws InterruptedException {
        //App package & App activity
        // Windows: adb shell dumpsys window | find "mCurrentFocus"
        // Mac: adb shell dumpsys window | grep -E 'mCurrentFocus'

        //driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        //driver.findElement(AppiumBy.xpath("//*[@content-desc='3. Preference dependencies']")).click();
        driver.executeScript("mobile: startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

        //Turn Screen
        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);

        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("//*[@text='WiFi settings']")).click();

        String alert = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        //Copy paste
        driver.setClipboardText("Gilberto Wifi Copied!!");
        driver.findElement(AppiumBy.id("android:id/edit")).clear();
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

        //Assert.assertEquals(alert,"Wifi settings");

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1500);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        Thread.sleep(1500);
    }



}
