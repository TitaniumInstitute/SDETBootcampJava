package com.ti.selenium.patronesdediseño.pf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends MainPage {
    @FindBy(linkText = "Students")
    private WebElement navStudents;

    public MenuPage goToStudents() {
        navStudents.click();
        return this;
    }
}
