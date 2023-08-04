package com.ti.selenium.patronesdediseño.testcases;

import org.testng.annotations.Test;

public class TestClass extends BaseTest {

    @Test
    void loginWithRightCredentials() {
        loginPage.login(userCredentials.get("username"), userCredentials.get("password"));
        loginPage.verifySchoolName();
    }
}
