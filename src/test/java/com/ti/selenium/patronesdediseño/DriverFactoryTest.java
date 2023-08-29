package com.ti.selenium.patronesdediseño;

import com.ti.baseuiweb.BrowserType;
import com.ti.baseuiweb.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DriverFactoryTest {
    String demoSiteUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";

    @BeforeTest
    @Parameters("browser")
    void setUp(String browser) {
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
    }

    @AfterTest
    void turnDown() {
        DriverFactory.getInstance().removeDriver();
    }

    @Test
    void test() {
        DriverFactory.getInstance().getDriver().navigate().to(demoSiteUrl);
    }
}
