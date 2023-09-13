package com.ti.frameworks.datadriven.screen;

import com.ti.baseuimobile.BaseScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.CacheLookup;

public class MenuScreen extends BaseScreen {
    @AndroidFindBy(xpath = "//*[@text='LOGOUT']")
    @iOSXCUITFindBy(accessibility = "test-CERRAR SESION")
    @CacheLookup
    private RemoteWebElement mnLogout;

    public MenuScreen andLogOut(){
        mnLogout.click();
        return this;
    }
}
