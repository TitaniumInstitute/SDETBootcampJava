package com.ti.testng.dataprovider;

import org.testng.annotations.Test;

public class ItestContextExample {


    @Test(enabled = false, dataProvider = "SchoolProvider")
    void dataProviderTest(String name1, String name2, String name3, String name4) {
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
    }

    @Test(enabled = false, dataProvider = "getBookData", dataProviderClass = TestData.class, groups = "Smoke")
    void dataProviderItestSmoke(String title, String author, String year, String type) {
        System.out.println(title);
        System.out.println(author);
        System.out.println(year);
        System.out.println(type);
    }

    @Test(enabled = false, dataProvider = "getBookData", dataProviderClass = TestData.class, groups = "Regression")
    void dataProviderItestRegression(String title, String author) {
        System.out.println(title);
        System.out.println(author);
    }

    @Test(dataProvider = "getBookMethodData", dataProviderClass = TestData.class, groups = "Smoke")
    void verifyBookCompleteInfo(String title, String author, String year, String type) {
        System.out.println(title);
        System.out.println(author);
        System.out.println(year);
        System.out.println(type);
    }

    @Test(dataProvider = "getBookMethodData", dataProviderClass = TestData.class, groups = "Regression")
    void verifyBookNameAndAuthor(String title, String author) {
        System.out.println(title);
        System.out.println(author);
    }
}
