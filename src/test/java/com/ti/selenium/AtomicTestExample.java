package com.ti.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AtomicTestExample extends BaseTestClass {

    @BeforeClass
    void login() {
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("localStorage.clear();");
        Cookie loginCookie = new Cookie("session-username", "standard_user");
        driver.manage().addCookie(loginCookie);
        ((JavascriptExecutor) driver).executeScript("localStorage.setItem('cart-contents','[4,1,0]')");
        driver.navigate().refresh();
    }

    @Test
    void validateShippingCartItems() {
        driver.navigate().to("https://www.saucedemo.com/cart.html");
        WebElement spnShoppingCart = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.className("shopping_cart_badge")));
        Assert.assertEquals(Integer.valueOf(spnShoppingCart.getText()), 3);
        wait(2);
    }

    @Test
    void validateUserCanCheckOut() {
        driver.navigate().to("https://www.saucedemo.com/checkout-step-one.html");
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(driver -> driver.findElement(By.id("first-name"))).sendKeys("Gilbert");
        driver.findElement(By.id("last-name")).sendKeys("Sanchez");
        driver.findElement(By.id("postal-code")).sendKeys("2022");
        driver.findElement(By.id("continue")).click();

        WebElement dvTotal = driver.findElement(By.xpath("(//div[contains(text(),'Total')])[2]"));
        Assert.assertTrue(dvTotal.getText().contains("60.45"));
        wait(2);


    }
}
