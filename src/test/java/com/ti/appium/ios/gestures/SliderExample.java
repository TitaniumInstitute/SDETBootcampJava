package com.ti.appium.ios.gestures;

import com.ti.appium.ios.IOSBaseTest;
import com.ti.restassured.demo.testcases.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SliderExample extends IOSBaseTest {
    @Test
    void sliderTest() throws InterruptedException {
        WebElement slider = iosDriver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`label == \"AppElem\"`]"));
        slider.sendKeys("0%");
        System.out.println(slider.getAttribute("value"));
        Thread.sleep(2000);
        slider.sendKeys("1%");
        System.out.println(slider.getAttribute("value"));
        Thread.sleep(2000);
    }
}
