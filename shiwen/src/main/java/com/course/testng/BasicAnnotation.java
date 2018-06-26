package com.course.testng;

import org.testng.annotations.*;


public class BasicAnnotation {

    @Test
    public  void  testcase1(){

       System.out.println("testcase");
    }
    @Test
    public  void  testcase2(){

        System.out.println("testcase2");
    }

    @BeforeMethod
    public  void beforemethod(){
        System.out.println("测试方法之前的运行方法");
    }

    @AfterMethod
    public  void  aftermethod(){
        System.out.println("测试方法后运行");
    }


    @BeforeClass
    public void  BeforeClass(){
        System.out.println("BeforeClass在类之前运行");
    }
    @AfterClass
    public void  AfterClass(){
        System.out.println("BeforeClass在类之后运行");

    }

    @BeforeSuite
    public  void  BeforeSuite(){
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    public  void  AfterSuite(){
        System.out.println("AfterSuite");
    }
}
