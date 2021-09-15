package com.boot.demo.mapper;

import com.boot.demo.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity com.boot.demo.pojo..UserRole
 */
@Mapper
public interface UserRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

}




