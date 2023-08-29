package com.ti.restassured;

import com.ti.restassured.dao.AnotherUser;
import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.listener.ResponseValidationFailureListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.ti.baseapi.ConfigFactory.getDefaultConfig;
import static org.hamcrest.Matchers.equalTo;

public class ConfigurationExample {
    private static final String BASE_URL = "https://api.github.com/";

    @Test(enabled = false)
    void maxRedirect() {
        RestAssured.config = RestAssured.config()
                .redirect(RedirectConfig.redirectConfig().followRedirects(true).maxRedirects(1));
        //.redirect(RedirectConfig.redirectConfig().followRedirects(false));

        RestAssured.get(BASE_URL + "repos/twitter/bootstrap")
                .then()
                .statusCode(200);
    }

    @Test(enabled = false)
    void failureConfig() {
        ResponseValidationFailureListener failureListener = (reqSpec, resSpec, response) ->
                System.err.printf("API failure: response status was %s and the body contains: %s",
                        response.getStatusCode(), response.getBody().asPrettyString());

        RestAssured.config = RestAssured.config()
                .failureConfig(FailureConfig.failureConfig().failureListeners(failureListener));

        RestAssured.get(BASE_URL + "users/kevinclark")
                .then()
                .body("body.path", equalTo("some"));
    }

    @BeforeClass
    void setup() {
        RestAssured.config = getDefaultConfig();
    }

    @Test
    void cleanTestWithHiddingConfig() {
        AnotherUser user = RestAssured.get(BASE_URL + "users/kevinclark")
                .as(AnotherUser.class);
        Assert.assertEquals(user.getLogin(), "kevinclark");
    }


}
