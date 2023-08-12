package com.ti.selenium.patronesdediseño.pf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainPage {

    //private By txtUsername = By.id("user_login");
    @FindBy(id = "user_login")
    private WebElement txtUsername;

    @FindBy(name = "pwd")
    private WebElement txtPassword;

    @FindBy(css = "#rememberme")
    private WebElement chkRememberMe;

    @FindBy(xpath = "//input[contains(@value,'Log')]")
    private WebElement btnLogin;

    private void typeUsername(String username) {
        txtUsername.clear();
        txtUsername.sendKeys(username);
    }

    private void typePassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    private void checkRememberMe() {
        chkRememberMe.click();
    }

    private void clickLogin() {
        btnLogin.click();
    }

    public void login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        checkRememberMe();
        clickLogin();
    }


}
