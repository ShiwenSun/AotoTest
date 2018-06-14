package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass2 {
    public  void  stu1(){
        System.out.println("GroupOnClass2中的stu111111111111执行");
    }

    public  void  stu2(){
        System.out.println("GroupOnClass2中的stu2222222222执行");
    }
}
