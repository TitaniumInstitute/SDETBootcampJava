package com.ti.selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElementExample {
    WebDriver driver;
    String demoSiteUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    String actResult = "";
    String expResult = "Titanium School";
    String username = "admin";
    String password = "G3-ySzY%";

    WebElement txtUsername;

    @BeforeTest
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //txtUsername = driver.findElement(By.id("user_login"));
    }

    @Test
    void firstTest() throws InterruptedException {
        driver.navigate().to(demoSiteUrl);

        txtUsername = driver.findElement(By.id("user_login"));
        txtUsername.clear();
        txtUsername.sendKeys(username);

        WebElement txtPassword = driver.findElement(By.name("pwd"));
        txtPassword.clear();
        txtPassword.sendKeys(password);

        WebElement chkRememberMe = driver.findElement(By.cssSelector("#rememberme"));
        chkRememberMe.click();

        WebElement btnLogin = driver.findElement(By.xpath("//input[contains(@value,'Log')]"));
        btnLogin.click();

        WebElement lblTitaniumTitle = driver.findElement(By.className("wpsp-schoolname"));
        actResult = lblTitaniumTitle.getText();


        Assert.assertEquals(actResult, expResult, "El texto no es igual");
        Thread.sleep(2000);

    }

    @AfterTest
    void turnDown() {
        driver.quit();
    }
}
