package com.boot.demo.config.security.manage;


import com.boot.demo.util.enums.AuthEnum;
import com.boot.demo.util.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;


/**
 * @author badpoone
 * @date 2021/6/15  20:15
 */
@Component
public class AuthenticationManager extends UserDetailsRepositoryReactiveAuthenticationManager {

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * 注入获取用户信息
     * @param reactiveUserDetailsService
     */
    public AuthenticationManager(@Qualifier("reactiveUserDetails") ReactiveUserDetailsService reactiveUserDetailsService) {
        super(reactiveUserDetailsService);
    }

    /**
     * 密码管理器
     */
    @PostConstruct

    private void post(){
        //设置密码加密方法
        super.setPasswordEncoder(passwordEncoder);
    }

    @Override
    protected Mono<UserDetails> retrieveUser(String username){
        return super.retrieveUser(username);
    }


    @Override
    public Mono<Authentication> authenticate(Authentication authentication){

        try {
            return super.authenticate(authentication);
        }catch (LockedException lockedException){
            //账号锁定
            throw new CommonException(AuthEnum.ACCOUNT_IS_LOCK);
        }catch (DisabledException disabledException){
            //账户禁用
            throw new CommonException(AuthEnum.ACCOUNT_IS_DISABLED);
        }catch (AccountExpiredException accountExpiredException){
            // 账户过期
            throw new CommonException(AuthEnum.ACCOUNT_EXPIRED);
        }catch (CredentialsExpiredException credentialsExpiredException){
            // 密码过期
            throw new CommonException(AuthEnum.CREDENTIALS_EXPIRED);
        }catch (BadCredentialsException badCredentialsException){
            // 密码错误
            throw new CommonException(AuthEnum.LOGIN_NAME_OR_PASSWORD_ERROR);
        }

    }


}
