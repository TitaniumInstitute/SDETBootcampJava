package com.ti.frameworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends MainPage {

    //private By txtUsername = By.id("user_login");
    @FindBy(id = "user_login")
    @CacheLookup
    private WebElement txtUsername;

    @FindBy(name = "pwd")
    @CacheLookup
    private WebElement txtPassword;

    @FindBy(css = "#rememberme")
    @CacheLookup
    private WebElement chkRememberMe;

    @FindBy(xpath = "//input[contains(@value,'Log')]")
    @CacheLookup
    private WebElement btnLogin;

    @FindBy(id = "login_error")
    private WebElement lblError;

    public LoginPage loginAs(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOf(txtUsername));
        txtUsername.clear();
        txtUsername.sendKeys(username);
        return this;
    }

    public LoginPage password(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
        return this;
    }

    public LoginPage andRememberMe(boolean checked) {
        if (checked) {
            chkRememberMe.click();
        }
        return this;
    }

    public MainPage submitLogin() {
        btnLogin.click();
        return (MainPage) (actualPage = getInstance(MainPage.class));
    }

    private String getError(){
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOf(lblError));
        return lblError.getText();
    }

    public void verifyErrorText(String error){
        Assert.assertEquals(getError(),error);
    }

}
