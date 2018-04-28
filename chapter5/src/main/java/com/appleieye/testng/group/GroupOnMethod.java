package com.appleieye.testng.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @author: wujianjun
 * @date: 2018-04-28
 * @description:
 */

public class GroupOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println(" server test1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("server test2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("client test3");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("client test4");
    }

    @BeforeGroups("server")
    public void beforeGroupOnServer(){
        System.out.println(" before server group");
    }

    @AfterGroups("server")
    public void afterGropuOnServer(){
        System.out.println("after server group");
    }
}
