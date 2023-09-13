package com.ti.frameworks.datadriven.testcases.mobileui;

import com.ti.frameworks.screen.HomeScreen;
import com.ti.frameworks.screen.LoginScreen;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import static com.ti.frameworks.datadriven.dataproviders.ExcelArrayData.getExcelTableArray;

public class SauceLabLoginMobileExcelTest extends BaseMobileTest {
    Object[][] testArray;
    @DataProvider
    public Object[][] getExcelProviderData(Method method) throws IOException {
        if (method.getName().equals("loginWithRightCredentials")){
            testArray = getExcelTableArray("mobileusers.xlsx", "ValidUsers");
        }

        if (method.getName().equals("loginWithWrongCredentials")){
            testArray = getExcelTableArray("mobileusers.xlsx", "InvalidUsers");
        }

        return testArray;
    }
    @Test(priority = 2,dataProvider = "getExcelProviderData")
    void loginWithRightCredentials(LinkedHashMap<String, String> userData) {
        actualScreen = getInstance(LoginScreen.class);

        actualScreen.as(LoginScreen.class)
                .loginAs(userData.values().toArray()[0].toString())
                .withPassword(userData.values().toArray()[1].toString())
                .submitLogin();

        actualScreen.as(HomeScreen.class).verifyProductsText();
    }

    @Test(priority = 1, dataProvider = "getExcelProviderData")
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
