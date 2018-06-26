package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void ignore1() {
        System.out.println("ignore1被执行");
    }

    @Test(enabled = false)
    public void ignore21() {
        System.out.println("ignore2被执行");
    }
}
