package com.mcl.cony.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mcl.cony.Model.User_Base;
import com.mcl.cony.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "个人信息模块")
@RequestMapping("/admin/personal")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询个人信息",notes = "根据用户名查询个人信息详细内容")
    @GetMapping(value = "/UserInfo")
    public User_Base UserInfo(@RequestParam("username") String username){
        return userService.SelectUserByUN(username);
    }

    @ApiOperation(value = "新增用户(用户注册)",notes = "新增一个用户，具备基本信息")
    @PostMapping(value = "/NewUser")
    public String NewUser(@RequestBody User_Base user){
        int i;
        try{
            i = userService.InsertUser(user);
        }catch (Exception ex){
            throw ex;
        }
        if(i == 0){
            return "Insert failure!";
        }else{
            return "Insert success!";
        }
    }
}
