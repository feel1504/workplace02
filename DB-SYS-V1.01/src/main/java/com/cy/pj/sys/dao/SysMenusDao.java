package com.cy.pj.sys.dao;

import com.cy.pj.sys.entity.SysMenus;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysMenusDao {
    List<Map<String,Object>> doFindObjects();

    @Delete("delete from sys_menus where id=#{id}")
    void doDeleteObject(@Param("id") Integer id);

    void doSaveObject(@Param("menus") SysMenus sysMenus);

    @Select("select id,name,parentId from sys_menus")
    List<Map<String, Object>> doFindZtreeMenuNodes();

    @Update("update sys_menus set name=#{menus.name},url=#{menus.url}," +
            "type=#{menus.type},sort=#{menus.sort},parentId=#{menus.parentId}," +
            "permission=#{menus.permission},modifiedTime=now() where id=#{menus.id}")
    void doUpdateObject(@Param("menus") SysMenus sysMenus);
}
