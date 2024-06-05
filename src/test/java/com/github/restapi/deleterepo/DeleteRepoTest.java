package com.github.restapi.deleterepo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class DeleteRepoTest {

    static final String BASE_EP = "https://api.github.com/repos/qamartinautomation/demorepo-updated";
    static final String TOKEN = "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";
    @Test(description = "Delete Repository", priority = 5)
    void testPatchRequest() {
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .delete(BASE_EP)
                .then()
                .statusCode(204);

    }
}
