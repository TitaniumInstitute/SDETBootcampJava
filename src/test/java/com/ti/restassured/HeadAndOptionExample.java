package com.ti.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;

public class HeadAndOptionExample {
    private static final String BASE_URL = "https://api.github.com/";

    @Test
    void headTest() {
        RestAssured.head(BASE_URL)
                .then()
                .statusCode(200)
                .body(emptyOrNullString());
    }

    @Test
    void optionsTest() {
        RestAssured.options("https://demoqa.com/BookStore/")
                .then()
                //.statusCode(404)
                .headers("access-control-allow-methods", equalTo("GET,HEAD,PUT,PATCH,POST,DELETE"))
                .body(emptyOrNullString());
    }
}
