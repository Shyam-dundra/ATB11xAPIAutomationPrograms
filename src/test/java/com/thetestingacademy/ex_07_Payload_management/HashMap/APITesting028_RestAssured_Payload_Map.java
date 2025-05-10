package com.thetestingacademy.ex_07_Payload_management.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class APITesting028_RestAssured_Payload_Map {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr ;


    @Test
    public void test_POST (){

        //Hashmap

        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname","Shyam");
        jsonBodyUsingMap.put("lastname","Brown");
        jsonBodyUsingMap.put("totalprice",123);
        jsonBodyUsingMap.put("depositpaid",false);

        Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2025-06-09");
        bookingDatesMap.put("checkout","2025-06-10");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds","Breakfast");
        System.out.println(jsonBodyUsingMap);


        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(jsonBodyUsingMap).log().all();

        response=r.when().post();
        vr=response.then().log().all();
        vr.statusCode(200);

        vr.body("booking.firstname", Matchers.equalTo("Shyam"));
        vr.body("booking.lastname", Matchers.equalTo("Brown"));
        vr.body("booking.depositpaid", Matchers.equalTo(false));
        vr.body("bookingid", Matchers.notNullValue());

    }


}
