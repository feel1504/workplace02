package com.cy.test.log;

import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest//将测试类纳入spring管理
public class SysLogDaoTest {
    @Autowired//自动注入
    private SysLogDao sysLogDao;

    @Test
    public void testGetRowCount(){
        int rowCount = sysLogDao.getRowCount(null);
        System.out.println(rowCount);
    }
    @Test
    public void testFindPageObjects(){
        List<SysLog> list = sysLogDao.findPageObjects("admin", 0, 3);
        System.out.println(list);
    }
}
