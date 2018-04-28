package com.appleieye.testng;

import org.testng.annotations.Test;

/**
 * @author: wujianjun
 * @date: 2018-04-27
 * @description:
 */

public class TimeOutTest {

    @Test(timeOut = 3000)
    public void test1() throws InterruptedException{
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void test2() throws InterruptedException{
        Thread.sleep(3000);
    }
}
