package com.ti.frameworks.datadriven.testcases.examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedHashMap;

import static com.ti.frameworks.datadriven.dataproviders.ExcelArrayData.getExcelTableArray;

public class ExcelExample {
    @DataProvider
    public Object[][] getExcelProviderData() throws IOException {
        return getExcelTableArray("webusers.xlsx", "InvalidUsers");
    }

    @Test(dataProvider = "getExcelProviderData")
    void test(LinkedHashMap<String, String> data){
        data.forEach((key, value) -> {
            System.out.printf("Column: %s and Value: %s\n", key,value);
        });

        // System.out.println(data.values().toArray()[1].toString());
    }
}
