package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting020_TestNG_Parameter {

   @Parameters("browser")
   @Test
    public void demo1(String value){

        System.out.println("Hi am demo");
        System.out.println("you are running this param");

        if (value.equalsIgnoreCase("firefox")){
            System.out.println("Start the firefox");
        }
        if (value.equalsIgnoreCase("Chrome")){
            System.out.println("Start the chrome");
        }

    }
}
