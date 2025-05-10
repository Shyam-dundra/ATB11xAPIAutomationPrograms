package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting023_TestNG_invocationCount {


    @Test(invocationCount = 2)
    public void test1(){
        System.out.println("Hi..");
    }

    @Test(invocationCount = 3)
    public void test2(){
        System.out.println("Hello");
    }

    @Test(invocationCount = 1)
    public void test3(){
        System.out.println("bye");
    }
}
