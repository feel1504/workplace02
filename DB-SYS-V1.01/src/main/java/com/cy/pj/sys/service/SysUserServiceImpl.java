package com.cy.pj.sys.service;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.dao.SysUserDao;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserDao sysUserDao;
    @Override
    public PageObject<SysUserDeptVo> doFindPageObjects(Integer pageCurrent, String username) {
        //当前值是否合法
        if(pageCurrent==null || pageCurrent<1){
            System.out.println("到这儿了");
            throw new IllegalArgumentException("当前页面值不正确");
        }
        //查询总记录数校验
        int rowCount = sysUserDao.getRowCount(username);
        if(rowCount == 0){
            throw new ServiceException("没有查询到记录");
        }

        int pageSize=4;
        int startIndex=pageSize*(pageCurrent-1);
        System.out.println(startIndex + " :" + pageSize + ":" + rowCount);
        List<SysUserDeptVo> users = sysUserDao.findPageObjects(username, startIndex, pageSize);

        PageObject<SysUserDeptVo> pageObject = new PageObject<>(rowCount, users, pageCurrent, pageSize);
        System.out.println(pageObject);
        return pageObject;
    }

    @RequiredLog("禁用启用")
    @RequiresPermissions("sys:user:valid")
    @Override
    public int doValidById(Integer id, Integer valid) {
        if(id==null || id<1){
            throw new ServiceException("id值不对");
        }
        if(valid != 0 && valid != 1){
            throw new ServiceException("valid不符合要求");
        }
        int row = sysUserDao.doValidById(id,valid);
        return row;
    }
}
