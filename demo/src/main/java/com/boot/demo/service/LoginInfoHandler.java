package com.boot.demo.service;

import com.boot.demo.pojo.Login_info;

/**
 * @author badpoone
 */

public interface LoginInfoHandler {
    public  String insertIntoTable(Login_info info);
    public Login_info selectByName(String name);
}
