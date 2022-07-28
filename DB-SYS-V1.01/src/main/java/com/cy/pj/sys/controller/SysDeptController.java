package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysDept;
import com.cy.pj.sys.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dept/")
public class SysDeptController{
    @Autowired
    private SysDeptService sysDeptService;
    @RequestMapping("/doFindObjects")
    public JsonResult doFindObjects(){
        return new JsonResult(sysDeptService.doFindObjects());
    }

    @RequestMapping("/doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        sysDeptService.doDeleteObject(id);
        return new JsonResult("删除成功");
    }

    @RequestMapping("/doSaveObject")
    public JsonResult doSaveObject(SysDept sysDept){
        System.out.println(sysDept);
        sysDeptService.doSaveObject(sysDept);
        return new JsonResult("添加成功");
    }

    @RequestMapping("/doFindZTreeNodes")
    public JsonResult doFindZTreeNodes(){
        System.out.println();
        List<Map<String,Object>> list = sysDeptService.doFindZTreeNodes();
        System.out.println(list);
        return new JsonResult(list);
    }


}
