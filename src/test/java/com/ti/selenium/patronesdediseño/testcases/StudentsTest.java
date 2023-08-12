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

        menuPage.goToStudents().andCreateNew();

        //Student Personal Details
        studentPage
                .genderAs(studentPersonalDetailsData[0])
                .withFirstName(studentPersonalDetailsData[1])
                .andLastName(studentPersonalDetailsData[2])
                .withDayOfBirth(studentPersonalDetailsData[3])
                .andSelectCountry(studentPersonalDetailsData[4])
                .andCurrentAddress(studentPersonalDetailsData[5]);


        //Student Account Information
        studentPage
                .emailAddressAs(studentAccountInfo.get("email"))
                .withUserName(studentAccountInfo.get("user"))
                .withPassword(studentAccountInfo.get("password"))
                .andConfirmPassword(studentAccountInfo.get("password"));

        //Student School Details
        studentPage.schoolDetails("B-0012");

        //Validate
        studentPage.validateStudentIsAdded(studentPersonalDetailsData[1]);
    }
}
