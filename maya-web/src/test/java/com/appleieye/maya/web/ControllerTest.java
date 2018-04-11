package com.appleieye.maya.web;

import com.appleieye.maya.web.model.User;
import org.junit.Test;

/**
 * @author: wujianjun
 * @date: 2018-04-11
 * @description:
 */

public class ControllerTest {

    @Test
    public void testEquals(){
        User user1 = new User();
        user1.setName("zhangsan");
        user1.setAge(20);
        User user2 = new User();
        user2.setName("zhangsan");
        user2.setAge(20);
        System.out.println(user1.equals(user2));
    }

}
