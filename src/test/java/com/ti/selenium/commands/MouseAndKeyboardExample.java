package com.ti.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseAndKeyboardExample extends BaseTestClass {

    @Test
    void mouseAndKeyboard() {
        driver.navigate().to(demoSiteUrl);

        WebElement txtUsername = driver.findElement(By.id("user_login"));
        WebElement btnLogin = driver.findElement(By.xpath("//input[contains(@value,'Log')]"));

        Actions actionsBuilder = new Actions(driver);

        // Reverse Tab
        actionsBuilder
                .sendKeys(Keys.TAB)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.TAB)
                .keyUp(Keys.SHIFT)
                .build().perform();

        wait(3);

        Action actionToLogin = actionsBuilder
                .moveToElement(txtUsername)
                .click()
                .sendKeys("admin")
                .sendKeys(Keys.TAB)
                .keyDown(Keys.SHIFT)
                .sendKeys("g")
                .keyUp(Keys.SHIFT)
                .sendKeys("3-ySz")
                .keyDown(Keys.SHIFT)
                .sendKeys("y")
                .keyUp(Keys.SHIFT)
                .sendKeys("%")
                .moveToElement(btnLogin)
                .click()
                .build();

        actionToLogin.perform();

        driver.findElement(By.className("wpsp-username")).click();

        wait(4);

        WebElement lnkSignOut = driver.findElement(By.linkText("Sign Out"));
        actionsBuilder.click(lnkSignOut).build().perform();

    }
}
