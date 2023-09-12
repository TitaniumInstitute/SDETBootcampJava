package com.ti.frameworks.datadriven.testcases.examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static com.ti.frameworks.datadriven.dataproviders.JSONArrayData.getJsonTableArray;

public class JSONExample {
    @DataProvider
    public Object[][] getJSONProviderData(){
        return getJsonTableArray("onearray.json", "form info");
    }

    @Test(dataProvider = "getJSONProviderData")
    void test(LinkedHashMap<String, String> data){
       data.forEach((key, value) -> {
            System.out.printf("Object: %s and Value: %s\n", key,value);
        });

       // System.out.println(data.values().toArray()[1].toString());
    }
}
