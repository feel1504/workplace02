package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserRoleDao {
    @Delete("delete from sys_user_roles where user_id=#{id}")
    int deleteObjectsByUserId(Integer id);

    @Select("select role_id from sys_user_roles where user_id=#{id}")
    List<Integer> findRoleIdsByUserId(Integer id);
}
