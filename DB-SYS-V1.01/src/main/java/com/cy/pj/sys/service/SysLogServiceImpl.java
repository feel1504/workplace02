package com.cy.pj.sys.service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务对象
 * 1）处理核心业务
 * 2）处理非核心业务(日志，缓存，权限,,,)
 */

@Service
public class SysLogServiceImpl implements SysLogService{
    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
        //1，验证当前页码值是否合法
        if( pageCurrent==null ||  pageCurrent<1){
            throw new IllegalArgumentException("当前页面值不正确");
        }
        //2，基于用户名查询总记录数并进行校验
        int rowCount = sysLogDao.getRowCount(username);
        if(rowCount==0){
            throw new ServiceException("系统没有查到对应记录");
        }
        //3，查询当前记录
        int pageSize=3;
        int startIndex =(pageCurrent-1)*pageSize;
        List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
        //4，封装查询结果并返回
//        int pageCount = rowCount/pageSize;
//        if(rowCount%pageSize!=0){
//            pageCount++;
//        }
        int pageCount=(rowCount-1)/pageSize+1;
        PageObject<SysLog> po = new PageObject<>(rowCount, records, pageCurrent, pageSize);
        return new PageObject<>(rowCount, records, pageCurrent, pageSize);
    }

    @RequiresPermissions("sys:log:delete")
    @Override
    public int deleteObject(Integer... ids) {
        if(ids.length == 0 || ids==null){
            throw new ServiceException("删除不能为空");
        }
        int rows=0;
        try {
            rows = sysLogDao.deleteObject(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

}
