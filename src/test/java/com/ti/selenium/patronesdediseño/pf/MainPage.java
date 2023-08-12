package com.ti.selenium.patronesdediseño.pf;

import com.ti.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MainPage {
    WebDriver driver = DriverFactory.getInstance().getDriver();

    @FindBy(className = "wpsp-schoolname")
    private WebElement spnSchoolTitle;

    @FindBy(linkText = "Create New")
    private WebElement btnCreateNew;

    @FindBy(id = "d_teacher")
    private List<WebElement> icnTrashes;

    @FindBy(xpath = "//*[text()='Ok']")
    private WebElement btoOk;

    protected MainPage() {
        PageFactory.initElements(driver, this);
    }

    private String getSchoolName() {
        return spnSchoolTitle.getText();
    }

    public void verifySchoolName() {
        Assert.assertEquals(getSchoolName(), "Titanium School");
    }

    public void clickCreateNew() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(btnCreateNew));
        btnCreateNew.click();
    }

    protected void deleteRow() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElements(icnTrashes));
        WebElement delete = icnTrashes.get(icnTrashes.size() - 1);
        delete.click();
    }

    protected void confirmWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.elementToBeClickable(btoOk));
        btoOk.click();

        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.invisibilityOf(btoOk));
    }
}
