package com.ti.selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsExample {
    WebDriver driver;
    String demoSiteUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    String actResult = "";
    String expResult = "Titanium School";
    String username = "admin";
    String password = "G3-ySzY%";

    @BeforeTest
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void firstTest() throws InterruptedException {
        driver.navigate().to(demoSiteUrl);

        /*driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys(username);*/

        driver.findElement(with(By.tagName("input"))
                        .above(driver.findElement(By.name("pwd"))))
                .sendKeys(username);

        /*driver.findElement(By.name("pwd")).clear();
        driver.findElement(By.name("pwd")).sendKeys(password);*/
        driver.findElement(with(By.tagName("input"))
                        .below(By.id("user_login")))
                .sendKeys(password);

        //driver.findElement(By.cssSelector("#rememberme")).click();
        driver.findElement(with(By.tagName("input"))
                        .toLeftOf(By.xpath("//input[contains(@value,'Log')]")))
                .click();

        driver.findElement(By.xpath("//input[contains(@value,'Log')]")).click();

        actResult = driver.findElement(By.className("wpsp-schoolname")).getText();
        Assert.assertEquals(actResult, expResult, "El texto no es igual");
        Thread.sleep(2000);

    }

    @AfterTest
    void turnDown() {
        driver.quit();
    }
}
