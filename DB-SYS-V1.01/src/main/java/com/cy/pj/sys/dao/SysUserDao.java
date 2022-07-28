package com.cy.pj.sys.dao;

import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SysUserDao {
    List<SysUserDeptVo> findPageObjects(
            @Param("username") String username,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);

    int getRowCount(@Param("username") String username);

    @Update("update sys_users set valid=#{valid},modifiedTime=now() where id=#{id}")
    int doValidById(@Param("id") Integer id, @Param("valid") Integer valid);

    @Select("select * from sys_users where username=#{username}")
    SysUser findUserByUserName(String username);
}

