package com.appleieye.testng.group;

import org.testng.annotations.Test;

/**
 * @author: wujianjun
 * @date: 2018-04-27
 * @description:
 */

@Test(groups = "class2")
public class GroupOnClass2 {


    public void stu1(){
        System.out.println("class2 stu1");
    }

    public void stu2(){
        System.out.println("class2 stu2");
    }

}
