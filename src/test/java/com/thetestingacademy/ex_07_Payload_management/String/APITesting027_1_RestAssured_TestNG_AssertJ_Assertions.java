package com.thetestingacademy.ex_07_Payload_management.String;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.String;

import static org.assertj.core.api.Assertions.assertThat;

public class APITesting027_1_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification r;
    ValidatableResponse vr;
    Response response;

    Integer bookingID;


    @Test
    public void test_POST() {

        String payload_POST ="{\n" +
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
        r.body(payload_POST).log().all();

        response = r.when().post();

        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("booking.firstname", Matchers.equalTo("Shyam"));
        vr.body("booking.lastname", Matchers.equalTo("Brown"));
        vr.body("booking.depositpaid", Matchers.equalTo(true));
        vr.body("bookingid", Matchers.notNullValue());

        //TestNG

        bookingID = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        // TestNG Assertions - 75%
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.

        Assert.assertEquals(firstname,"Shyam");
        Assert.assertEquals(lastname,"Brown");
        Assert.assertNotNull(bookingID);

        // AssertJ( 3rd- Lib to Assertions)

        assertThat(bookingID).isNotZero().isNotNull().isPositive();
        assertThat(firstname).isEqualTo("Shyam").isNotBlank().isNotEmpty().isNotNull().isAlphabetic();


    }
}