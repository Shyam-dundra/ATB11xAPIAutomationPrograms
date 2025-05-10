package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.*;

public class APITesting024_All_Annotations {


    @BeforeSuite
    void demo1(){
        System.out.println("demo1");
    }

    @BeforeTest
    void demo2(){
        System.out.println("demo2");
    }

    @BeforeClass
    void demo3(){
        System.out.println("demo3");
    }

    @BeforeMethod
    void demo4(){
        System.out.println("demo4");
    }

    @Test
    void demo5(){
        System.out.println("demo5");
    }
    @AfterMethod
    void demo6(){
        System.out.println("demo6");
    }
    @AfterClass
    void demo7(){
        System.out.println("demo7");
    }
    @AfterTest
    void demo8(){
        System.out.println("demo8");
    }
    @AfterSuite
    void demo9(){
        System.out.println("demo9");
    }


}
