package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting022_TestNG_AlwaysRun {

    @BeforeTest
    public void testNormalPage(){
        Assert.assertTrue(true);
        System.out.println("Normal Page");
    }


    @Test(alwaysRun = true)
    public void LoginPage (){
        Assert.assertTrue(true);
        System.out.println("Login");
    }

    @AfterTest
    public void new_register(){
        Assert.assertTrue(true);
        System.out.println("New register");
    }
}
