package com.boot.demo.util.enums;

import com.boot.demo.util.result.ResultInterface;

/**
 * @author badpoone
 * @date 2021/6/15  22:08
 */
public enum AuthEnum implements ResultInterface {
    /**
     * 用户名或密码错误
     */
    LOGIN_NAME_OR_PASSWORD_ERROR("LOGIN_NAME_OR_PASSWORD_ERROR","用户名或密码错误"),

    /**
     * 账号已停用，请联系管理员
     */
    ACCOUNT_IS_DISABLED("ACCOUNT_IS_DISABLED","账号已停用，请联系管理员"),

    /**
     * 账号已停用，请联系管理员
     */
    ACCOUNT_IS_LOCK("","账号已停用，请联系管理员"),
    /**
     * 账户已过期
     */
    ACCOUNT_EXPIRED("","账户已过期"),
    /**
     * 密码过期
     */
    CREDENTIALS_EXPIRED("","密码过期"),
    /**
     * 无访问权限
     */
    NO_AUTH("NO_AUTH","无访问权限"),

    /**
     * 身份认证失败，请重新登录
     */
    RE_LOGIN("RE_LOGIN","身份认证失败，请重新登录")

    ;
    private  String code;

    private  String message;

    AuthEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
