package com.cy.pj.sys.service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.RolesVo;
import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    SysRoleDao sysRoleDao;
    @Autowired
    SysRoleMenuDao sysRoleMenuDao;
    @Override
    public PageObject<SysRole> doFindPageObjects(String name, Integer pageCurrent) {
        //当前值是否合法
        if(pageCurrent==null || pageCurrent<1){
            throw new IllegalArgumentException("当前页面值不正确");
        }
        //查询总记录数校验
        System.out.println(name);
        int rowCount = sysRoleDao.getRowCount(name);
        if(rowCount == 0){
            throw new ServiceException("没有查询到记录");
        }

        int pageSize=4;
        int startIndex=pageSize*(pageCurrent-1);
        List<SysRole> roles = sysRoleDao.doFindPageObjects(name,startIndex,pageSize);

        PageObject<SysRole> pageObject = new PageObject<>(rowCount, roles, pageCurrent, pageSize);

        return pageObject;
    }

    @Override
    public int doSaveObject(SysRole sysRole,Integer[] menuIds) {
        if(sysRole==null){
            throw new ServiceException("角色为空");
        }
        if(StringUtils.isEmpty(sysRole.getName())){
            throw new ServiceException("角色名字为空");
        }
        if(menuIds.length == 0 || menuIds == null){
            throw new ServiceException("必须为角色赋予权限");
        }
        int i = sysRoleDao.doSaveObject(sysRole);

        sysRoleMenuDao.insertObjects(sysRole.getId(),menuIds);
        return i;
    }

    @Override
    public int doDeleteObject(Integer id) {
        if(id==null || id<1){
            throw new ServiceException("id传入错误");
        }
        sysRoleDao.doDeleteObject(id);
        sysRoleMenuDao.doDeleteObject(id);
        return 0;
    }

    @Override
    public SysRoleMenuVo findObjectById(Integer id) {
        if(id<1 || id==null){
            throw new ServiceException("id值不正确");
        }
        SysRoleMenuVo menuVo = sysRoleDao.findObjectById(id);
        if(menuVo==null){
            throw new ServiceException("没查出任何数据");
        }
        return menuVo;
    }

    @Override
    public void doUpdateObject(SysRole sysRole,Integer[] menuIds) {
        if(sysRole == null){
            throw new ServiceException("传入值不正确");
        }
        if(StringUtils.isEmpty(sysRole.getName())){
            throw new ServiceException("名字不能为空");
        }
        if(StringUtils.isEmpty(sysRole.getNote())){
            throw new ServiceException("note不能为空");
        }
        sysRoleDao.doUpdateObject(sysRole);
        sysRoleMenuDao.doDeleteObject(sysRole.getId());
        sysRoleMenuDao.insertObjects(sysRole.getId(), menuIds);
    }

    @Override
    public List<RolesVo> doFindRoles() {
        List<RolesVo> rolesVos = sysRoleDao.doFindRoles();
        return rolesVos;
    }

    @Override
    public int isExists(String columnName, String columnValue) {
        if(columnName == null || columnName == ""){
            throw new ServiceException("字段有错");
        }
        if(columnValue == "" || columnValue==null){
            throw new ServiceException("值不正确");
        }
        int row  = sysRoleDao.isExists(columnName,columnValue);
        return row;
    }
}
