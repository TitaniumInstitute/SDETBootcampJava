package com.ti.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PeekAndPrintExample {

    private static final String BASE_URL = "https://api.github.com";

    @Test
    void peekTest() {
        RestAssured.get(BASE_URL)
                .peek();
    }

    @Test
    void prettyPeekTest() {
        RestAssured.get(BASE_URL)
                .prettyPeek();
    }

    @Test
    void printTest() {
        RestAssured.get(BASE_URL)
                .print();
    }

    @Test
    void prettyPrintTest() {
        RestAssured.get(BASE_URL)
                .prettyPrint();
    }
}
