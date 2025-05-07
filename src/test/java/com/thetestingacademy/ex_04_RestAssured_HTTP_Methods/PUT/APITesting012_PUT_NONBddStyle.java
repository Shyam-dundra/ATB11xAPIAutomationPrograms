package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_PUT_NONBddStyle {

    RequestSpecification r ;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_PUT_NonBDDstyle (){
        String token = "0570a47887d63e6";
       int bookingid = 3762;

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"shyam\",\n" +
                "    \"lastname\" : \"Dundra\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com");
                r.basePath("/booking/"+bookingid);
                r.contentType(ContentType.JSON);
                r.cookie("token",token);
                r.body(payloadPUT).log().all();
        response=r.when().log().all().put();

        vr=response.then().log().all();
                vr.statusCode(200);

    }

}
