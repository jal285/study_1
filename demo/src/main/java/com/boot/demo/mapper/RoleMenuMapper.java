package com.boot.demo.mapper;

import com.boot.demo.pojo.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity com.boot.demo.pojo..RoleMenu
 */
@Mapper
public interface RoleMenuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);

}




