package com.ti.selenium.responsive;

import org.testng.annotations.DataProvider;

public class MobileEmulators {

    @DataProvider
    public Object[][] mobileEmulations() {
        return new Object[][]{
                {"iPhone 12 Pro"},
                {"Pixel 5"},
                {"Samsung Galaxy S20 Ultra"},
                {"iPad Mini"},
                {"Surface Pro 7"}
        };
    }

    @DataProvider
    public Object[][] mobileEmulationsDimensions() {
        return new Object[][]{
                {390, 844},
                {393, 851},
                {412, 915},
                {768, 1024},
                {912, 1368}
        };
    }

}
