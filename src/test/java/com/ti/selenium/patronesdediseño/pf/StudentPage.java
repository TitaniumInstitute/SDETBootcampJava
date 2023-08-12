package com.ti.selenium.patronesdediseño.pf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StudentPage extends MainPage {
    @FindBy(name = "s_gender")
    private List<WebElement> rdnGenders;
    @FindBy(id = "firstname")
    private WebElement txtFirstName;
    @FindBy(id = "lastname")
    private WebElement txtLastName;
    @FindBy(name = "s_dob")
    private WebElement dtpDateOfBirth;
    @FindBy(className = "day")
    private List<WebElement> tdSelectDays;
    @FindBy(id = "current_address")
    private WebElement txtCurrentAddress;
    @FindBy(name = "s_pcountry")
    private WebElement drpCountry;
    @FindBy(id = "Email")
    private WebElement txtEmail;
    @FindBy(name = "Username")
    private WebElement txtUserName;
    @FindBy(id = "Password")
    private WebElement txtPassword;
    @FindBy(id = "ConfirmPassword")
    private WebElement txtConfirmPass;
    @FindBy(id = "Rollno")
    private WebElement txtRollNumber;
    @FindBy(xpath = "//tr[@role='row']")
    private List<WebElement> trStudentRows;

    public StudentPage genderAs(String gender) {
        //cambiarlo a Map
        for (WebElement optGender : rdnGenders) {
            if (optGender.getAttribute("id").equals(gender)) {
                optGender.click();
                break;
            }
        }
        return this;
    }

    public StudentPage withFirstName(String firstName) {
        type(txtFirstName, firstName);
        return this;
    }

    public StudentPage andLastName(String lastName) {
        txtLastName.clear();
        txtLastName.sendKeys(lastName);
        return this;
    }

    public StudentPage withDayOfBirth(String selectDay) {
        dtpDateOfBirth.click();

        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfAllElements(tdSelectDays));

        for (WebElement day : tdSelectDays) {
            if (day.getText().equals(selectDay)) {
                day.click();
                break;
            }
        }
        return this;
    }

    public StudentPage andSelectCountry(String country) {
        new Select(drpCountry).selectByVisibleText(country);
        return this;
    }

    public StudentPage andCurrentAddress(String currentAddress) {
        txtCurrentAddress.clear();
        txtCurrentAddress.sendKeys(currentAddress);
        return this;
    }

    public StudentPage emailAddressAs(String email) {
        type(txtEmail, email);
        return this;
    }

    public StudentPage withUserName(String userName) {
        type(txtUserName, userName);
        return this;
    }

    public StudentPage withPassword(String pass) {
        type(txtPassword, pass);
        return this;
    }

    public StudentPage andConfirmPassword(String confirmPass) {
        type(txtConfirmPass, confirmPass);
        return this;
    }


    public StudentPage schoolDetails(String rolNumber) {
        type(txtRollNumber, rolNumber);
        txtRollNumber.submit();
        return this;
    }

    public StudentPage validateStudentIsAdded(String studentName) {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfAllElements(trStudentRows));

        WebElement newStudentRow = trStudentRows.get(trStudentRows.size() - 1);
        Assert.assertTrue(newStudentRow.getText().contains(studentName));
        System.out.println(newStudentRow.getText() + " contains " + studentName);
        return this;
    }
}
