package com.course.testng.paramter;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider="data")
    public  void  testDataProvider(String name,int age){
        System.out.println("name:" + name + ";age:" + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] o = new  Object[][]{
                {"AAAA",10},
                {"BBBB",20},
                {"CCCC",30}
        };
        return o;
    }



    @Test(dataProvider = "datemethod")
    public  void  test1(String name,int age){
        System.out.println("name:" + name + ";age:" + age);
    }
    @Test(dataProvider = "datemethod")
    public  void  test2(String name,int age){
        System.out.println("name:" + name + ";age:" + age);
    }
    @DataProvider(name = "datemethod")
    public Object[][] DataMethod(Method method){
        Object[][] objects= null;

        if (method.getName().equals("test1")){
            objects = new  Object[][]{
                    {"aaaa",10},
                    {"bbbb",20}
            };
        }else if (method.getName().equals("test2")){
            objects = new  Object[][]{
                    {"CCCC",30},
                    {"DDDD",40}
            };
        }
        return objects;
    }

}