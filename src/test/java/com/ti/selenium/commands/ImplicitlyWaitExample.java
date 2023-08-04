package com.ti.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitlyWaitExample extends BaseTestClass {

    String actResult = "";
    String expResult = "Titanium School";

    @Test
    void firstTest() throws InterruptedException {
        driver.navigate().to(demoSiteUrl);

        WebElement txtUsername = driver.findElement(By.id("user_login"));
        txtUsername.clear();
        txtUsername.sendKeys(username);

        WebElement txtPassword = driver.findElement(By.name("pwd"));
        txtPassword.clear();
        txtPassword.sendKeys(password);

        WebElement chkRememberMe = driver.findElement(By.cssSelector("#rememberme"));
        chkRememberMe.click();

        WebElement btnLogin = driver.findElement(By.xpath("//input[contains(@value,'Log')]"));
        btnLogin.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

        WebElement lblTitaniumTitle = driver.findElement(By.className("wpsp-schoolname"));
        actResult = lblTitaniumTitle.getText();
        System.out.println(actResult);

        Assert.assertEquals(actResult, expResult, "El texto no es igual");
        // Thread.sleep(2000);

    }
}
