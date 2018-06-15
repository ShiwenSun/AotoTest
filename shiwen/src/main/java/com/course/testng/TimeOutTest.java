package com.course.testng;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;
import org.testng.annotations.Test;

@Test(timeOut = 3000)
public class TimeOutTest {
    public  void  TimeOutSuccess() throws InterruptedException {
        Thread.sleep(2000);

    }

    public  void TimeOutFailure() throws  InterruptedException{
        Thread.sleep(3000);
    }
}

