package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_GET_NonBDDStyle {

    RequestSpecification r ;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_GET_NONBDD(){

        String pincode = "505102";

        r = RestAssured.given().baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);
        r.log().all();


        response =  r.when().log().all().get();

        vr = response.then().log().all();
        vr.statusCode(200);
    }
    @Test
    public void test_GET_Negative(){
        String pincode = " ";

        r= RestAssured.given().baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+ pincode);
                r.log().all();

        response = r.when().log().all().get();

        vr = response.then().log().all();
        vr.statusCode(404);

    }

}
