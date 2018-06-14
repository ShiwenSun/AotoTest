package com.course.testng.groups;

import org.testng.annotations.Test;

    @Test(groups = "teacher")
    public class GroupOnClass3 {
        public  void  teacher1(){
            System.out.println("GroupOnClass2中的teacher11111111执行");
        }

        public  void  teacher2(){
            System.out.println("GroupOnClass2中的teacher222222222执行");
        }
    }



