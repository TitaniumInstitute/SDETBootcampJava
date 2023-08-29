package com.ti.restassured;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.Matchers.*;

public class BodyExample {

    private static final String BASE_URL = "https://api.github.com/";
    private static final String REQRES_BASE_URL = "https://reqres.in/";
    Response response;

    @BeforeTest
    void setup() {
        response = RestAssured.get(BASE_URL + "rate_limit");
    }

    @Test
    void jsonPathReturnsMap() {
        ResponseBody<?> body = response.body();

        JsonPath jsonPath = body.jsonPath();
        JsonPath jsonPath2 = body.jsonPath();

        Map<String, String> fullJson = jsonPath2.get();
        Map<String, String> subMap = jsonPath2.get("resources");
        Map<String, String> subMap2 = jsonPath2.get("resources.core");

        int coreLimit = jsonPath.get("resources.core.limit");
        int graphqlRemaining = jsonPath.get("resources.graphql.remaining");

        System.out.println(fullJson);
        System.out.println(subMap);
        System.out.println(subMap2);
        System.out.println(coreLimit);
        System.out.println(graphqlRemaining);

        Assert.assertEquals(coreLimit, 60);
        Assert.assertEquals(graphqlRemaining, 0);
    }

    @Test
    void castingFailure() {
        JsonPath jsonPath = RestAssured.get(BASE_URL + "rate_limit").body().jsonPath();

        int aMap = jsonPath.get("resources.core");
        //String value = jsonPath.get("resources.core.limit");
        //Map<String, String> isNull = jsonPath.get("asasssss.ssssss");
    }

    @Test
    void matcherExample() {
        RestAssured.get(BASE_URL)
                .then()
                .body("current_user_url", equalTo(BASE_URL + "user"))
                .body(containsString("feeds_url"))
                .body(containsString("feeds_url"),
                        containsString("current_user_authorizations_html_url"),
                        containsString(BASE_URL + "issues"));
    }

    @Test
    void complexBodyExample() {
        RestAssured.get(BASE_URL + "users/mojombo")
                .then()
                .body("url", res -> containsString("mojombo"))
                .body("html_url", res -> containsString(res.body().jsonPath().get("login")));
    }

    @DataProvider
    Object[][] users() {
        return new Object[][]{
                {"mojombo"},
                {"defunkt"},
                {"evanphx"},
                {"tomtt"}

        };
    }

    @Test(dataProvider = "users")
    void complexBodyWithDpExample(String user) {
        RestAssured.get(BASE_URL + "users/" + user)
                .then()
                .body("html_url", res -> containsString(res.body().jsonPath().get("login")));
    }

    @Test
    void nestedBodyExample() {
        /*RestAssured.get(BASE_URL + "rate_limit")
                .then()
                .body("resources.core.limit", equalTo(60))
                .body("resources.core.remaining", lessThanOrEqualTo(60))
                .body("resources.core.reset", notNullValue());*/

        RestAssured.get(BASE_URL + "rate_limit")
                .then()
                .rootPath("resources.core")
                .body("limit", equalTo(60))
                .body("remaining", lessThanOrEqualTo(60))
                .body("reset", notNullValue())
                .rootPath("resources.search")
                .body("limit", equalTo(10))
                .body("remaining", lessThanOrEqualTo(10))
                .noRootPath()
                .body("rate.limit", is(60));
    }

    @Test
    void repeatingItems() {
        RestAssured.get(REQRES_BASE_URL + "api/users?page=1")
                .then()
                //.body("data.id", equalTo(1));
                .body("data.id[0]", equalTo(1))
                .body("data.id[1]", equalTo(2))
                .body("data.first_name[2]", equalTo("Emma"))
                .body("data.first_name[3]", equalTo("Eve"))
                //.body("data.first_name", containsInAnyOrder("Eve", "Emma"))
                .body("data.first_name", hasItem("Emma"))
                .body("data.first_name", hasItem("Eve"))
                .body("data.first_name", hasItem(endsWith("ma")));

    }

    @Test
    void parseAndSyntacticSuggar() {
        RestAssured.get(BASE_URL)
                .then()
                .using()
                .defaultParser(Parser.JSON)
                .body("current_user_url", equalTo(BASE_URL + "user"));
    }
}
