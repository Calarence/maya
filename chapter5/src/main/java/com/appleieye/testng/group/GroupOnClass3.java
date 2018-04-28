package com.appleieye.testng.group;

import org.testng.annotations.Test;

/**
 * @author: wujianjun
 * @date: 2018-04-27
 * @description:
 */

@Test(groups = "teacher")
public class GroupOnClass3 {

    public void stu1(){
        System.out.println("teacher1");
    }
    public void stu2(){
        System.out.println("teacher2");
    }


}
