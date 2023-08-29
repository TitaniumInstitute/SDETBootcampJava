package com.ti.baseapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.listener.ResponseValidationFailureListener;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;

public class ConfigFactory {

    public static RestAssuredConfig getDefaultConfig() {
        ResponseValidationFailureListener failureListener = (reqSpec, resSpec, response) ->
                System.err.printf("API failure: response status was %s and the body contains: %s",
                        response.getStatusCode(), response.getBody().asPrettyString());

        return RestAssured.config()
                .failureConfig(FailureConfig.failureConfig().failureListeners(failureListener))
                .redirect(RedirectConfig.redirectConfig().followRedirects(true).maxRedirects(1))
                .objectMapperConfig(ObjectMapperConfig.objectMapperConfig()
                        .jackson2ObjectMapperFactory(getMapperLambda()));
    }

    private static Jackson2ObjectMapperFactory getMapperLambda() {
        return (type, s) -> {
            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return om;
        };
    }
}
