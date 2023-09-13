package com.ti.frameworks.pages;

import com.ti.baseuiweb.BasePage;
import com.ti.baseuiweb.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MainPage extends BasePage {
    WebDriver driver = DriverFactory.getInstance().getDriver();

    @FindBy(className = "wpsp-schoolname")
    private WebElement spnSchoolTitle;

    @FindBy(linkText = "Create New")
    private WebElement btnCreateNew;

    @FindBy(id = "d_teacher")
    private List<WebElement> icnTrashes;

    @FindBy(xpath = "//*[text()='Ok']")
    private WebElement btoOk;

    protected void type(WebElement element, String strType) {
        element.clear();
        element.sendKeys(strType);
    }

    protected String getElementText(WebElement element) {
        /*String text = "";
        text = element.getTagName().equals("input")?element.getAttribute("value"):element.getText();
        return text;*/
        return element.getTagName().equals("input") ? element.getAttribute("value") : element.getText();
    }

    public String getSchoolName() {
        return spnSchoolTitle.getText();
    }

    public MainPage verifySchoolName() {
        Assert.assertEquals(getSchoolName(), "Titanium School");
        return this;
    }

    public MainPage andCreateNew() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(btnCreateNew));
        btnCreateNew.click();
        return this;
    }

    public MainPage deleteLastRow() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElements(icnTrashes));
        WebElement delete = icnTrashes.get(icnTrashes.size() - 1);
        delete.click();
        return this;
    }

    public MainPage andConfirmWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.elementToBeClickable(btoOk));
        btoOk.click();

        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.invisibilityOf(btoOk));
        return this;
    }
}
