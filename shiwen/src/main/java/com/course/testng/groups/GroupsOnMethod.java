package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1() {
        System.out.println("服务端测试方法1");
    }

    @Test(groups = "server")
    public void test2() {
        System.out.println("服务端测试方法2");
    }

    @Test(groups = "client")
    public void test3() {
        System.out.println("客户端测试方法1");

    }

    @Test(groups = "client")
    public void test4() {
        System.out.println("客户端测试方法2");
    }

    @BeforeGroups("server")
    public void GroupOnServerBeforeGroups(){
        System.out.println("这是服务端测试运行前运行");
    }

    @AfterGroups("server")
    public void GroupOnServerAfterGroups(){
        System.out.println("这是服务端测试运行后运行");
    }
    @BeforeGroups("client")
    public void GroupOnclientBeforeGroups(){
        System.out.println("这是客户端测试运行前运行");
    }

    @AfterGroups("client")
    public void GroupOnclientAfterGroups(){
        System.out.println("这是客户端测试运行后运行");
    }
}