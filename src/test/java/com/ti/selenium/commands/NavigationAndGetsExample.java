package com.ti.selenium.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationAndGetsExample {
    WebDriver driver;
    String demoSiteUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    String googleSite = "https://www.google.com";

    @BeforeTest
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    void turnDown() {
        driver.quit();
    }

    @Test
    void validateNavigationAndGetCommands() {
        driver.navigate().to(googleSite);

        System.out.println(String.format("The Web page title is %s", driver.getTitle()));
        System.out.println(String.format("The URL is %s", driver.getCurrentUrl()));

         wait(2);

        driver.get(demoSiteUrl);

        System.out.println("***********************************************");
        System.out.println(String.format("The Web page title is %s", driver.getTitle()));
        System.out.println(String.format("The URL is %s", driver.getCurrentUrl()));
        System.out.println(String.format("The source code is %s", driver.getPageSource()));

        wait(2);

        driver.navigate().back();

        wait(2);

        driver.navigate().forward();

        wait(2);
    }

    void wait(int seg) {
        try {
            Thread.sleep(seg * 1000);
        } catch (InterruptedException ie) {
            System.err.println(ie.getMessage());
        }
    }
}
