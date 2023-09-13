package com.ti.frameworks.datadriven.testcases.webui;

import com.ti.frameworks.pages.LoginPage;
import com.ti.frameworks.pages.MainPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import static com.ti.frameworks.datadriven.dataproviders.SQLArrayData.getQueryTableArray;

public class SchoolLoginWebSQLTest extends BaseWebTest {
    Object[][] testArray;
    @DataProvider
    public Object[][] getSQLProviderData(Method method) throws SQLException, IOException {
        if (method.getName().equals("loginWithRightCredentials")){
            testArray = getQueryTableArray("wpschool", "validstudents.sql");
        }

        if (method.getName().equals("loginWithWrongCredentials")){
            testArray = getQueryTableArray("wpschool", "invalidstudents.sql");
        }

        return testArray;
    }
    @Test(priority = 2,dataProvider = "getSQLProviderData")
    void loginWithRightCredentials(LinkedHashMap<String, String> userData) {
        actualPage = getInstance(LoginPage.class);

        actualPage.as(LoginPage.class)
                .loginAs(userData.values().toArray()[1].toString())
                .password(userData.values().toArray()[2].toString())
                .andRememberMe(true)
                .submitLogin();
        //Assert
        actualPage.as(MainPage.class).verifySchoolName();
    }

    @Test(priority = 1, dataProvider = "getSQLProviderData")
    void loginWithWrongCredentials(LinkedHashMap<String, String> userData) {
        actualPage = getInstance(LoginPage.class);

        actualPage.as(LoginPage.class)
                .loginAs(userData.values().toArray()[1].toString())
                .password(userData.values().toArray()[2].toString())
                .andRememberMe(true)
                .submitLogin();

        actualPage = getInstance(LoginPage.class);
        actualPage.as(LoginPage.class).verifyErrorText(userData.values().toArray()[3].toString());
    }
}
