package com.ti.selenium.patronesdediseño.testcases;

import com.ti.base.BasePage;
import com.ti.base.BrowserType;
import com.ti.base.DriverFactory;
import com.ti.selenium.patronesdediseño.pf.LoginPage;
import com.ti.selenium.patronesdediseño.pf.StudentPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

public class BaseTest extends BasePage {
    String baseUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    Map<String, String> userCredentials = new HashMap<>();

    @BeforeClass
    @Parameters("browser")
    void setup(String browser) {
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);

        //Arrange
        userCredentials.put("username", "admin");
        userCredentials.put("password", "G3-ySzY%");

        //loginPage = new LoginPage();
        //Act
        actualPage = getInstance(LoginPage.class);

        actualPage.as(LoginPage.class)
                .loginAs(userCredentials.get("username"))
                .with()
                .password(userCredentials.get("password"))
                .andRememberMe(true)
                .submitLogin();
    }

    @AfterClass
    void turnDown() {
        try {
            actualPage.as(StudentPage.class).deleteLastRow().andConfirmWindow();
        } catch (Exception te) {

        }
        DriverFactory.getInstance().removeDriver();
    }

}
