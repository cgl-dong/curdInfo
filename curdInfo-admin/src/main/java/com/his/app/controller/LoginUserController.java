package com.his.app.controller;


import com.his.app.component.MyException;
import com.his.app.config.ExceptionConfig;
import com.his.app.mapper.Login_userMapper;
import com.his.app.pojo.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-08-29
 */
@Api("登录接口")
@RestController
public class LoginUserController {

    @Autowired
    Login_userMapper userMapper;

    @ApiImplicitParam(name = "LoginUser",value = "user")
    @ApiOperation("根据用户登录，返回用户信息")
    @PostMapping("/user")
    public LoginUser user(@RequestBody LoginUser user){
        LoginUser login_user = userMapper.find(user);
        return login_user;
    }

    @ApiOperation("返回系统用户")
    @GetMapping("/sys_user")
    public List<LoginUser> sysUser(){
        List<LoginUser> users = userMapper.selectList(null);
        return users;
    }

}

