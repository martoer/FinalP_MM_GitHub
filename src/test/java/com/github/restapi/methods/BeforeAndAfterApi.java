package com.github.restapi.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.aspectj.lang.annotation.Before;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import restassured.RepoFactory;

public class BeforeAndAfterApi {

    static final String BASE_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "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";
    static final String BASE_URI = "https://api.github.com";

    @BeforeMethod
    public void getRepoTest() {
        var repoName = new RepoFactory("demorepo");
        String expectedRepoName = repoName.getRepoName();

        Response response = RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get( BASE_URI + "/repos/qamartinautomation/" + expectedRepoName)
                .then()
                .statusCode(200)
                .extract()
                .response();

        if(response.path("name") == expectedRepoName) {
            RestAssured
                    .given()
                    .auth()
                    .oauth2(TOKEN)
                    .when()
                    .delete("https://api.github.com/repos/qamartinautomation/demorepo")
                    .then()
                    .statusCode(204);
        }
    }


}
