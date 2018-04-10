package com.appleieye.maya.web.controller;

import com.appleieye.maya.web.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: wujianjun
 * @date: 2018-04-10
 * @description:
 */


@Controller
@RequestMapping("users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/getUserDetail",method = RequestMethod.GET)
    @ResponseBody
    public User getUserDetail(){
        User user = new User();
        user.setAge(10);
        user.setName("zhangsan");
        return user;
    }
}
