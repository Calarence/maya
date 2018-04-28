package com.appleieye.testng.suite;

import org.testng.annotations.Test;

/**
 * @author: wujianjun
 * @date: 2018-04-27
 * @description:
 */

public class DependTest {

    @Test
    public void test1(){
        System.out.println("test1");

    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2");
    }
}
