package com.ti.selenium.patronesdediseño.pagespom;

import com.ti.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainPage {
    WebDriver driver = DriverFactory.getInstance().getDriver();

    private By spnSchoolTitle = By.className("wpsp-schoolname");

    private String getSchoolName() {
        return driver.findElement(spnSchoolTitle).getText();
    }

    public void verifySchoolName() {
        Assert.assertEquals(getSchoolName(), "Titanium School");
    }
}
