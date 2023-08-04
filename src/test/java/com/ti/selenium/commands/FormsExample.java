package com.ti.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormsExample extends BaseTestClass {

    String username = "admin";
    String password = "G3-ySzY%";

    @Test
    void fillingForms() throws InterruptedException {
        driver.navigate().to(demoSiteUrl);
        login();
        createNewTeacher();
    }

    void login() {
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

    void createNewTeacher() throws InterruptedException {
        WebElement spnTeachers = new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(driver -> driver.findElement(By.xpath("(//span[text()='Teachers'])[1]")));
        spnTeachers.click();

        driver.findElement(By.linkText("Create New")).click();

        personalDetails();

        accountInfo();
    }

    void personalDetails() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(driver -> driver.findElement(By.id("Female"))).click();

        WebElement txtFirstName = driver.findElement(By.name("firstname"));
        txtFirstName.clear();
        txtFirstName.sendKeys("Jessica");

        WebElement txtLastName = driver.findElement(By.id("lastname"));
        txtLastName.clear();
        txtLastName.sendKeys("Loren");

        WebElement txtStreet = driver.findElement(By.name("Address"));
        txtStreet.clear();
        txtStreet.sendKeys("Test Address #405");

        Select drpCountry = new Select(driver.findElement(By.id("Country")));
        drpCountry.selectByVisibleText("Colombia");

        Thread.sleep(2000);
    }

    void accountInfo() {
        String password = "T3stPAss.";

        WebElement txtEmail = driver.findElement(By.id("Email"));
        txtEmail.clear();
        txtEmail.sendKeys("test@gmail.com");

        WebElement txtUserName = driver.findElement(By.name("Username"));
        txtUserName.clear();
        txtUserName.sendKeys("jloren");
        String username = txtUserName.getAttribute("value");

        WebElement txtPassword = driver.findElement(By.id("Password"));
        txtPassword.clear();
        txtPassword.sendKeys(password);

        WebElement txtConfirmPassword = driver.findElement(By.name("ConfirmPassword"));
        txtConfirmPassword.clear();
        txtConfirmPassword.sendKeys(password);

        WebElement txtWorkHours = driver.findElement(By.id("whours"));
        txtWorkHours.clear();
        txtWorkHours.sendKeys("24");
        txtWorkHours.submit();
    }
}