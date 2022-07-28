package com.cy.test.log;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest//将测试类纳入spring管理
public class SysLogServiceTest {
    @Autowired//自动注入
    SysLogService sysLogService;
    @Test
    public void testFindPageObjects(){
        PageObject<SysLog> po = sysLogService.findPageObjects("a", 1);
        System.out.println(po.getPageCount());
        System.out.println("rows:"+po.getRecords().size());
    }
}
