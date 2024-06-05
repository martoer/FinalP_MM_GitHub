package com.github.restapi.updaterepo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class UpdateRepoTest  {
    static final String BASE_EP = "https://api.github.com/repos/qamartinautomation/demorepo";
    static final String TOKEN = "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";

    @Test(description = "Update Repository Name", priority = 3)
    void testPatchRequest() {
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .body(("{\"name\": \"demorepo-updated\"}"))
                .when()
                .post(BASE_EP)
                .then()
                .statusCode(greaterThan(199))
                .statusCode(lessThan(300));

    }
}
