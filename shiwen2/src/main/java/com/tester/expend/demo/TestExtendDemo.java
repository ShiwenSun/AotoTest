package com.tester.expend.demo;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestExtendDemo {
    @Test
    public  void  test1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public  void  test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public  void  test3(){
        Assert.assertEquals("aaa","aaa");
    }

    @Test
    public  void  LogDemo(){
        Reporter.log("这是我们自己写的异常日志");
        throw new  RuntimeException("这是运行的异常日志");
    }
}
