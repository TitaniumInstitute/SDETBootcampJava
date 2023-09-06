package com.ti.appium.patronesdediseño.pf;

import com.ti.baseuimobile.BaseScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PRODUCTOS']")
    private RemoteWebElement lblProducts;

    protected String getProductsTitle(){
        return lblProducts.getText();
    }

    public HomeScreen verifyProductsText(){
        assert getProductsTitle().contains("PRODUCT");
        //Assert.assertEquals(getProductsTitle(),"PRODUCTOS");
        return this;
    }
}
