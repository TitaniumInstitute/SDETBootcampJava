package com.ti.restassured.testcases;

import com.ti.restassured.dao.UserGorest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.List;

import static com.ti.baseapi.RestAssuredUtilsOld.*;

public class UserGorestTest extends BaseTestClass {

    @Test(priority = 1)
    void postExample() {
        response = postWithBody("users", postUserData);
        System.out.printf("The user created is %s", response.getBody().prettyPrint());
    }

    @Test(priority = 2)
    void getExample() {

        List<UserGorest> users = RestAssured.get("https://gorest.co.in/public/v2/users")
                .jsonPath().getList(".", UserGorest.class);

        System.out.println(users.size());
        users.forEach(System.out::println);
        //response = getElements("users");
        //response.getBody().jsonPath().getList(".", UsersGorest.class)
        //      .forEach(System.out::println);
        //System.out.println(userGorests.get(0).getName());
        //userGorests.forEach(System.out::println);
    }

    @Test(priority = 3)
    void putExample() {
        response = putWithBody("users/" + userGorests.get(0).getId(), putUserData);
        response = getElements("users");
        userGorests = response.getBody().jsonPath().getList(".", UserGorest.class);

    }

    @Test(priority = 4)
    void deleteExample() {
        //implementa el delete

        //Trae de nuevo la lista y valida que no exista el usuario borrado
    }


}
