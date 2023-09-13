package com.ti.baseapi;

import io.restassured.RestAssured;

public class BaseModel {
    public static BaseModel actualModel;
    public static final String BASE_URL = "https://reqres.in/api/";

    public <TModel extends BaseModel> TModel getInstance(Class<TModel> model) {
        Object objModel = RestAssured.get(BASE_URL + ServiceFactory.getEndPoint()).as(model);
        return model.cast(objModel);
    }

    @SuppressWarnings("unchecked")
    public <TModel extends BaseModel> TModel as(Class<TModel> model) {
        try {
            return (TModel)this;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
