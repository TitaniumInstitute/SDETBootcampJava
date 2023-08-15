package com.ti.selenium.patronesdediseño.testcases;

import com.ti.selenium.patronesdediseño.pf.MainPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    void loginWithRightCredentials() {
        //Assert
        actualPage.as(MainPage.class).verifySchoolName();
    }

    @Test(enabled = false)
    void loginWithWrongCredentials() {
    }
}
