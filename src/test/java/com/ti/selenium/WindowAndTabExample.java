package com.ti.selenium;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class WindowAndTabExample extends BaseTestClass {

    String googleSiteURL = "https://www.google.com";
    String WpSchoolURL = "https://wpschoolpress.com/";

    @Test
    void mangeWindowsAndTabs() {
        driver.navigate().to(demoSiteUrl);
        String originalTab = driver.getWindowHandle();
        System.out.println("WindowID: " + originalTab);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(WpSchoolURL);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to(googleSiteURL);

        wait(3);

        driver.switchTo().window(originalTab);
        driver.close();
        wait(2);
    }

}
