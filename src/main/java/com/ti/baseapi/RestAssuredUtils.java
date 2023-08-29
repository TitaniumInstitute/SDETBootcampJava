package com.ti.baseapi;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static com.ti.baseapi.ConfigFactory.getDefaultConfig;

public class RestAssuredUtils {
    public static RequestSpecification request;

    public RestAssuredUtils(String baseUri, Map<String, String> headers) {
        ServiceFactory.setBuilder(new RequestSpecBuilder());
        RequestSpecBuilder builder = ServiceFactory.getBuilder();
        builder.setBaseUri(baseUri);
        builder.addHeaders(headers);
        builder.setConfig(getDefaultConfig());
        ServiceFactory.setBuilder(builder);
        request = RestAssured.given().spec(ServiceFactory.getBuilder().build());
    }

    public static ResponseOptions<Response> getElements() {
        try {
            return request.get(ServiceFactory.getEndPoint());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResponseOptions<Response> postWithBody(Map<String, ?> body) {
        request.body(body);
        return request.post(ServiceFactory.getEndPoint());
    }

    public static ResponseOptions<Response> postWithBodyAndParameter(String key, String value, Map<String, ?> body) {
        request.pathParam(key, value);
        request.body(body);
        return request.post(ServiceFactory.getEndPoint());
    }

    public static ResponseOptions<Response> postWithBodyAndParameters(Map<String, ?> pathParameters, Map<String, ?> body) {
        request.pathParams(pathParameters);
        request.body(body);
        return request.post(ServiceFactory.getEndPoint());
    }

    public static ResponseOptions<Response> postWithBodyAndQueryParam(String key, String value, Map<String, ?> body) {
        request.queryParam(key, value);
        request.body(body);
        return request.post(ServiceFactory.getEndPoint());
    }

    public static ResponseOptions<Response> postWithBodyAndQueryParams(Map<String, ?> queryParameters, Map<String, ?> body) {
        request.queryParams(queryParameters);
        request.body(body);
        return request.post(ServiceFactory.getEndPoint());
    }

    public static ResponseOptions<Response> putWithBody(Map<String, ?> body) {
        request.body(body);
        return request.put(ServiceFactory.getEndPoint());
    }

    public static ResponseOptions<Response> deleteElement() {
        return request.delete(ServiceFactory.getEndPoint());
    }
}
