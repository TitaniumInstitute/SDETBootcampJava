package com.ti.selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumExceptions {

    // https://www.selenium.dev/selenium/docs/api/py/common/selenium.common.exceptions.html
    WebDriver driver;
    String demoSiteUrl = "www.demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    String username = "admin";

    @BeforeTest
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void firstTest() throws InterruptedException {
        try {
            driver.navigate().to(demoSiteUrl);
        } catch (InvalidArgumentException iae) {
            driver.navigate().to("https://" + demoSiteUrl);
        }

        try {
            driver.findElement(By.id("user_logi")).sendKeys(username);
            Assert.assertTrue(true);
        } catch (NoSuchElementException nse) {
            Assert.fail("Test Failed: element is not found: " + nse.getMessage());
        }


    }

    @AfterTest
    void turnDown() {
        driver.quit();
    }
}
