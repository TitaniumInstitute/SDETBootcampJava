package com.ti.restassured.demo.testcases;

import com.ti.baseapi.ServiceFactory;
import com.ti.restassured.demo.model.user.UserModel;
import com.ti.restassured.demo.model.user.UsersModel;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.ti.baseapi.RestAssuredUtils.deleteElement;
import static com.ti.baseapi.RestAssuredUtils.putWithBody;
import static com.ti.baseapi.ServiceFactory.getResponse;
import static com.ti.baseapi.ServiceFactory.setEndPoint;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class UserTest extends BaseTest {
    Map<String, String> updateUser;
    int id;

    @BeforeClass
    void classSetup() {
        updateUser = new LinkedHashMap<>();
        updateUser.put("name", "morpheus");
        updateUser.put("job", "zion resident");
    }

    @BeforeMethod
    @Parameters("endpoint")
    void setupEndPoint(String endpoint) {
        setEndPoint(endpoint);
        actualModel = getInstance(UsersModel.class);
        id = actualModel.as(UsersModel.class).getData().get(1).getId();
        setEndPoint(endpoint + id);
        response = getResponse();
        actualModel.as(UsersModel.class).getData().forEach(System.out::println);
    }

    @Test(priority = 1)
    void verifySingleUserIsRetrieved() {

        actualModel = getInstance(UserModel.class);
        String userFirstName = actualModel.as(UserModel.class).getData().getFirstName();
        System.out.println(userFirstName);
        assertThat(userFirstName, equalTo("Janet"));
    }

    @Test(priority = 2)
    void verifyUserIsUpdated() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM");//"uuuu-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        ServiceFactory.setResponse(putWithBody(updateUser));
        response = ServiceFactory.getResponse();
        String updatedAt = response.body().jsonPath().get("updatedAt").toString();

        System.out.println(updatedAt);
        assertThat(response.statusCode(), equalTo(HttpStatus.SC_OK));

        assertThat(updatedAt, containsString(dtf.format(now)));
    }

    @Test(priority = 3)
    void verifyUserIsDeleted() {
        ServiceFactory.setResponse(deleteElement());
        response = ServiceFactory.getResponse();

        assertThat(response.statusCode(), equalTo(HttpStatus.SC_NO_CONTENT));

    }

    @Test(priority = 4)
    void verifyAllUsersAreRetrieved() {
        setEndPoint("users/");
        actualModel = getInstance(UsersModel.class);
        actualModel.as(UsersModel.class).getData().forEach(System.out::println);
        System.out.println(actualModel.as(UsersModel.class).getData().size());
        assertThat(actualModel.as(UsersModel.class).getData().get(2).getFirstName(), equalTo("Emma"));
    }
}
