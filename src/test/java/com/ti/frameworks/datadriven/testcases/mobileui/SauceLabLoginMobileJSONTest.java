package com.ti.frameworks.datadriven.testcases.mobileui;

import com.ti.frameworks.datadriven.screen.HomeScreen;
import com.ti.frameworks.datadriven.screen.LoginScreen;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import static com.ti.frameworks.datadriven.dataproviders.JSONArrayData.getJsonTableArray;

public class SauceLabLoginMobileJSONTest extends BaseMobileTest {
    Object[][] testArray;
    @DataProvider
    public Object[][] getJSONProviderData(Method method){
        if (method.getName().equals("loginWithRightCredentials")){
            testArray = getJsonTableArray("mobileusers.json", "validUsers");
        }

        if (method.getName().equals("loginWithWrongCredentials")){
            testArray = getJsonTableArray("mobileusers.json", "invalidUsers");
        }

        return testArray;
    }
    @Test(priority = 2,dataProvider = "getJSONProviderData")
    void loginWithRightCredentials(LinkedHashMap<String, String> userData) {
        actualScreen = getInstance(LoginScreen.class);

        actualScreen.as(LoginScreen.class)
                .loginAs(userData.values().toArray()[0].toString())
                .withPassword(userData.values().toArray()[1].toString())
                .submitLogin();

        actualScreen.as(HomeScreen.class).verifyProductsText();
    }

    @Test(priority = 1, dataProvider = "getJSONProviderData")
    void loginWithWrongCredentials(LinkedHashMap<String, String> userData) {
        actualScreen = getInstance(LoginScreen.class);

        actualScreen.as(LoginScreen.class)
                .loginAs(userData.values().toArray()[0].toString())
                .withPassword(userData.values().toArray()[1].toString())
                .submitLogin();

        actualScreen = getInstance(LoginScreen.class);
        String errorMessage = actualScreen.as(LoginScreen.class).getError();

        if (errorMessage.toLowerCase().contains("password") || errorMessage.toLowerCase().contains("username")){
            actualScreen.as(LoginScreen.class).verifyErrorText(userData.values().toArray()[3].toString());
        }else {
            actualScreen.as(LoginScreen.class).verifyErrorText(userData.values().toArray()[2].toString());
        }
    }
}
