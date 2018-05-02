package com.appleieye.maya.controller;

import com.appleieye.maya.model.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * @author: wujianjun
 * @date: 2018-05-02
 * @description:
 */

@Log4j
@RestController
@Api(value = "/",description = "用户管理系统")
public class UserManager {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @RequestMapping("/login")
    @ApiOperation(value = "登陆接口",httpMethod = "POST")
    public Boolean login(HttpServletResponse response, @RequestBody User user){

        int i = sqlSessionTemplate.selectOne("login",user);
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);

        if (i == 1){

            return true;
        }
        else{
            return false;
        }

    }

    @RequestMapping("/addUser")
    @ApiOperation(value = "添加用户",httpMethod = "POST")
    public Boolean addUser(HttpServletRequest request, @RequestBody User user){
        boolean cookieIsValid = verifyCookies(request);
        int result = 0;
        if (cookieIsValid){
            result = sqlSessionTemplate.insert("addUser",user);
        }
        if (result > 0){
            return true;
        }
        else{
            return false;
        }
    }

    @RequestMapping("/getUserList")
    @ApiOperation(value = "查询用户",httpMethod = "POST")
    public List<User> getUserList(HttpServletRequest request,@RequestBody User user){
        boolean isValidCookie = verifyCookies(request);
        if (isValidCookie){
            List<User> users = sqlSessionTemplate.selectList("getUserList",user);
            return users;
        }
        else {
            return null;
        }
    }


    @RequestMapping("/updateUser")
    @ApiOperation(value = "更新用户",httpMethod = "POST")
    public int updateUser(HttpServletRequest request,@RequestBody User user){
        boolean isValidCookie = verifyCookies(request);
        int result = 0;
        if (isValidCookie){
          result =  sqlSessionTemplate.update("addUser",user);
          return result;
        }
        else{
            return result;
        }
    }

    private boolean verifyCookies(HttpServletRequest request){
        Cookie [] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return false;
        }
        for(Cookie cookie : cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return true;
            }
        }
        return false;
    }
}
