package com.ti.frameworks.datadriven.testcases.webui;

import com.ti.baseuiweb.BasePage;
import com.ti.baseuiweb.BrowserType;
import com.ti.baseuiweb.DriverFactory;
import com.ti.selenium.patronesdediseño.pf.LoginPage;
import com.ti.selenium.patronesdediseño.pf.StudentPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

public class BaseWebTest extends BasePage {
    String baseUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";

    @BeforeClass
    @Parameters("browser")
    void setup(String browser) {
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        DriverFactory.getInstance().getDriver().navigate().to(baseUrl);
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
