package com.ti.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotExample extends BaseTestClass {
    String destFile;
    String dateOption = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

    void getScreenshot(WebElement element, String screenshotName) {
        destFile = createFolder(System.getProperty("user.dir") + "/results/screenshots") + "/" + screenshotName + dateOption + ".png";
        try {
            FileHandler.copy((element == null) ?
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)
                    : element.getScreenshotAs(OutputType.FILE), new File(destFile));
        } catch (IOException e) {
            System.err.println("Class ScreenshotExample | Method getScreenshot | Exception: " + e.getMessage());
        }
    }

    private static String createFolder(String folderName) {
        File theDir = new File(folderName);
        if (!theDir.exists()) {
            System.out.println("Creating directory: " + theDir.getName());
            boolean result = false;

            try {
                theDir.mkdir();
                result = true;
            } catch (SecurityException se) {
                System.err.println("Class ScreenshotExample | Method createFolder | Exception: " + se.getMessage());
            }

            if (result) {
                System.out.println("Directory created!");
            }
        }

        return theDir.toString();
    }

    @BeforeClass
    void navigateToDemoSite() {
        driver.navigate().to(demoSiteUrl);
    }

    @Test
    void google() {

    }

    @Test
    void verifyRegisterLinkIsNotBroken() {
        WebElement lnkRegister = driver.findElement(By.linkText("Register"));
        getScreenshot(lnkRegister, "RegisterLink");
        lnkRegister.click();
        Assert.assertTrue(driver.getTitle().contains("Registration Form"));
    }

    @Test
    void verifyLostPasswordLinkIsNotBroken() {
        try {
            driver.findElement(By.linkText("Lost your pas")).click();
            Assert.assertTrue(driver.getTitle().contains("Lost Password"));
        } catch (WebDriverException we) {
            getScreenshot(null, "WebDriverException");
            Assert.fail(we.getMessage());
        }

    }
}
