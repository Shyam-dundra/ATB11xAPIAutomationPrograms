package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_POST_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_POST_NonBDDstyle (){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r= RestAssured.given().baseUri("https://restful-booker.herokuapp.com");
               r .basePath("/auth");
               r.contentType(ContentType.JSON);
               r.log().all();
               r.body(payload);

        response=r.when().log().all().post();

        vr = response.then().log().all();
        vr.statusCode(200);

    }
}
