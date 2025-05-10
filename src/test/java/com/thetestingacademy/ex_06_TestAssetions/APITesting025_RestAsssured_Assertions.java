package com.thetestingacademy.ex_06_TestAssetions;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITesting025_RestAsssured_Assertions {

    RequestSpecification r;
    ValidatableResponse vr;
    Response response;

    String token;
    Integer bookingID;


   @Owner("Shyam")
   @Severity(SeverityLevel.CRITICAL)
   @Description("TC#1 - Verify that the Create Booking is working fine, booking ID is not null")
   @Test
    public void test_CreateBookingID (){

        String payload = "{\n" +
                "    \"firstname\" : \"Shyam\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response = r.when().post();

        vr = response.then().log().all();
        vr.body("booking.firstname", Matchers.equalTo("Shyam"));
        vr.body("booking.lastname", Matchers.equalTo("Brown"));
        vr.body("booking.depositpaid",Matchers.equalTo(true));
        vr.body("bookingid",Matchers.notNullValue());


    }


}
