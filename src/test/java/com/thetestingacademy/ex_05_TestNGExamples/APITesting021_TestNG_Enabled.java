package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting021_TestNG_Enabled {

    @Test
    public void test1(){
        Assert.assertTrue(true);
        System.out.println("test1");
    }

    @Test(enabled = false)
    public void test2(){
        Assert.assertTrue(true);
        System.out.println("test2");
    }

    @Test
    public void test3(){
        Assert.assertTrue(true);
        System.out.println("test3");
    }

}
