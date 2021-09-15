package com.boot.demo.config.security.user;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author badpoone
 * @date 2021/6/16  21:02
 */
public class RoleDetail implements GrantedAuthority {

    private String role = "user";

    public String getRole() {
        return role;
    }

    public RoleDetail setRole(String role) {
        this.role = role;
        return this;
    }

    @Override
    public String getAuthority() {
        return role;
    }

}
