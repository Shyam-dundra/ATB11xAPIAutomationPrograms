package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting019_TestNG_DependsOnMethod {

    @Test
    public void serverStartOk (){
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartOk")
    public void test1(){
        System.out.println("Method1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartOk")
    public void test2(){
        System.out.println("Method2");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartOk")
    public void test3(){
        System.out.println("Method3");
        Assert.assertTrue(true);
    }



}
