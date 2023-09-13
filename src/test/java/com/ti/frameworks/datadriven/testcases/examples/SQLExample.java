package com.ti.frameworks.datadriven.testcases.examples;

import com.ti.jdbc.DataBaseInfo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import static com.ti.frameworks.datadriven.dataproviders.SQLArrayData.getQueryTableArray;

public class SQLExample {
    @DataProvider
    public Object[][] getSQLProviderData() throws SQLException, IOException {
        return getQueryTableArray(DataBaseInfo.DBNAME.dbConn, "validstudents.sql");
    }

    @Test(dataProvider = "getSQLProviderData")
    public void sqlTest(LinkedHashMap<Object,Object> data){
        data.forEach((key, value) -> {
            System.out.printf("Colum: %s and Value: %s\n", key,value);
        });
    }
}
