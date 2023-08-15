package com.ti.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class BasicResponseExample {
    private static final String BASE_URL = "https://api.github.com";

    @Test
    void convenienceMethod() {
        Response response = RestAssured.get(BASE_URL);
        System.out.println(response.getStatusCode());
        assertThat(200, greaterThanOrEqualTo(response.getStatusCode()));
        System.out.println(response.getContentType());
        assertThat("application/json; charset=utf-8", equalTo(response.getContentType()));
    }
}
