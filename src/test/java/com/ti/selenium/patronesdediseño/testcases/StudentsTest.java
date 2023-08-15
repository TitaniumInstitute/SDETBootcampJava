package com.ti.selenium.patronesdediseño.testcases;

import com.ti.selenium.patronesdediseño.pf.MenuPage;
import com.ti.selenium.patronesdediseño.pf.StudentPage;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class StudentsTest extends BaseTest {
    String[] studentPersonalDetailsData = {"Female", "TestStudent", "StudentLastName", "14", "Mexico", "Test Address"};

    Map<String, String> studentAccountInfo = new HashMap<>();

    @Test
    void verifyNewStudentIsCreated() {
        //Arrange
        studentAccountInfo.put("email", "test" + Math.random() + "@gmail.com");
        studentAccountInfo.put("user", "testuser");
        studentAccountInfo.put("password", "test123");

        actualPage = getInstance(MenuPage.class);
        actualPage.as(MenuPage.class).goToStudents().andCreateNew();

        //Act
        //Student Personal Details
        actualPage.as(StudentPage.class)
                .genderAs(studentPersonalDetailsData[0])
                .withFirstName(studentPersonalDetailsData[1])
                .andLastName(studentPersonalDetailsData[2])
                .withDayOfBirth(studentPersonalDetailsData[3])
                .andSelectCountry(studentPersonalDetailsData[4])
                .andCurrentAddress(studentPersonalDetailsData[5]);


        //Student Account Information
        actualPage.as(StudentPage.class)
                .emailAddressAs(studentAccountInfo.get("email"))
                .withUserName(studentAccountInfo.get("user"))
                .withPassword(studentAccountInfo.get("password"))
                .andConfirmPassword(studentAccountInfo.get("password"));

        //Student School Details
        actualPage.as(StudentPage.class).schoolDetails("B-0012");

        //Assert
        actualPage.as(StudentPage.class).validateStudentIsAdded(studentPersonalDetailsData[1]);
    }
}
