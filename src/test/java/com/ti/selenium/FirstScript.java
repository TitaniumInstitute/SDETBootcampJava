package com.ti.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstScript {
    WebDriver driver;
    String demoSiteUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    String actResult = "";
    String expResult = "TI Demo Site";

    @BeforeTest
    void setup() {
        WebDriverManager.chromedriver().setup();
        //Abrir navegador
        driver = new ChromeDriver();
    }

    @Test
    void firstTest() {
        //navegar al demo site
        //driver.get(demoSiteUrl);
        driver.navigate().to(demoSiteUrl);
        actResult = driver.getTitle();
        System.out.println(actResult);
        Assert.assertTrue(actResult.contains(expResult), "The title is not the same from the web page!!");
    }

    @AfterTest
    void turnDown() {
        driver.quit();
    }

}
