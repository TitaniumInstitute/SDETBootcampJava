package com.ti.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.Map;

import static com.ti.baseapi.ConfigFactory.getDefaultConfig;

public class RequestSpecExample {
    private static final String BASE_URL = "https://gorest.co.in/public/v2/";
    private static final String TOKEN = "7128aed3be37c995335454a1f30b5c5e641096f2310fd855a5bc912c947cddb7";
    Map<String, String> expectedHeaders = Map.of("Authorization", "Bearer " + TOKEN,
            "Content-Type", "application/json",
            "Accept", "*/*");

    @Test
    void usingLocalRequestSpec() {
        RestAssured
                .given()
                .spec(getDefaultRequestSpec())
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    private static RequestSpecification getDefaultRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL + "users")
                .setConfig(getDefaultConfig())
                .build();
    }
}
