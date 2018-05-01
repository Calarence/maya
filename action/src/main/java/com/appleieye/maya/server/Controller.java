package com.appleieye.maya.server;


import com.appleieye.maya.com.appleieye.maya.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/getUserList")
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User user){
        String result = null;
        Cookie [] cookies = request.getCookies();
        if (Objects.nonNull(cookies)){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("login")&&cookie.getValue().equals("true")
                        &&user.getUsername().equals("wu")&&user.getPassword().equals("521")){
                    User model = new User();
                    model.setUsername("zhangsan");
                    model.setPassword("521");
                    model.setAge(10);
                    result = model.toString();
                }
                else{
                    result = "用户名或密码错误";
                }
            }
        }
        else{
            result = "need cookie";
        }
        return result;
    }

}
