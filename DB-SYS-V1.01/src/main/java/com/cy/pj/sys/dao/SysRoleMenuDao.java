package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleMenuDao {

    /**
     * 基于多个角色id获取菜单id
     */
    List<Integer> findMenuIdsByRoleIds(@Param("roleIds") Integer[] roleIds);

    int insertObjects(@Param("roleId") Integer roleId, @Param("menuIds") Integer[] menuIds);

    @Delete("delete from sys_role_menus where role_id = #{id}")
    void doDeleteObject(@Param("id") Integer id);
}
