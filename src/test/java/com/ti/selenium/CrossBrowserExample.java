package com.ti.selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CrossBrowserExample extends BaseTestClass {

    @BeforeTest
    void navigateToDemoSite() {
        driver.navigate().to(demoSiteUrl);
    }

    @Test
    void verifyRegisterLinkIsNotBroken() {
        driver.findElement(By.linkText("Register")).click();
        Assert.assertTrue(driver.getTitle().contains("Registration Form"));
    }

    @Test
    void verifyLostPasswordLinkIsNotBroken() {
        driver.findElement(By.linkText("Lost your password?")).click();
        Assert.assertTrue(driver.getTitle().contains("Lost Password"));
    }
}
