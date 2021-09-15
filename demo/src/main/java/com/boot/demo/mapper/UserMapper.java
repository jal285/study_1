package com.boot.demo.mapper;

import com.boot.demo.pojo.Login_info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author badpoone
 */
@Mapper
public interface UserMapper {

    public Login_info selectByName(@Param("name") String name);

    public void insertName(@Param("Login_info")  Login_info info);

}
