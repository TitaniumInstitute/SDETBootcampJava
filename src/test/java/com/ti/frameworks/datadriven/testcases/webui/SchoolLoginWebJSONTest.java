package com.ti.frameworks.datadriven.testcases.webui;

import com.ti.frameworks.datadriven.pages.LoginPage;
import com.ti.frameworks.datadriven.pages.MainPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import static com.ti.frameworks.datadriven.dataproviders.JSONArrayData.getJsonTableArray;

public class SchoolLoginWebJSONTest extends BaseWebTest {
    Object[][] testArray;
    @DataProvider
    public Object[][] getJSONProviderData(Method method){
        if (method.getName().equals("loginWithRightCredentials")){
            testArray = getJsonTableArray("webusers.json", "validUsers");
        }

        if (method.getName().equals("loginWithWrongCredentials")){
            testArray = getJsonTableArray("webusers.json", "invalidUsers");
        }

        return testArray;
    }
    @Test(priority = 2,dataProvider = "getJSONProviderData")
    void loginWithRightCredentials(LinkedHashMap<String, String> userData) {
        actualPage = getInstance(LoginPage.class);

        actualPage.as(LoginPage.class)
                .loginAs(userData.values().toArray()[0].toString())
                .password(userData.values().toArray()[1].toString())
                .andRememberMe(true)
                .submitLogin();
        //Assert
        actualPage.as(MainPage.class).verifySchoolName();
    }

    @Test(priority = 1, dataProvider = "getJSONProviderData")
    void loginWithWrongCredentials(LinkedHashMap<String, String> userData) {
        actualPage = getInstance(LoginPage.class);

        actualPage.as(LoginPage.class)
                .loginAs(userData.values().toArray()[0].toString())
                .password(userData.values().toArray()[1].toString())
                .andRememberMe(true)
                .submitLogin();

        actualPage = getInstance(LoginPage.class);
        actualPage.as(LoginPage.class).verifyErrorText(userData.values().toArray()[2].toString());
    }
}
