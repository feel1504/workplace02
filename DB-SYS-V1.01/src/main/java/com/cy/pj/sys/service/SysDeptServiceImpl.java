package com.cy.pj.sys.service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysDeptDao;
import com.cy.pj.sys.entity.SysDept;
import com.cy.pj.sys.entity.SysMenus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysDeptServiceImpl implements SysDeptService{
    @Autowired
    private SysDeptDao sysDeptDao;
    @Override
    public List<Map<String,Object>> doFindObjects() {
        List<Map<String, Object>> depts = sysDeptDao.doFindObjects();
        return depts;
    }

    @Override
    public void doDeleteObject(Integer id) {
        try {
            sysDeptDao.doDeleteObject(id);
        } catch (Exception e) {
            throw new ServiceException("删除失败，请重试");
        }

    }

    @Override
    public void doSaveObject(SysDept sysDept) {
        sysDeptDao.doSaveObject(sysDept);
    }

    @Override
    public List<Map<String,Object>> doFindZTreeNodes() {
        return sysDeptDao.doFindZTreeNodes();
    }

    @Override
    public void doUpdateObject(SysMenus sysMenus) {

    }
}
