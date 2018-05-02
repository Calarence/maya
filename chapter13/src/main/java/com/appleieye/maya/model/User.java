package com.appleieye.maya.model;

import lombok.Data;

/**
 * @author: wujianjun
 * @date: 2018-05-02
 * @description:
 */

@Data
public class User {

    private int id;
    private String username;
    private String password;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
}
