package com.cy.pj.sys.dao;

import com.cy.pj.sys.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysLogDao {
    /**
     * 基于条件分页查询日志信息
     * @param username 查询条件，例如查询哪个用户的日志信息
     * @param startIndex 当前页的起始位置
     * @param pageSize  当前页的页面大小
     * @return    当前页的日志记录信息
     * 数据中每条日志信息封装到一个SysLog对象中
     */
   List<SysLog> findPageObjects(
           @Param("username") String username,
           @Param("startIndex")Integer startIndex,
           @Param("pageSize")Integer pageSize);

    /**
     * 基于条件查询总记录数
     * @param username 查询条件，例如查询哪个用户的日志信息
     * @return 总记录数
     * 说明：假如如下方法对应的sql是动态sql，该方法的参数没有被@Param注解
     * 可能会出现There is no getter for porperty nname ‘username’
     * in class java.lang.String
     */
   int getRowCount(String username);

   int deleteObject(Integer ... ids);

   int insertObject(SysLog log);
}
