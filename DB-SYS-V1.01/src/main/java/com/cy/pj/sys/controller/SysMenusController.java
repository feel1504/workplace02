package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysMenus;
import com.cy.pj.sys.service.SysMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu/")
public class SysMenusController {
    @Autowired
    private SysMenusService sysMenusService;

    @RequestMapping("/doFindObjects")
    public JsonResult doFindObjects(){
        List<Map<String, Object>> menus = sysMenusService.doFindObjects();
        System.out.println(menus);
        return new JsonResult(menus);
    }

    @RequestMapping("/doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        sysMenusService.doDeleteObject(id);
        return new JsonResult("删除成功");
    }

    @RequestMapping("/doSaveObject")
    public JsonResult doSaveObject(SysMenus sysMenus){
        System.out.println(sysMenus);
        sysMenusService.doSaveObject(sysMenus);
        return new JsonResult("保存成功");
    }

    @RequestMapping("/doFindZtreeMenuNodes")
    public JsonResult doFindZtreeMenuNodes(){
        List<Map<String,Object>> map = sysMenusService.doFindZtreeMenuNodes();
        return new JsonResult(map);
    }

    @RequestMapping("/doUpdateObject")
    public JsonResult doUpdateObject(SysMenus sysMenus){
        System.out.println(sysMenus);
        sysMenusService.doUpdateObject(sysMenus);
        return new JsonResult("ok");
    }


}
