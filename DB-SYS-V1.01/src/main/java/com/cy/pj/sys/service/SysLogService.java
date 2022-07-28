package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;

public interface SysLogService {
    /**
     * 获取当前页的分页信息
     * @param username 用户名
     * @param pageCurrent 当前页码值
     * @return 返回值封装了当前页记录以及页面信息的对象
     */
    PageObject<SysLog> findPageObjects(String username,Integer pageCurrent);

    int deleteObject(Integer ... ids);

}
