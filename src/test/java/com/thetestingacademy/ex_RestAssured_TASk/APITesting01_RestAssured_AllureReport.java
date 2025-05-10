package com.thetestingacademy.ex_RestAssured_TASk;

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

public class APITesting01_RestAssured_AllureReport {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Owner("Shyam")
    @Description("TC#1-(POST) verify that the token were created")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void Create_Token(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response = r.when().log().all().post();

        vr=response.then().log().all();
        vr.statusCode(200);
    }

    @Owner("Shyam")
    @Description("TC#2-(POST) Verify the create booking and booking id were generated")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void Create_Booking (){
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

        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response= r.when().log().all().post();

        vr = response.then().log().all();
        vr.body("booking.firstname", Matchers.equalTo("Shyam"));
        vr.body("booking.lastname", Matchers.equalTo("Brown"));
        vr.body("booking.depositpaid",Matchers.equalTo(true));
        vr.body("bookingid",Matchers.notNullValue());
        vr.statusCode(200);
    }

    //2764
    @Owner("shyam")
    @Description("TC#3-(GET) Verify the Get Booking API")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void GET_Booking (){
        String booking_id = "1474";

        r=RestAssured.given().baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+booking_id);
        r.contentType(ContentType.JSON).log().all();
        response = r.when().get();
        vr = response.then().log().all().statusCode(200);

    }

    @Owner("Shyam")
    @Description("TC#4-(PATCH) Verify the booking partial update ")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void Partial_Update (){
        String booking_id = "1474";
        String token = "5e75a59bd3317e8";
        String payload_patch = "{\n" +
                "    \"firstname\" : \"Shyam\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+booking_id);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload_patch).log().all();
        response= r.when().patch();
        vr = response.then().log().all().statusCode(200);
    }

    @Owner("Shyam")
    @Description("TC#5-(PUT) Verify the Updated booking")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Update_Booking (){
        String token = "5c457316973d86d";
        String bookiing_id = "891";
        String Payload = "{\n" +
                "    \"firstname\" : \"Krishna\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 567,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookiing_id);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(Payload).log().all();
        response=r.when().put();
        vr = response.then().log().all().statusCode(200);

    }
    @Owner("Shyam")
    @Description("TC#6-(DELETE) Verify the Delete Booking ")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void Delete_Booking (){
        String token = "448b1607779d949";
        String booking_id = "764";

        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+booking_id);
        r.contentType(ContentType.JSON);
        r.cookie("token",token).log().all();

        response=r.when().delete();
        vr= response.then().log().all().statusCode(201);

    }


}
