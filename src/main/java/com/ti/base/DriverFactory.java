package com.ti.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME -> driver.set(new ChromeDriver());
            case EDGE -> driver.set(new EdgeDriver());
            case FIREFOX -> driver.set(new FirefoxDriver());
        }
        driver.get().manage().window().maximize();
    }

    public void removeDriver() {
        if (driver.get() != null) {
            try {
                driver.get().quit();
                driver.remove();
            } catch (Exception e) {
                System.err.println("Unable to remove WebDrvier | Exception: " + e.getMessage());
            }
        }
    }
}
