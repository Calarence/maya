package com.appleieye.maya.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: wujianjun
 * @date: 2018-04-11
 * @description:
 */

@Controller
public class OkController {

    @RequestMapping(value = "ok",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return "success";
    }
}
