package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.RolesVo;
import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.entity.SysRole;

import java.util.List;

public interface SysRoleService {
    PageObject<SysRole> doFindPageObjects(String name,Integer pageCurrent);
    int doSaveObject(SysRole sysRole,Integer[] menuIds);
    int doDeleteObject(Integer id);
    SysRoleMenuVo findObjectById(Integer id);

    void doUpdateObject(SysRole sysRole,Integer[] menuIds);

    List<RolesVo> doFindRoles();

    int isExists(String columnName, String columnValue);
}
