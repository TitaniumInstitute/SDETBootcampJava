package com.ti.appium.ios.gestures;

import com.ti.appium.ios.IOSBaseTes;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LongPressExample extends IOSBaseTes {

    @Test
    void longPressExample(){
        iosDriver.findElement(AppiumBy.accessibilityId("Steppers")).click();
        WebElement itemIncrement = iosDriver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Increment\"`][1]"));

        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)itemIncrement).getId());
        params.put("duration", 5);

        iosDriver.executeScript("mobile:touchAndHold", params);
    }
}
