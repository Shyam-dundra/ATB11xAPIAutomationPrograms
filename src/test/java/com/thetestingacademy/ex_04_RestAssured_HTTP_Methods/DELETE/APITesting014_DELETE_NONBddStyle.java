package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting014_DELETE_NONBddStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_DELETE_NonBDDstyle (){
        String token = "93711616d3f965d";
        String bookingid = "2189";

        r= RestAssured.given().baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/"+ bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token).log().all();

        response = r.when().log().all().delete();

        vr = response.then().log().all();
        vr.statusCode(201);

    }
}
