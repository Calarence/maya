package com.appleieye.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @author: wujianjun
 * @date: 2018-04-27
 * @description:
 */

public class DemoTest {

    @Test
    public void test1(){
        assertEquals(1,1);
    }

    @Test
    public void test2(){
        assertEquals(1,2);
    }

    @Test
    public void test3(){
        Reporter.log("mytest");
        throw new RuntimeException("这是我自己的异常");
    }
}
