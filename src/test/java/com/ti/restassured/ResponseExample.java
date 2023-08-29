package com.ti.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

public class ResponseExample {
    private static final String BASE_URL = "https://gorest.co.in/public/v2/";

    ResponseSpecification commonResponsSpec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .expectContentType("text/html; charset=utf-8")
            .build();

    /* @BeforeClass
     void setup(){
         RestAssured.responseSpecification = new ResponseSpecBuilder()
                 .expectStatusCode(404)
                 .expectContentType("text/html; charset=utf-8")
                 .build();
     }*/
    @Test
    void testWithSpecOne() {
        RestAssured.get(BASE_URL + "non/exist/url")
                .then()
                .spec(commonResponsSpec)
                /*.statusCode(404)
                .contentType("text/html; charset=utf-8")*/;
    }

    @Test
    void testWithSpecTwo() {
        RestAssured.get(BASE_URL + "non/exist/url")
                .then()
                .spec(commonResponsSpec)
                /*.statusCode(404)
                .contentType("text/html; charset=utf-8")*/;
    }
}
