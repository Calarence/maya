package com.appleieye.maya.controller;


import com.appleieye.maya.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.chart.ValueAxis;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "/",description = "User接口")
public class UserController {

    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数量",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }


    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户",httpMethod = "POST")
    public int addUser(@RequestBody User user){
        return template.insert("addUser",user);

    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    @ApiOperation(value = "更新用户信息",httpMethod = "PUT")
    public int modifyUser(@RequestBody User user){
        return template.update("updateUser",user);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户",httpMethod = "DELETE")
    public int deleteUser(@RequestParam int id){
        return template.delete("deleteUser",id);

    }
}
