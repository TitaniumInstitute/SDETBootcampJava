package com.ti.appium.android.gestures;

import com.ti.appium.android.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LongPressExample extends AndroidBaseTest {
    @Test
    void longPressTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        RemoteWebElement longPress = (RemoteWebElement) driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));

        //DRY principle - Don't Repeat Yourself
        driver.executeScript("mobile: longClickGesture", Map.of("elementId", longPress.getId(), "pressure", 0.5, "duration", 1500));
        WebElement lblTextList = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sample action']"));
        Assert.assertTrue(lblTextList.isDisplayed());
        Thread.sleep(1500);

    }
}
