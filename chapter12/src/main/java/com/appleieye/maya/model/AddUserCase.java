package com.appleieye.maya.model;

import lombok.Data;

/**
 * @author: wujianjun
 * @date: 2018-05-02
 * @description:
 */

@Data
public class AddUserCase {

    private int id;
    private String username;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
    private String expected;


}
