package com.appleieye.maya.model;

import lombok.Data;

/**
 * @author: wujianjun
 * @date: 2018-05-02
 * @description:
 */

@Data
public class GetUserListCase {

    private String username;
    private String sex;
    private String age;
    private String expected;
}
