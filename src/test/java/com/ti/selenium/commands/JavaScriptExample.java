package com.ti.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptExample extends BaseTestClass {
    JavascriptExecutor js;
    String pageLoadStatus = "";

    private void highLight(WebElement element) {
        js = (JavascriptExecutor) driver;
        for (byte iCnt = 0; iCnt < 3; iCnt++) {
            try {
                js.executeScript("arguments[0].setAttribute('style','background:yellow')", element);
                wait(1);
                js.executeScript("arguments[0].setAttribute('style','background:')", element);
            } catch (JavascriptException jse) {
                System.err.println("Class: JavaScriptExample | Method: highLight | Exception: " + jse.getMessage());
            }
        }
    }

    private void waitForPageToLoad() {
        try {
            js = (JavascriptExecutor) driver;
            do {
                pageLoadStatus = (String) js.executeScript("return document.readyState");
            } while (!pageLoadStatus.equals("complete"));
        } catch (JavascriptException jse) {
            System.err.println("Class: JavaScriptExample | Method: waitForPageToLoad | Exception: " + jse.getMessage());
        }
    }

    private void scrollWindow(String scrollType) {
        try {
            js = (JavascriptExecutor) driver;
            switch (scrollType) {
                case "up" -> js.executeScript("window.scrollBy(0,-250)");
                case "down" -> js.executeScript("window.scrollBy(0,250)");
                default -> System.err.println("Bad Option");
            }
        } catch (JavascriptException jse) {
            System.err.println("Class: JavaScriptExample | Method: scrollWindow | Exception: " + jse.getMessage());
        }
    }

    @Test
    void javascriptTest() {
        driver.navigate().to(demoSiteUrl);

        WebElement txtUsername = driver.findElement(By.id("user_login"));
        highLight(txtUsername);
        txtUsername.clear();
        txtUsername.sendKeys(username);

        WebElement txtPassword = driver.findElement(By.name("pwd"));
        highLight(txtPassword);
        txtPassword.clear();
        txtPassword.sendKeys(password);

        WebElement chkRememberMe = driver.findElement(By.cssSelector("#rememberme"));
        highLight(chkRememberMe);
        chkRememberMe.click();

        WebElement btnLogin = driver.findElement(By.xpath("//input[contains(@value,'Log')]"));
        highLight(btnLogin);
        //btnLogin.click();

        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnLogin);
        wait(1);

        waitForPageToLoad();

        scrollWindow("down");

        WebElement spnTeachers = new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(driver -> driver.findElement(By.xpath("(//span[text()='Teachers'])[1]")));

        Assert.assertTrue(spnTeachers.getText().contains("Teach"));
    }
}
