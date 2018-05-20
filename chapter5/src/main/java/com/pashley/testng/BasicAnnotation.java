package com.pashley.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public void testCase1(){
        System.out.println("testCase1 test");
    }

    @Test
    public void testCase2(){
        System.out.println("testCase2 test");
    }
    @BeforeMethod
    public void testBeforeMethod(){
        System.out.println("testBeforeMethod....");
    }

    @AfterMethod
    public void testAfterMethod(){
        System.out.println("testAfterMethod....");
    }

    @BeforeClass
    public void testBeforeClass(){
        System.out.println("testBeforeClass...");
    }

    @AfterClass
    public void testAfterClass(){
        System.out.println("testAfterClass...");
    }

    @AfterSuite
    public void testAfterSuit(){
        System.out.println("testAfterSuit...");
    }

    @BeforeSuite
    public void testBeforeSuit(){
        System.out.println("testBeforeSuit...");
    }
}
