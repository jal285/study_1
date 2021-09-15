package com.boot.demo.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.Date;

/**
 * @author badpoone
 */
@Data
@ToString
@Component
public class Login_info {
    private long id;
    private long userId;
    private String name;
    private String password;


    /**
     * 账户没有过期
     */
    private Boolean accountNonExpired;

    /**
     * 账户没被锁定
     */
    private Boolean accountNonLocked;

    /**
     * 密码没有过期
     */
    private Boolean credentialsNonExpired;

    /**
     * 账户是否可用
     */
    private Boolean enabled;
    private String salt;
    private int status;
    //可为null
    private int deleteFlag;
    //创建时间
    private Date creative;
    //修改时间 not null
    private Date datetime;


}
