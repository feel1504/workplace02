package com.cy.test.user;

import com.cy.pj.common.vo.RolesVo;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysUserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysUserServiceTest {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Test
    public void selectPage(){
        List<SysUserDeptVo> objects = sysUserDao.findPageObjects("", 0, 4);
        for(SysUserDeptVo s : objects){
            System.out.println(s);
        }
    }

    @Test
    public void doValidById(){
        int row= sysUserDao.doValidById(1,0);
        System.out.println(row);
    }

    @Test
    public void doFindRoles(){
        List<RolesVo> rolesVos = sysRoleDao.doFindRoles();
        System.out.println(rolesVos);
    }

}
