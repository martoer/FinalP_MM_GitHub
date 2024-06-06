package com.github.restapi.baseapi;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseApi {

    static final String BASE_URI = "https://api.github.com/";
    static final String TOKEN1 = "ghp_LiQW3pZ";
    static final String TOKEN2 = "VAR34Uw79cXqDWFN";
    static final String TOKEN3 = "wwJ8jIu3RQrvF";
    static final String TOKEN = TOKEN1+TOKEN2+TOKEN3;



    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.authentication = RestAssured.oauth2(TOKEN);
    }

    public boolean doesRepoExist(String username, String repoName) {
        Response response = RestAssured
                .given()
                .pathParam("username", username )
                .pathParam("repo", repoName)
                .get("/repos/{username}/{repo}");

        return response.getStatusCode() == 200;
    }

    public void deleteRepo(String user, String repoName) {
        RestAssured
                .given()
                .pathParam("user",user)
                .pathParam("repo", repoName)
                .delete("/repos/{user}/{repo}")
                .then()
                .statusCode(204);
    }
}
