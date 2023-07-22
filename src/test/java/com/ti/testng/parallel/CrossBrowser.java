package com.ti.testng.parallel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {

    @Test
    @Parameters("browser")
    void executeCrossBrowser(String browser) {
        WebDriver driver;
        /*String navigatorStarted;
        navigatorStarted = switch (browser.toLowerCase()) {
            case "chrome" -> "Chrome Browser Started!" + Thread.currentThread().threadId();
            case "firefox" -> "FireFox Browser Started!" + Thread.currentThread().threadId();
            case "edge" -> "Edge Browser Started!" + Thread.currentThread().threadId();
            case "safari" -> "Safari Browser Started!" + Thread.currentThread().threadId();
            default -> "Option not included!" + Thread.currentThread().threadId();
        };

        System.out.println(navigatorStarted);*/
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            /*case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }*/
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
    }
}
