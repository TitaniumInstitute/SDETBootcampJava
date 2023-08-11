package com.ti.selenium.patronesdediseño.pagespom;

import org.openqa.selenium.By;

public class MenuPage extends MainPage {
    private By navStudents = By.linkText("Students");

    public void clickStudentMenu() {
        driver.findElement(navStudents).click();
    }
}
