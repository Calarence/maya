package com.appleieye.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author: wujianjun
 * @date: 2018-04-17
 * @description:
 */

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void test(String name,int age){
        System.out.println("name="+name+",age="+age);
    }

    @DataProvider(name = "data")
    public  Object[][] provideData(){
        Object[][] object = new Object[][]{
            {"zhangsan",10},
            {"lisi",20}
        };
        return object;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1 name="+name+" age="+age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2 name="+name+" age="+age);
    }

    @DataProvider(name = "methodData")
    public Object[][] provideData2(Method method){
        Object [][] object = null;
        if(method.getName().equals("test1")){
            object = new Object[][] {
                    {"zhagnsan",16}
            };
        }
        else{
            object = new Object[][]{
                    {"lisi",17}
            };
        }
        return object;
      }
}
