package com.boot.demo.config.security.user;

import com.boot.demo.pojo.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author badpoone
 * @date 2021/6/16  20:56
 */
public class UserDetail implements UserDetails {


    /**
     * 雪花主键
     */
    private Long id;

    private Date createTime;

    private Date updateTime;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 密码
     */
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

    private Long userId;


    /**
     * 角色信息
     */
    private List<RoleDetail> roleInfoList;


    /**
     * 提供鉴权信息
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleInfoList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return loginName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getId() {
        return id;
    }

    public UserDetail setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserDetail setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UserDetail setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public UserDetail setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public UserDetail setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public UserDetail setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
        return this;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public UserDetail setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
        return this;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public UserDetail setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public UserDetail setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserDetail setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public List<RoleDetail> getRoleInfoList() {
        return roleInfoList;
    }

    public UserDetail setRoleInfoList(List<RoleDetail> roleInfoList) {
        this.roleInfoList = roleInfoList;
        return this;
    }
}
