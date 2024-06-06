package com.github.restapi.createrepo;

import com.github.restapi.baseapi.BaseApi;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class CreateRepoTest extends BaseApi {

    static final String BASE_EP = "/user/repos";
    private final String username = "qamartinautomation";
    private final String repoName = "demorepo";

    @Test(description = "Delete repo if exists", priority = 1)
    void checkAndDeleteIfRepoExists() {
        if (doesRepoExist(username, repoName)) {
            deleteRepo(username, repoName);
            System.out.println("Repository with this name existed, but was deleted successfully");
        } else {
            System.out.println("There is no repository with this name.");
        }
    }

    @Test(description = "Create a repository", priority = 2)
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
