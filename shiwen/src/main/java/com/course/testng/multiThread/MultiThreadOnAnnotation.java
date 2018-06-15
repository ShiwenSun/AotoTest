package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotation {
    //invocationCount线程数，threadPoolSize线程池
    @Test(invocationCount = 10,threadPoolSize = 3)
    public  void  test1(){
        System.out.printf("thread id: %s%n" , Thread.currentThread().getId());
    }
}
