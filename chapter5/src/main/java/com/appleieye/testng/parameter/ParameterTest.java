package com.appleieye.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author: wujianjun
 * @date: 2018-04-27
 * @description:
 */

public class ParameterTest {

    @Test
    @Parameters({"name","age"})
    public void parameterTest(String name,int age){
        System.out.println("name="+name+" age"+age);
    }
}
