package com.course.testng.paramter;

import javafx.scene.chart.PieChart;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {
        System.out.println("name:" + name + ";age:" + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] o = new Object[][]{
                {"AAAA", 10},
                {"BBBB", 20},
                {"CCCC", 30}
        };
        return o;
    }





    @Test(dataProvider = "dataprovider")
    public void test1(String name,int age){
        System.out.println("name=" + name + ";age=" + age);
    }

    @Test(dataProvider = "dataprovider")
    public  void test2(String name,int age){
        System.out.println("name=" + name + ";age=" + age);
    }

    @DataProvider(name = "dataprovider")
    public Object[][] DataProvider(Method method) {
    Object[][] result = null;
    if (method.getName().equals("test1")){
        result = new  Object[][]{
                {"AAA",01},
                {"BBB",02},
                {"CCC",03}
        };
    }else  if (method.getName().equals("test2")){
        result= new  Object[][]{
                {"DDD",04},
                {"EEE",05}
        };
    }
    return result;

    }
}
