package com.appleieye.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * @author: wujianjun
 * @date: 2018-04-27
 * @description:
 */

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
}
