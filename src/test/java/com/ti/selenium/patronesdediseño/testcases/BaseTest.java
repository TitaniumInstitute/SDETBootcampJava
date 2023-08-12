package com.ti.selenium.patronesdediseño.testcases;

import com.ti.base.BrowserType;
import com.ti.base.DriverFactory;
import com.ti.selenium.patronesdediseño.pf.LoginPage;
import com.ti.selenium.patronesdediseño.pf.MenuPage;
import com.ti.selenium.patronesdediseño.pf.StudentPage;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    String baseUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    Map<String, String> userCredentials = new HashMap<>();
    LoginPage loginPage;
    MenuPage menuPage;
    StudentPage studentPage;

    @BeforeClass
    @Parameters("browser")
    void setup(String browser) {
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);

        userCredentials.put("username", "admin");
        userCredentials.put("password", "G3-ySzY%");

        loginPage = new LoginPage();
        menuPage = new MenuPage();
        studentPage = new StudentPage();

        loginPage
                .loginAs(userCredentials.get("username"))
                .withPassword(userCredentials.get("password"))
                .andRememberMe(true)
                .login();
    }

    @AfterClass
    void turnDown() {
        try {
            studentPage.deleteLastRow().andConfirmWindow();
        } catch (TimeoutException te) {

        }
        DriverFactory.getInstance().removeDriver();
    }

}
