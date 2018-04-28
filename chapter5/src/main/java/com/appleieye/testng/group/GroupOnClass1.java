package com.appleieye.testng.group;

import org.testng.annotations.Test;

/**
 * @author: wujianjun
 * @date: 2018-04-28
 * @description:
 */

@Test(groups = "class1")
public class GroupOnClass1 {

    public void stu1(){
        System.out.println("stu1");
    }

    public void stu2(){
        System.out.println("stu2");
    }
}
