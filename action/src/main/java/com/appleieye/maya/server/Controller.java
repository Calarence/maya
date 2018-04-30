package com.appleieye.maya.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的接口")
public class Controller {

    @RequestMapping(value = "/getCookie",method = RequestMethod.GET)
    @ApiOperation(value = "向客户端返回cookie",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "cookie";
    }

    @RequestMapping(value = "/getWithCookie",method = RequestMethod.GET)
    @ApiOperation(value = "客户端需要携带cooke方法访问",httpMethod = "GET")
    public String getWithCookie(HttpServletRequest request){

        String result = null;
        Cookie [] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            result = "need cookie";
        }
        else{
            for (Cookie cookie : cookies){
               if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                   result = "success";
               }
               else{
                   result = "false";
               }
            }
        }
        return result;

    }

    @RequestMapping(value = "/getList")
    @ApiOperation(value = "获取商品列表",httpMethod = "GET")
    public Map<Integer,String> getList(Integer start,Integer end){
        Map<Integer,String> map = new HashMap();
        map.put(1,"book");
        map.put(2,"water");
        map.put(3,"bread");
        return map;

    }

    @RequestMapping(value = "/getList/{start}/{end}")
    @ApiOperation(value = "获取商品列表2",httpMethod = "GET")
    public Map<Integer,String> getList2(@PathVariable Integer start, @PathVariable Integer end){
        return getList(start,end);
    }

}
