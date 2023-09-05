package com.ti.appium.ios;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class LocatorsExample extends IOSBaseTest {

    @Test
    void locatorsIosTest() throws InterruptedException {
        iosDriver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        iosDriver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();
        iosDriver.findElement(AppiumBy.className("XCUIElementTypeTextField")).sendKeys("Test Data");
        iosDriver.findElement(AppiumBy.accessibilityId("OK")).click();

        //iosDriver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm / Cancel'")).click();
        //iosDriver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'")).click();
        //iosDriver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH 'Confirm'")).click();
        iosDriver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'")).click();
        Thread.sleep(1000);
    }
}
