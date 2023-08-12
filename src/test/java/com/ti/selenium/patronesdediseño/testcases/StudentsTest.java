package com.ti.selenium.patronesdediseño.testcases;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class StudentsTest extends BaseTest {
    String[] studentPersonalDetailsData = {"Female", "TestStudent", "StudentLastName", "14", "Mexico", "Test Address"};

    Map<String, String> studentAccountInfo = new HashMap<>();

    @Test
    void verifyNewStudentIsCreated() {
        studentAccountInfo.put("email", "test" + Math.random() + "@gmail.com");
        studentAccountInfo.put("user", "testuser");
        studentAccountInfo.put("password", "test123");


        menuPage.clickStudentMenu();
        studentPage.clickCreateNew();
        studentPage.studentPersonalDetails(studentPersonalDetailsData);
        studentPage.accountInformation(studentAccountInfo);
        studentPage.schoolDetails("B-0012");
        studentPage.validateStudentIsAdded(studentPersonalDetailsData[1]);
    }
}
