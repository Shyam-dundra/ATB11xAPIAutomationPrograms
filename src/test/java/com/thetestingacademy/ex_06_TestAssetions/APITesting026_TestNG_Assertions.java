package com.thetestingacademy.ex_06_TestAssetions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting026_TestNG_Assertions {

    //Hard Assertion

    @Test(enabled = false)
    public void test_HardAssertEx(){

        System.out.println("Start the program");
        Boolean is_Neeru_male = false;
        Assert.assertEquals("shyam","Shyam");
        System.out.println("End the program");

    }


    //SOft Assert

    @Test
    public void  test_softAssertEX (){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Shyam","Shyam");
        System.out.println("End the program");
        softAssert.assertAll();

    }

}
