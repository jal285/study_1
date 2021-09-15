package com.boot.demo.service.serviceimpl;

import com.boot.demo.mapper.UserMapper;
import com.boot.demo.pojo.Login_info;
import com.boot.demo.service.LoginInfoHandler;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author badpoone
 * 加入aop ，添加aop security
 */
@Aspect
@Service
public class LoginInfoHanlerImpl implements LoginInfoHandler {

    @Autowired
    UserMapper userMapper;


    @Override
    @Pointcut("execution(* com.boot.demo.controller.RedisLogin)")
    public String insertIntoTable(Login_info info) {
        try {
            userMapper.insertName(info) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "true";
    }

    @Override
    public Login_info selectByName(String name) {
        return   userMapper.selectByName(name);
    }


}
