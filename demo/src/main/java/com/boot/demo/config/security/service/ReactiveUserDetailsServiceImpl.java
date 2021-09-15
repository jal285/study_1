package com.boot.demo.config.security.service;

import com.boot.demo.config.security.user.UserDetail;
import com.boot.demo.mapper.UserMapper;
import com.boot.demo.pojo.Login_info;
import com.boot.demo.pojo.UserRole;
import com.boot.demo.util.enums.AuthEnum;
import com.boot.demo.util.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author badpoone
 * @date 2021/6/16  20:50
 */
@Component("reactiveUserDetails")
public class ReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户的基本信息
     * @param loginName
     * @return
     */
    @Override
    public Mono<UserDetails> findByUsername(String loginName) {
        Login_info loginInfo = userMapper.selectByName(loginName);
        if(Objects.isNull(loginInfo)){
            // 查不到数据，或者数据已标记删除
            throw new CommonException(AuthEnum.LOGIN_NAME_OR_PASSWORD_ERROR);
        }
        UserDetail userDetail = touserDetail(loginInfo);
        // todo roleList


        return Mono.just(userDetail);
    }

    private UserDetail touserDetail(Login_info domain) {
        if(domain==null){
            return null;
        }
        UserDetail userDetail=new UserDetail();
        userDetail.setId(domain.getId());
        userDetail.setUserId(domain.getUserId());
        userDetail.setCreateTime(domain.getCreative());
        userDetail.setUpdateTime(domain.getDatetime());
        userDetail.setLoginName(domain.getName());
        userDetail.setPassword(domain.getPassword());
        userDetail.setAccountNonExpired(domain.getAccountNonExpired());
        userDetail.setAccountNonLocked(domain.getAccountNonLocked());
        userDetail.setCredentialsNonExpired(domain.getCredentialsNonExpired());
        userDetail.setEnabled(domain.getEnabled());
        userDetail.setUserId(domain.getUserId());

        return userDetail;

    }
}
