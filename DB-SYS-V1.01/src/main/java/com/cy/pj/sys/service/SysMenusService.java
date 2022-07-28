package com.cy.pj.sys.service;

import com.cy.pj.sys.entity.SysMenus;

import java.util.List;
import java.util.Map;

public interface SysMenusService {
    List<Map<String,Object>> doFindObjects();

    void doDeleteObject(Integer id);

    void doSaveObject(SysMenus sysMenus);

    List<Map<String, Object>> doFindZtreeMenuNodes();

    void doUpdateObject(SysMenus sysMenus);
}
