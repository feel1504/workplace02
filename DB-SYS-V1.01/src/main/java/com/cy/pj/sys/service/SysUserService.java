package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;

public interface SysUserService {

    PageObject<SysUserDeptVo> doFindPageObjects(Integer pageCurrent, String username);

    int doValidById(Integer id, Integer valid);
}
