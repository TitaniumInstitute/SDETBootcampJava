package com.ti.frameworks.datadriven.testcases.webui;

import com.ti.frameworks.datadriven.pages.LoginPage;
import com.ti.frameworks.datadriven.pages.MainPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import static com.ti.frameworks.datadriven.dataproviders.ExcelArrayData.getExcelTableArray;
import static com.ti.frameworks.datadriven.dataproviders.JSONArrayData.getJsonTableArray;

public class SchoolLoginWebExcelTest extends BaseWebTest {
    Object[][] testArray;
    @DataProvider
    public Object[][] getExcelProviderData(Method method) throws IOException {
        if (method.getName().equals("loginWithRightCredentials")){
            testArray = getExcelTableArray("webusers.xlsx", "ValidUsers");
        }

        if (method.getName().equals("loginWithWrongCredentials")){
            testArray = getExcelTableArray("webusers.xlsx", "InvalidUsers");
        }

        return testArray;
    }
    @Test(priority = 2,dataProvider = "getExcelProviderData")
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

    @Test(priority = 1, dataProvider = "getExcelProviderData")
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
