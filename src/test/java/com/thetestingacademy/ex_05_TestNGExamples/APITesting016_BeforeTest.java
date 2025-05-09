package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting016_BeforeTest {


    @BeforeTest
    public void getToken(){
        System.out.println("Before GET Token");
    }


    @BeforeTest
    public void getBookingid (){
        System.out.println("Before GET Booking");
    }

    @Test
    public void test_PUT (){
        System.out.println("PUT Request");
    }


    @AfterTest
    public void closeAllThings () {
        System.out.println("Close");
    }

}
