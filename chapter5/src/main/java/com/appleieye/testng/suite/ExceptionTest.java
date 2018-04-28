package com.appleieye.testng.suite;

import org.testng.annotations.Test;

/**
 * @author: wujianjun
 * @date: 2018-04-27
 * @description:
 */

public class ExceptionTest {

    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeException(){
        throw new RuntimeException();

    }
}
