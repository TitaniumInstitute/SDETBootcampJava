package com.ti.appium.ios.gestures;

import com.ti.appium.ios.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwipeExample extends IOSBaseTest {
    @Test
    void swipeTest(){
        //Bundle ID
        Map<String, Object> params = new HashMap<>();
        params.put("bundleId","com.apple.mobileslideshow");
        iosDriver.executeScript("mobile:launchApp",params);
        List<WebElement> photos = iosDriver.findElements(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeCell' AND name CONTAINS 'Foto'"));
        System.out.println(photos.size());
        photos.get(0).click();
        Map<String, Object> photosParams = new HashMap<>();
        photosParams.put("direction","left");
        for (WebElement photo:photos){
            System.out.println(iosDriver.findElement(AppiumBy.className("XCUIElementTypeNavigationBar")).getAttribute("name"));
            iosDriver.executeScript("mobile:swipe",photosParams);
        }

        iosDriver.navigate().back();
    }
}
