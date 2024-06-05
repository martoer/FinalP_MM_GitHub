package com.github.restapi.readrepo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import restassured.RepoFactory;
import org.testng.Assert;

public class ReadRepoTest {

    static final String BASE_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "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";
    static final String BASE_URI = "https://api.github.com";
    @Test(description = "Confirm repository is created", priority = 2)
    void verifyRepoIsCreated() {
        var repoName = new RepoFactory("demorepo");
        String repoNameToBeConfirmed = repoName.getRepoName();

        Response response = RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get( BASE_URI + "/repos/qamartinautomation/" + repoNameToBeConfirmed)
                .then()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertEquals(response.path("name"), repoNameToBeConfirmed,
                "There is no repository with such name");
    }

    @Test(description = "Confirm repository is updated", priority = 4)
    void verifyRepoIsUpdated() {
        var repoName = new RepoFactory("demorepo-updated");
        String repoUpdatedNameToBeConfirmed = repoName.getRepoName();

        Response response = RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get( BASE_URI + "/repos/qamartinautomation/" + repoUpdatedNameToBeConfirmed)
                .then()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertEquals(response.path("name"), repoUpdatedNameToBeConfirmed,
                "The repository name is not  updated");
    }
}
