package com.thetestingacademy.ex_05_TestNGExamples;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting018_TestNG_Groups {

    @Test(groups = {"Sanity","reg"},priority = 1)
    public void test_sanityRun (){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Reg"},priority = 2)
    public void test_RegRun () {
        System.out.println("RegRun");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"p1","reg"},priority = 3)
    public void test_smokeRun () {
        System.out.println("smoke");
        System.out.println("QA");
        Assert.assertTrue(true);
    }
}
