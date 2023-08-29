package com.ti.restassured.testcases;

import com.ti.baseapi.RestAssuredUtilsOld;
import com.ti.restassured.dao.UserGorest;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseTestClass {
    protected static final String BASE_URL = "https://gorest.co.in/public/v2/";
    protected static final String TOKEN = "7128aed3be37c995335454a1f30b5c5e641096f2310fd855a5bc912c947cddb7";
    Map<String, String> expectedHeaders = Map.of("Authorization", "Bearer " + TOKEN,
            "Content-Type", "application/json",
            "Accept", "*/*");

    List<UserGorest> userGorests = new ArrayList<>();
    protected Map<String, String> postUserData = Map.of("name", "Gilberto Sanchez",
            "gender", "male",
            "email", "gilberto.sanchez@gmail.com",
            "status", "active");

    protected Map<String, String> putUserData = Map.of("name", "Gil Sanchez",
            "email", "gsanchez@gmail.com",
            "status", "inactive");
    protected ResponseOptions<Response> response;

    @BeforeTest
    public void setup() {
        new RestAssuredUtilsOld(BASE_URL, expectedHeaders);
    }
}
