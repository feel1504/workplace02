package com.cy.test.menu;


import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.entity.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysMenuServiceTest {
    @Autowired
    SysRoleDao sysRoleDao;
    @Autowired
    SysRoleMenuDao sysRoleMenuDao;
    @Test
    public void getMenus(){
        List<SysRole> menus = sysRoleDao.doFindPageObjects("开", 2, 2);
        for(SysRole s:menus){
            System.out.println(s);
        }
    }
    @Test
    public void getRows(){
        int row = sysRoleDao.getRowCount(null);
        System.out.println(row);
    }
//    @Test
//    public void insertRoles(){
//        SysRole role = new SysRole(10,"运维","周期维护",null,null,"admin","admin");
//        int i = sysRoleDao.doSaveObject(role);
//        System.out.println(i);
//    }
    @Test
    public void insertRolesO(){
        Integer[] arr={22,33,44};
        sysRoleMenuDao.insertObjects(5,arr);
        System.out.println("成功");
    }

    @Test
    public void findObjectById(){
        SysRoleMenuVo objectById = sysRoleDao.findObjectById(4);
        System.out.println(objectById);
    }

    @Test
    public void doUpdateObject(){
        SysRole role = new SysRole();
        role.setId(67);
        role.setName("前端开发1");
        sysRoleDao.doUpdateObject(role);
        System.out.println();
    }
}
