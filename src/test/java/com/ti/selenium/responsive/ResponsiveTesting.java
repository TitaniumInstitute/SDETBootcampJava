package com.ti.selenium.responsive;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ResponsiveTesting {

    WebDriver driver;
    String demoSiteUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    String username = "admin";
    String password = "G3-ySzY%";
    Map<String, String> deviceMobEmu;

    @BeforeTest
    void setup() {
        WebDriverManager.chromedriver().setup();
        deviceMobEmu = new HashMap<>();
    }

    @AfterMethod
    void turnDown() {
        driver.quit();
    }

    @AfterTest
    void clanMap() {
        deviceMobEmu.clear();
    }

    @Test(enabled = false, dataProviderClass = MobileEmulators.class, dataProvider = "mobileEmulations")
    void responsiveTest(String deviceEmulator) {
        deviceMobEmu.put("deviceName", deviceEmulator);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", deviceMobEmu);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
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
    }

    @Test(dataProviderClass = MobileEmulators.class, dataProvider = "mobileEmulationsDimensions")
    void responsiveTestDimensions(int width, int high) {
        driver = new ChromeDriver();

        Dimension dimension = new Dimension(width, high);
        driver.manage().window().setSize(dimension);

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
    }
}
