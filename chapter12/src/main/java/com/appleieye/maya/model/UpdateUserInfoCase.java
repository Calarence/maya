package com.appleieye.maya.model;

import lombok.Data;

/**
 * @author: wujianjun
 * @date: 2018-05-02
 * @description:
 */

@Data
public class UpdateUserInfoCase {
    private int id;
    private int userId;
    private String username;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;
    private String password;
}
