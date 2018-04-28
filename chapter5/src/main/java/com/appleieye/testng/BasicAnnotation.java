package com.appleieye.testng;


import org.testng.annotations.*;

/**
 * @author: wujianjun
 * @date: 2018-04-27
 * @description:
 */

public class BasicAnnotation {

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是在测试之前执行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是在测试之后执行的");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("这是在类运行之前执行的");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("这是在类运行之执行的");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }
}
