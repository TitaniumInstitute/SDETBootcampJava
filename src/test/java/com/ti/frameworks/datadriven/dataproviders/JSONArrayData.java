package com.ti.frameworks.datadriven.dataproviders;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;

import static com.ti.frameworks.config.Constants.JSONS_FOLDER;

public class JSONArrayData {
    private static JsonArray jsonArray;

    private static JsonArray getJsonArray(String filename, String jsonObj){
        try {
            return JsonParser.parseReader(new FileReader(JSONS_FOLDER+filename))
                    .getAsJsonObject()
                    .get(jsonObj)
                    .getAsJsonArray();
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static Object[][] getJsonTableArray(String filename, String jsonObj){
        jsonArray = getJsonArray(filename,jsonObj);

        Object[][] testData = new Object[jsonArray.size()][1];

        for (int i = 0; i < jsonArray.size(); i++){
            JsonObject jsonInsideObj = jsonArray.get(i).getAsJsonObject();
            LinkedHashMap<Object, Object> map = new LinkedHashMap<>();

            jsonInsideObj.keySet().forEach(key->{
                map.put(key, jsonInsideObj.get(key).getAsString());
            });

            testData[i][0] = map;
        }
        return testData;
    }

}
