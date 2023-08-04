package com.ti.selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportsExample extends BaseTestClass {
    String destFile;
    String dateOption = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    ExtentReports extentReports;
    ExtentSparkReporter extentSparkReporter;
    ExtentTest extentTest;

    String getScreenshot(WebElement element, String screenshotName) {
        destFile = createFolder(System.getProperty("user.dir") + "/results/screenshots") + "/" + screenshotName + dateOption + ".png";
        try {
            FileHandler.copy((element == null) ?
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)
                    : element.getScreenshotAs(OutputType.FILE), new File(destFile));
        } catch (IOException e) {
            System.err.println("Class ScreenshotExample | Method getScreenshot | Exception: " + e.getMessage());
        }

        return destFile;
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
    void navigateToDemoSite() throws IOException {
        driver.navigate().to(demoSiteUrl);
        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter("results/TUReport.html");
        extentSparkReporter.loadJSONConfig(new File("./src/main/resources/extent-reports-config.json"));
        extentReports.attachReporter(extentSparkReporter);
    }

    @Test
    void verifyRegisterLinkIsNotBroken() {
        extentTest = extentReports.createTest("verifyRegisterLinkIsNotBroken");
        WebElement lnkRegister = driver.findElement(By.linkText("Register"));
        getScreenshot(lnkRegister, "RegisterLink");
        lnkRegister.click();
        extentTest.pass(String.valueOf(Status.PASS)).addScreenCaptureFromPath(getScreenshot(null, "demo"));
        Assert.assertTrue(driver.getTitle().contains("Registration Form"));
    }

    @Test
    void verifyLostPasswordLinkIsNotBroken() {
        extentTest = extentReports.createTest("verifyLostPasswordLinkIsNotBroken");
        try {
            driver.findElement(By.linkText("Lost your pas")).click();
            Assert.assertTrue(driver.getTitle().contains("Lost Password"));
        } catch (WebDriverException we) {
            extentTest.fail(we.getMessage()).addScreenCaptureFromPath(getScreenshot(null, "WebDriverException"));
            Assert.fail(we.getMessage());
        }
    }

    @AfterClass
    void flushExtentReport() {
        extentReports.flush();
    }
}
