package com.appleieye.maya.model;

import lombok.Data;

/**
 * @author: wujianjun
 * @date: 2018-05-02
 * @description:
 */

@Data
public class LoginCase {

    private int id;
    private String username;
    private String password;
    private String expected;
}
