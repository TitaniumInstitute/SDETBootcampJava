package com.ti.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesAndAlertsExample extends BaseTestClass {

    WebDriverWait wait;
    String w3cSiteUrl = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";

    @Test
    void framesAlerts() throws InterruptedException {
        driver.navigate().to(w3cSiteUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.id("iframeResult"))));
            //driver.switchTo().frame("iframeResult");
        } catch (NoSuchFrameException nsfe) {
            System.err.println("No frame found! " + nsfe.getMessage());
        }

        WebElement btnTry = driver.findElement(By.xpath("//button[text()='Try it']"));
        wait.until(ExpectedConditions.elementToBeClickable(btnTry));
        btnTry.click();

        Thread.sleep(1500);

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert altWindow = driver.switchTo().alert();

            System.out.println(altWindow.getText());
            altWindow.sendKeys("Gilberto S.");
            altWindow.accept();
        } catch (NoAlertPresentException nae) {
            System.err.println("Alert not found! " + nae.getMessage());
        }


        String demoText = driver.findElement(By.id("demo")).getText();
        Assert.assertTrue(demoText.contains("Gil"), "Text not contained!");

        Thread.sleep(1500);
    }
}
