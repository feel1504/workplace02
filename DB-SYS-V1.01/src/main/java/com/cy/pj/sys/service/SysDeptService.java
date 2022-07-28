package com.cy.pj.sys.service;

import com.cy.pj.sys.entity.SysDept;
import com.cy.pj.sys.entity.SysMenus;

import java.util.List;
import java.util.Map;

public interface SysDeptService {
    List<Map<String,Object>> doFindObjects();

    void doDeleteObject(Integer id);

    void doSaveObject(SysDept sysDept);

    List<Map<String,Object>> doFindZTreeNodes();

    void doUpdateObject(SysMenus sysMenus);
}
