package com.thetestingacademy.ex_03_TestNG_AllureReoprt;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class APITesting_Lab06_TestCase {
    String  pincode = "505102";

    @Test
    public void test_GET_Positive_TC1 (){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" +pincode)
                .when()
                .get()
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void test_GET_Positive_TC2 (){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then().log().all()
                .body("places[0].'place name'", equalTo("Vagapalli"))
                .body("places[0].longitude",equalTo("78.5913"));

    }

    @Test
    public void test_GET_Negative_TC3 (){
        pincode = " @";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then().log().all()
                .statusCode(200);

    }

    @Test
    public void test_GET_Negative_TC4 (){
        pincode = " ";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then().log().all()
                .statusCode(200);
    }


}
