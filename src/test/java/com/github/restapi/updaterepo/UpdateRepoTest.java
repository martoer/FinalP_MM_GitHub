package com.github.restapi.updaterepo;

import com.github.restapi.baseapi.BaseApi;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class UpdateRepoTest  extends BaseApi {
    static final String BASE_EP = "/repos/qamartinautomation/demorepo";


    @Test(description = "Update Repository Name", priority = 4)
    void testPatchRequest() {
        RestAssured
                .given()
                .body(("{\"name\": \"demorepo-updated\"}"))
                .when()
                .patch(BASE_EP)
                .then()
                .statusCode(greaterThan(199))
                .statusCode(lessThan(300));

    }
}
