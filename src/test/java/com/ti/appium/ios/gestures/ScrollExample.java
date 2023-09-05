package com.ti.appium.ios.gestures;

import com.aventstack.extentreports.App;
import com.ti.appium.ios.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ScrollExample extends IOSBaseTest {

    @Test(enabled = false)
    void scrollTest() throws InterruptedException {
        WebElement lblWebView = iosDriver.findElement(AppiumBy.accessibilityId("Web View"));
        Map<String, Object> params = new HashMap<>();

        params.put("direction","down");
        params.put("element", ((RemoteWebElement)lblWebView).getId());

        iosDriver.executeScript("mobile:scroll", params);
        lblWebView.click();
        Thread.sleep(1000);
    }

    @Test
    void pickerViewTest(){
        iosDriver.findElement(AppiumBy.accessibilityId("Picker View")).click();

        WebElement pkwRed = iosDriver.findElement(AppiumBy.accessibilityId("Red color component value"));
        Map<String, Object> params = new HashMap<>();

        params.put("direction","down");
        params.put("element", ((RemoteWebElement)pkwRed).getId());

        do {
            iosDriver.executeScript("mobile:scroll", params);
        }while (!pkwRed.getText().contains("2"));
        //pkwRed.sendKeys("80");
        iosDriver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
        iosDriver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("105");
        String blueValue = iosDriver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText();

        Assert.assertEquals(blueValue, "105");
    }
}
