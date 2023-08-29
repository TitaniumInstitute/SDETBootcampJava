package com.ti.restassured;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ti.restassured.dao.AnotherUser;
import com.ti.restassured.dao.User;
import io.restassured.RestAssured;
import io.restassured.internal.mapping.Jackson2Mapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Type;

public class MapperExample {
    private static final String BASE_URL = "https://api.github.com/";

    @Test
    void objectMappingOne() {
        var user = RestAssured.get(BASE_URL + "users/kevinclark")
                .as(User.class);

        Assert.assertEquals(user.getLogin(), "kevinclark");
        Assert.assertEquals(user.getId(), 20);
        Assert.assertEquals(user.getPublicRepos(), 41);
        Assert.assertNull(user.getTwitterUsername());
    }

    @Test
    void objectMAppingRelyingOnMapper() {
        User user = RestAssured.get(BASE_URL + "users/kevinclark")
                .as(User.class, ObjectMapperType.JACKSON_2);

        Assert.assertEquals(user.getLogin(), "kevinclark");
    }

    @Test
    void objectMappingUsingSpecifiedMapper() {
        io.restassured.mapper.ObjectMapper mapper = new Jackson2Mapper(new Jackson2ObjectMapperFactory() {
            @Override
            public ObjectMapper create(Type cls, String charset) {
                ObjectMapper om = new com.fasterxml.jackson.databind.ObjectMapper();
                om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return om;
            }
        });

        AnotherUser user = RestAssured.get(BASE_URL + "users/kevinclark")
                .as(AnotherUser.class, mapper);

        Assert.assertEquals(user.getLogin(), "kevinclark");
    }

    @Test
    void objectMappingUsingCustomMapper() {
        AnotherUser user = RestAssured.get(BASE_URL + "users/kevinclark")
                .as(AnotherUser.class, getMapperLambda());

        Assert.assertEquals(user.getLogin(), "kevinclark");
    }

    private Jackson2Mapper getMapper() {
        return new Jackson2Mapper(new Jackson2ObjectMapperFactory() {
            @Override
            public ObjectMapper create(Type cls, String charset) {
                ObjectMapper om = new ObjectMapper();
                om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return om;
            }
        });
    }

    private Jackson2Mapper getMapperLambda() {
        return new Jackson2Mapper((type, s) -> {
            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return om;
        });
    }
}
