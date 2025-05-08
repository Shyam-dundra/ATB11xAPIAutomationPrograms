package com.thetestingacademy.ex_05_TestNGExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITesting015_BeforeTest {

    @Test
    public void getToken(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .body(payload)
                .log().all()
                .when().log().all().post()
                .then().log().all()
                .statusCode(200);

    }

}
