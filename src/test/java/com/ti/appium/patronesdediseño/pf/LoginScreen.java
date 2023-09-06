package com.ti.appium.patronesdediseño.pf;

import com.mysql.cj.log.Log;
import com.ti.baseuimobile.BaseScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy(accessibility = "test-Username")
    @iOSXCUITFindBy(accessibility = "test-Usuario")
    private RemoteWebElement txtUserName;

    @AndroidFindBy(accessibility = "test-Password")
    @iOSXCUITFindBy(accessibility = "test-Contraseña")
    private RemoteWebElement txtPassword;

    @AndroidFindBy(accessibility = "test-LOGIN")
    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    private RemoteWebElement btnLogin;

    public LoginScreen loginAs(String userName){
        txtUserName.clear();
        txtUserName.sendKeys(userName);
        return this;
    }

    public LoginScreen withPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
        return this;
    }

    public LoginScreen submitLogin(){
        btnLogin.click();
        return this;
    }
}
