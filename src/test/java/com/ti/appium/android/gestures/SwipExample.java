package com.ti.appium.android.gestures;

import com.ti.appium.android.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class SwipExample extends AndroidBaseTest {

    @Test
    void swipeTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();

        RemoteWebElement firstImage = (RemoteWebElement) driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));

        String firstTimeValue = firstImage.getAttribute("focusable");
        Assert.assertEquals(firstTimeValue, "true");

        driver.executeScript("mobile: swipeGesture", Map.of(
                "elementId", firstImage.getId(),
                "percent", 0.70,
                "direction", "left"));

        String secondTimeValue = firstImage.getAttribute("focusable");
        Assert.assertEquals(secondTimeValue, "false");
    }
}
