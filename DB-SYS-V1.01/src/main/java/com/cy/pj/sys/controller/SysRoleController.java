package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.RolesVo;
import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role/")
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    @GetMapping("/doFindPageObjects")
    public JsonResult doFindPageObjects(String name,Integer pageCurrent){
        PageObject<SysRole> roles = sysRoleService.doFindPageObjects(name,pageCurrent);
        System.out.println(roles);
        return new JsonResult(roles);
    }
    @PostMapping("/doSaveObject")
    public JsonResult doSaveObject(SysRole sysRole,Integer[] menuIds){
        System.out.println(sysRole);
        int row = sysRoleService.doSaveObject(sysRole,menuIds);
        return new JsonResult("insert ok");
    }
    @RequestMapping("/doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        sysRoleService.doDeleteObject(id);
        return new JsonResult("delete ok");
    }

    @RequestMapping("/doFindObjectById")
    public JsonResult doFindObjectById(Integer id){
        SysRoleMenuVo menuVo = sysRoleService.findObjectById(id);
        return new JsonResult(menuVo);
    }

    @RequestMapping("/doUpdateObject")
    public JsonResult doUpdateObject(SysRole sysRole,Integer[] menuIds){
        sysRoleService.doUpdateObject(sysRole, menuIds);
        return new JsonResult("ok");
    }

    @RequestMapping("/doFindRoles")
    public JsonResult doFindRoles(){
        List<RolesVo> rolesVos = sysRoleService.doFindRoles();
        return new JsonResult(rolesVos);
    }
}
