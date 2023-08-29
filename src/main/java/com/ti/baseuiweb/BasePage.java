package com.ti.baseuiweb;

import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public static BasePage actualPage;

    public <TPage extends BasePage> TPage getInstance(Class<TPage> page) {
        Object objPage = PageFactory.initElements(DriverFactory.getInstance().getDriver(), page);
        return page.cast(objPage);
    }

    public <TPage extends BasePage> TPage as(Class<TPage> pageInstance) {
        try {
            return (TPage) this;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
