package com.github.restapi.readrepo;

import com.github.restapi.baseapi.BaseApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import restassured.RepoFactory;
import org.testng.Assert;

public class ReadRepoTest extends BaseApi {

    static final String BASE_EP = "/repos/qamartinautomation/";

    @Test(description = "Confirm repository is created", priority = 3)
    void verifyRepoIsCreated() {
        var repoName = new RepoFactory("demorepo");
        String repoNameToBeConfirmed = repoName.getRepoName();

        Response response = RestAssured
                .given()
                .when()
                .get(BASE_EP + repoNameToBeConfirmed)
                .then()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertEquals(response.path("name"), repoNameToBeConfirmed,
                "There is no repository with such name");
    }

    @Test(description = "Confirm repository is updated", priority = 5)
    void verifyRepoIsUpdated() {
        var repoName = new RepoFactory("demorepo-updated");
        String repoUpdatedNameToBeConfirmed = repoName.getRepoName();

        Response response = RestAssured
                .given()
                .when()
                .get(BASE_EP + repoUpdatedNameToBeConfirmed)
                .then()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertEquals(response.path("name"), repoUpdatedNameToBeConfirmed,
                "The repository name is not  updated");
    }
}
