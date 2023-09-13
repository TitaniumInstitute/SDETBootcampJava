package com.ti.frameworks.datadriven.testcases.mobileui;

import com.ti.frameworks.screen.HomeScreen;
import com.ti.frameworks.screen.LoginScreen;
import com.ti.frameworks.screen.MenuScreen;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import static com.ti.frameworks.datadriven.dataproviders.SQLArrayData.getQueryTableArray;

public class SauceLabLoginMobileSQLTest extends BaseMobileTest {
    Object[][] testArray;
    @DataProvider
    public Object[][] getSQLProviderData(Method method) throws SQLException, IOException {
        if (method.getName().equals("loginWithRightCredentials")){
            testArray = getQueryTableArray("saucelab", "validsaucelabusers.sql");
        }

        if (method.getName().equals("loginWithWrongCredentials")){
            testArray = getQueryTableArray("saucelab", "invalidsaucelabusers.sql");
        }

        return testArray;
    }
    @Test(priority = 2,dataProvider = "getSQLProviderData")
    void loginWithRightCredentials(LinkedHashMap<String, String> userData) {
        try {
            actualScreen = getInstance(HomeScreen.class);
            actualScreen = actualScreen.as(HomeScreen.class).displayMenu();
            actualScreen.as(MenuScreen.class).andLogOut();
        }catch (Exception e){
            actualScreen = getInstance(LoginScreen.class);

            actualScreen.as(LoginScreen.class)
                    .loginAs(userData.values().toArray()[1].toString())
                    .withPassword(userData.values().toArray()[2].toString())
                    .submitLogin();

            actualScreen.as(HomeScreen.class).verifyProductsText();
        }
    }

    @Test(priority = 1, dataProvider = "getSQLProviderData")
    void loginWithWrongCredentials(LinkedHashMap<String, String> userData) {
        actualScreen = getInstance(LoginScreen.class);

        actualScreen.as(LoginScreen.class)
                .loginAs(userData.values().toArray()[1].toString())
                .withPassword(userData.values().toArray()[2].toString())
                .submitLogin();

        actualScreen = getInstance(LoginScreen.class);
        String errorMessage = actualScreen.as(LoginScreen.class).getError();

        if (errorMessage.toLowerCase().contains("password") || errorMessage.toLowerCase().contains("username")){
            actualScreen.as(LoginScreen.class).verifyErrorText(userData.values().toArray()[4].toString());
        }else {
            actualScreen.as(LoginScreen.class).verifyErrorText(userData.values().toArray()[3].toString());
        }
    }
}
