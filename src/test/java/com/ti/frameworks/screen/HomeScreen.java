package com.ti.frameworks.screen;

import com.ti.baseuimobile.BaseScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.CacheLookup;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PRODUCTOS']")
    @CacheLookup
    private RemoteWebElement lblProducts;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    @iOSXCUITFindBy(accessibility = "test-Menu")
    @CacheLookup
    private RemoteWebElement hmbMenu;

    protected String getProductsTitle(){
        return lblProducts.getText();
    }

    @SuppressWarnings("UnusedReturnValue")
    public HomeScreen verifyProductsText(){
        assert getProductsTitle().contains("PRODUCT");
        //Assert.assertEquals(getProductsTitle(),"PRODUCTOS");
        return this;
    }

    public MenuScreen displayMenu(){
        hmbMenu.click();
        return (MenuScreen) (actualScreen = getInstance(MenuScreen.class));
    }
}
