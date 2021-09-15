package com.boot.demo.config.manager;

import org.springframework.security.core.Authentication;
import reactor.core.publisher.Mono;

/**
 * @author badpoone
 * @date 2021/6/18  23:04
 */
public interface SSOManager {

    /**
     *sso 登出
     * @param key  redis key
     */
   void logout(String key) ;


    /**
     * 保存security 认证对象
     * @param authentication 认证信息
     * @param token 自定义token
     */
    void saveAuthentication(Authentication authentication, String token);


    Mono<Authentication> getAuthenticationByToken(String token);


}
