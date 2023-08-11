package com.ti.selenium.patronesdediseño.testcases;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    void loginWithRightCredentials() {
        loginPage.verifySchoolName();
    }

    @Test(enabled = false)
    void loginWithWrongCredentials() {
        loginPage.verifySchoolName();
    }
}
