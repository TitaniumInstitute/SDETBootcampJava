package com.ti.frameworks.datadriven.screen;

import com.ti.baseuimobile.BaseScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy(accessibility = "test-Username")
    @iOSXCUITFindBy(accessibility = "test-Usuario")
    @CacheLookup
    private RemoteWebElement txtUserName;

    @AndroidFindBy(accessibility = "test-Password")
    @iOSXCUITFindBy(accessibility = "test-Contraseña")
    @CacheLookup
    private RemoteWebElement txtPassword;

    @AndroidFindBy(accessibility = "test-LOGIN")
    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    @CacheLookup
    private RemoteWebElement btnLogin;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "test-Error")
    private RemoteWebElement lblError;

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

    public HomeScreen submitLogin(){
        btnLogin.click();
        return (HomeScreen) (actualScreen = getInstance(HomeScreen.class));
    }

    public String getError(){
        return lblError.getText();
    }

    public void verifyErrorText(String error){
        Assert.assertEquals(getError(), error);
    }
}
