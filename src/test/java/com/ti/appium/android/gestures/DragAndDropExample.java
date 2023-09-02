package com.ti.appium.android.gestures;

import com.google.common.collect.ImmutableMap;
import com.ti.appium.android.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class DragAndDropExample extends AndroidBaseTest {
    @Test
    void dragAndDropTest() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        RemoteWebElement source = (RemoteWebElement) driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        //RemoteWebElement destination = (RemoteWebElement) driver.findElement((AppiumBy.id("io.appium.android.apis:id/drag_dot_2")));

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", source.getId(),
                "endX", 619,
                "endY", 568
        ));
    }
}
