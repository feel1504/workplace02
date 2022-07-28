package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleMenuDao {

    int insertObjects(@Param("roleId") Integer roleId, @Param("menuIds") Integer[] menuIds);

    @Delete("delete from sys_role_menus where role_id = #{id}")
    void doDeleteObject(@Param("id") Integer id);
}
