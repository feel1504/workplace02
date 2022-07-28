package com.cy.pj.sys.service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysMenusDao;
import com.cy.pj.sys.entity.SysMenus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SysMenusServiceImpl implements SysMenusService{
    @Autowired
    private SysMenusDao sysMenusDao;
    @Override
    public List<Map<String, Object>> doFindObjects() {
        List<Map<String, Object>> menus = null;
        try {
            menus = sysMenusDao.doFindObjects();
        } catch (Exception e) {
            throw new ServiceException("查询错误");
        }
        if(menus==null || menus.size()==0){
            log.error("记录不存在");
            throw new ServiceException("记录不存在");
        }
        return menus;
    }

    @Override
    public void doDeleteObject(Integer id) {
        if(id==null || id<1){
            throw new IllegalArgumentException("id值无效");
        }

        try {
            sysMenusDao.doDeleteObject(id);
        } catch (Exception e) {
            throw new ServiceException("删除失败");
        }
    }

    @Override
    public void doSaveObject(SysMenus sysMenus) {
        if(sysMenus==null){
            throw new ServiceException("菜单不能为空");
        }
        if(StringUtils.isEmpty(sysMenus.getName())){
            throw new ServiceException("菜单的名称不能为空");
        }
        sysMenusDao.doSaveObject(sysMenus);
    }

    @Override
    public List<Map<String, Object>> doFindZtreeMenuNodes() {
        List<Map<String,Object>> map = sysMenusDao.doFindZtreeMenuNodes();
        if(map==null || map.size()==0){
            log.error("记录不存在");
            throw new ServiceException("记录不存在");
        }
        return map;
    }

    @Override
    public void doUpdateObject(SysMenus sysMenus) {
        sysMenusDao.doUpdateObject(sysMenus);
    }


}
