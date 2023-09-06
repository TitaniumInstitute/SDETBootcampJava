package com.ti.appium.patronesdediseño.testcases;

import com.ti.appium.BaseTest;
import com.ti.appium.patronesdediseño.pf.HomeScreen;
import org.testng.annotations.Test;

public class SauceLabLoginTests extends BaseTest {
    @Test
    void verifyLoginSuccessWithRightCredentials(){
        actualScreen.as(HomeScreen.class).verifyProductsText();
    }
}
