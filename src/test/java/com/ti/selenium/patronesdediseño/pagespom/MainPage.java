package com.ti.selenium.patronesdediseño.pagespom;

import com.ti.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MainPage {
    WebDriver driver = DriverFactory.getInstance().getDriver();

    private By spnSchoolTitle = By.className("wpsp-schoolname");

    private By btnCreateNew = By.linkText("Create New");

    private By icnTrash = By.id("d_teacher");

    private By btoOk = By.xpath("//*[text()='Ok']");

    private String getSchoolName() {
        return driver.findElement(spnSchoolTitle).getText();
    }

    public void verifySchoolName() {
        Assert.assertEquals(getSchoolName(), "Titanium School");
    }

    public void clickCreateNew() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(btnCreateNew)));
        driver.findElement(btnCreateNew).click();
    }

    protected void deleteRow() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(icnTrash));
        List<WebElement> trashIcons = driver.findElements(icnTrash);
        WebElement delete = trashIcons.get(trashIcons.size() - 1);
        delete.click();
    }

    protected void confirmWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.elementToBeClickable(btoOk));
        driver.findElement(btoOk).click();

        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.invisibilityOfElementLocated(btoOk));
    }
}
