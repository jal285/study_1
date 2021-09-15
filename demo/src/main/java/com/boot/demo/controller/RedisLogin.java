package com.boot.demo.controller;


import com.boot.demo.service.LoginHandle;

import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.boot.demo.config.redis.RedisUtils;
import javax.annotation.Resource;

import java.util.Map;
import java.util.UUID;

/**
 * @author badpoone
 */
@RestController
@RequestMapping("/usr")
public class RedisLogin {

    @Resource
    RedisUtils redisUtils;

    @Resource
    LoginHandle loginHandle;

    @RequestMapping("/login")
    public  String login(@RequestParam("user")String user,@RequestParam("password") String password){

        String uuid = UUID.randomUUID().toString();
        //签发token
        String token = loginHandle.getToken(user,uuid);
        redisUtils.set(token,user);
        WebFluxProperties.Cookie cookie = new WebFluxProperties.Cookie();
      //  cookie cookie = new Cookie(token,user);
        redisUtils.set(token,user);
        // 验证数据
        if(user.equals("user")){
            return "success";
            //加入redis 缓存
            //跳转主页面返回数据
        }
        return "welcome " + user;
    }

    @PostMapping("/test")
    public  String login(@RequestParam Map <String,Object> params){

        return "name:" + params.get("name");
    }


    @RequestMapping("/index")
    public String index(@RequestParam("token") String token){
        if(redisUtils.get(token)==null){
            return "no permission ";
        }
        return "index";
    }

    @GetMapping("/echo")
    public Mono<String> sayHello(){
        return Mono.just("echo");
    }

}
