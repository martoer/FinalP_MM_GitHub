package com.github.restapi.createrepo;

import com.github.restapi.methods.BeforeAndAfterApi;
import io.restassured.RestAssured;
import org.hamcrest.Description;
import org.testng.annotations.Test;
import restassured.RepoFactory;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class CreateRepoTest {
    static final String BASE_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "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";

    @Test (description = "Create a repository", priority = 1)
    void testPostRequest() {

        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .body(("{\"name\": \"demorepo\"}"))
                .when()
                .post(BASE_EP)
                .then()
                .statusCode(greaterThan(199))
                .statusCode(lessThan(300));
    }

}
