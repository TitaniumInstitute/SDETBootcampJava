package com.ti.baseapi;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static com.ti.baseapi.ConfigFactory.getDefaultConfig;

public class RestAssuredUtilsOld {
    public static RequestSpecification request;

    public RestAssuredUtilsOld(String baseUri, Map<String, String> headers) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(baseUri);
        builder.addHeaders(headers);
        builder.setConfig(getDefaultConfig());
        var requestSpec = builder.build();
        request = RestAssured.given().spec(requestSpec);
    }

    public static ResponseOptions<Response> getElements(String endpoint) {
        try {
            return request.get(endpoint);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResponseOptions<Response> postWithBody(String endpoint, Map<String, ?> body) {
        request.body(body);
        return request.post(endpoint);
    }

    public static ResponseOptions<Response> putWithBody(String endpoint, Map<String, ?> body) {
        request.body(body);
        return request.put(endpoint);
    }

    public static ResponseOptions<Response> deleteElement(String endpoint) {
        return request.delete(endpoint);
    }
}
