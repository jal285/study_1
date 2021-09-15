package com.boot.demo.controller;

import com.boot.demo.mapper.UserMapper;
import com.boot.demo.pojo.Login_info;
import com.boot.demo.pojo.User;
import com.boot.demo.service.LoginHandle;
import com.boot.demo.service.LoginInfoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author badpoone
 */
@RestController
public class Regiter {
    @Resource
    LoginHandle loginHandle;
    @Resource
    LoginInfoHandler loginInfoHandler;

    @PostMapping("register")
    public String register(@RequestBody User info){
        //调用service 层 查重并插入数据库
        if(info.getName()==null||info.getPassword()==null){
            return "密码或账号不符合";
        }
        if(loginInfoHandler.selectByName(info.getName())!=null){
            return "您注册的账号已经有了";
        }
        loginHandle.registerHandler(info);
     //   System.out.println("reg  succ");
        //考虑加如cookie , 注册完登陆, 但没必要
        return  "succcess";
    }

}
