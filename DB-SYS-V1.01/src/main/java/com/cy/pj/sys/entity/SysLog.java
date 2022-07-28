package com.cy.pj.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 1,POJO的英文：plain Ordinary java object  普通Java对象
 * 1）PO的英文：Persistent Object 持久化对象，特点：与表中字段有一一对应关系
 * 2，SysLog对象就是PO对象，与sys_log有映射关系
 * 1）从数据库查询的一个行日志记录，直接封装到SysLog对象
 * 2）同时也可以在内存中封装写入的数据库中的日志信息
 */

@Data
public class SysLog implements Serializable {
    private static final long serialVersionUID = -3321161017279650471L;

    private Integer id;//id
    private String username;//用户名
    private String operation;//用户操作
    private String method;//请求方法
    private String params;//请求参数
    private Long time;//执行时长（毫秒）
    private String ip;//ip地址
    private Date createdTime;//创建时间

}
