package com.cy.pj.sys.dao;

import com.cy.pj.common.vo.RolesVo;
import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.entity.SysRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysRoleDao {

    List<SysRole> doFindPageObjects(@Param("name") String name,
                                    @Param("startIndex") Integer startIndex,
                                    @Param("pageSize") Integer pageSize);

    int getRowCount(@Param("name") String name);

    int doSaveObject(@Param("roles") SysRole sysRole);

    @Delete("delete from sys_roles where id=#{id}")
    int doDeleteObject(@Param("id") Integer id);

    //连表查询数据
    SysRoleMenuVo findObjectById(Integer id);

    void doUpdateObject(SysRole sysRole);

    @Select("select id,name from sys_roles")
    List<RolesVo> doFindRoles();

    @Select("select count(*) from sys_roles where")
    int isExists(String columnName, String columnValue);
}
