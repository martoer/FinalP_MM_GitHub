package com.github.restapi.baseapi;

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

}
