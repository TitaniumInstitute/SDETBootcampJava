package com.ti.testng.dataprovider;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class TestData {
    @DataProvider(name = "SchoolProvider")
    Object[][] getSchoolData() {
        return new Object[][]{
                {"Gil", "Braiant", "Luis", "Daniel"},
                {"Jimena", "Jeniffer", "Luisa", "María"},
                {"Jorge", "Laura", "Luis", "Lorena"}
        };
    }

    @DataProvider
    Object[][] getBookData(ITestContext groupItest) {
        Object[][] groupArray = null;

        for (String group : groupItest.getIncludedGroups()) {
            if (group.equals("Smoke")) {
                groupArray = new Object[][]{
                        {"East of Eden", "John Steinbeck", "1952", "novela"},
                        {"The House of Mirth", "Edith Wharton", "1905", "novela"},
                        {"Rosemary and Rue", "Seanan Mcguire", "no data", "poema"},
                        {"The Dark Tower", "Stephen King", "1852", "Triller"}
                };
                break;
            } else if (group.equals("Regression")) {
                groupArray = new Object[][]{
                        {"East of Eden", "John Steinbeck"},
                        {"The House of Mirth", "Edith Wharton"}
                };
            }
            break;
        }
        return groupArray;
    }

    @DataProvider
    Object[][] getBookMethodData(Method method) {
        if (method.getName().equals("verifyBookCompleteInfo")) {
            return new Object[][]{
                    {"East of Eden", "John Steinbeck", "1952", "novela"},
                    {"The House of Mirth", "Edith Wharton", "1905", "novela"},
                    {"Rosemary and Rue", "Seanan Mcguire", "no data", "poema"},
                    {"The Dark Tower", "Stephen King", "1852", "Triller"}
            };
        } else if (method.getName().equals("verifyBookNameAndAuthor")) {
            return new Object[][]{
                    {"East of Eden", "John Steinbeck"},
                    {"The House of Mirth", "Edith Wharton"}
            };
        }
        return null;
    }
}
