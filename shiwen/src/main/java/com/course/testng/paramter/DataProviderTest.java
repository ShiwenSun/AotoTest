package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
}
