package com.ti.appium.gestures;

import com.google.common.collect.ImmutableMap;
import com.ti.appium.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollExample extends BaseTest {
    @BeforeMethod
    void goToView() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
    }

    @Test(enabled = false)
    void scrollUIAutomatorTest() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        Thread.sleep(1500);
    }

    @Test
    void scrollUsingGesturesTest() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        } while (canScrollMore);
    }
}
