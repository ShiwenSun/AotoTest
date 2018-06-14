package com.course.testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public  void  beforeSuite(){
        System.out.println("before suite 运行了");
    }

    @AfterSuite
    public  void  afterSuite(){
        System.out.println("after suit 运行了");
    }

    @BeforeTest
    public  void  BeforeTest(){
        System.out.println("BeforeTest 运行了");
    }
    @AfterTest
    public  void  AfterTest(){
        System.out.println("AfterTest 运行了");
    }
}
