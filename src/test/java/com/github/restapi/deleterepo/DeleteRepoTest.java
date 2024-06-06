package com.github.restapi.deleterepo;

import com.github.restapi.baseapi.BaseApi;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DeleteRepoTest extends BaseApi {

    static final String BASE_EP = "repos/qamartinautomation/demorepo-updated";
    @Test(description = "Delete Repository", priority = 5)
    void testPatchRequest() {
        RestAssured
                .given()
                .when()
                .delete(BASE_EP)
                .then()
                .statusCode(204);

    }
}
