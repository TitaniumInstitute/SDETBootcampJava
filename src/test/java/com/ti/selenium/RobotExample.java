package com.ti.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class RobotExample extends BaseTestClass {

    String imagePath = "C:\\Users\\gilsa\\OneDrive\\Imágenes";
    String imageFile = "d_mysterio2_1024.jpg";
    Robot robot;

    @Test
    void robotTest() throws AWTException {
        driver.navigate().to(demoSiteUrl);
        login();

        WebElement spnTeachers = new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(driver -> driver.findElement(By.xpath("(//span[text()='Teachers'])[1]")));
        spnTeachers.click();

        driver.findElement(By.linkText("Create New")).click();

        wait(3);

        robot = new Robot();

        // Open window to load files
        moveAndClick(2340, 685);

        moveAndClick(2265, 514);

        selectFromClipboard(imagePath);

        // Seleccionar todos los archivos
        moveAndClick(2572, 415);

        moveAndClick(2588, 444);

        // Pegar el nombre del archivo y darle click
        moveAndClick(2113, 415);

        selectFromClipboard(imageFile);

        robot.keyRelease(KeyEvent.VK_ENTER);

        wait(5);
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

    private void moveAndClick(int x, int y) {
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1500);
    }

    private void selectFromClipboard(String elementForClipBoard) {

        // Ctrl + C
        StringSelection stringSelection = new StringSelection(elementForClipBoard);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        //Ctrl + V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // Enter
        robot.keyPress(KeyEvent.VK_ENTER);

    }
}
