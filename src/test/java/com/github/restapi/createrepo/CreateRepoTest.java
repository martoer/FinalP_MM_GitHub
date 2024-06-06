package com.github.restapi.createrepo;

import com.github.restapi.baseapi.BaseApi;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class CreateRepoTest extends BaseApi {

    static final String BASE_EP = "/user/repos";
    @Test (description = "Create a repository", priority = 1)
    void testPostRequest() {

        RestAssured
                .given()
                .body(("{\"name\": \"demorepo\"}"))
                .when()
                .post(BASE_EP)
                .then()
                .statusCode(greaterThan(199))
                .statusCode(lessThan(300));
    }

}
