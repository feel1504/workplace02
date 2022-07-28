package com.cy.pj.sys.dao;

import com.cy.pj.sys.entity.SysDept;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysDeptDao {

    List<Map<String,Object>> doFindObjects();

    @Delete("delete from sys_depts where id=#{id}")
    void doDeleteObject(@Param("id") Integer id);

    @Insert("insert into sys_depts values(#{dept.id},#{dept.name}," +
            "#{dept.parentId},#{dept.sort},#{dept.note}," +
            "now(),now(),#{dept.createdUser}," +
            "#{dept.modifiedUser})")
    void doSaveObject(@Param("dept") SysDept sysDept);

    @Select("select id,name,parentId from sys_depts")
    List<Map<String,Object>> doFindZTreeNodes();

    List<SysDept> findById(Integer id);
}
