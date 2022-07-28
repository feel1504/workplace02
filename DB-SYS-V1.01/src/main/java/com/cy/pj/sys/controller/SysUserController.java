package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.service.SysRoleService;
import com.cy.pj.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/doFindPageObjects")
    public JsonResult doFindPageObjects(Integer pageCurrent,String username){
        PageObject<SysUserDeptVo> userDepts = sysUserService.doFindPageObjects(pageCurrent,username);
        return new JsonResult(userDepts);
    }

    @RequestMapping("/doValidById")
    public JsonResult doValidById(Integer id ,Integer valid){
        int row = sysUserService.doValidById(id,valid);
        return new JsonResult("update ok");
    }

    @RequestMapping("/isExists")
    public JsonResult isExists(String columnName,String columnValue){
        int row = sysRoleService.isExists(columnName,columnValue);
        return new JsonResult("ok");
    }

}
