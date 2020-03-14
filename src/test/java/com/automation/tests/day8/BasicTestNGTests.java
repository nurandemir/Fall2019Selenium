package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suit");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suit");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeMethod
    public void setup(){
        System.out.println("Before method");
    }
    @AfterMethod
    public void teardown(){
        System.out.println("After method");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
        String expected="apple";
        String actual="apple";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
        int num1=5;
        int num2=10;
        Assert.assertTrue(num1<num2);
    }




}
