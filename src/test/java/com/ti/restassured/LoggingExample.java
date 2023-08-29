package com.ti.restassured;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class LoggingExample {
    private static final String BASE_URL = "https://gorest.co.in/public/v2/";

    @Test
    void loggingTest() {
        RestAssured
                .given()
                .log().all()
                .when()
                .get(BASE_URL)
                .then()
                .log().headers()
                .log().status()
                .log().ifValidationFails(LogDetail.HEADERS)
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
