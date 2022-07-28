package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log/")
public class SysLogController {
    @Autowired
    SysLogService sysLogService;

    /**查询日志列表*/
    @RequestMapping("/doFindPageObjects")
    public JsonResult doFindPageObjects(String username,Integer pageCurrent){
        PageObject<SysLog> pageObjects = sysLogService.findPageObjects(username, pageCurrent);
        System.out.println(pageObjects);
        return new JsonResult(pageObjects);
    }

    @RequestMapping("/doDeletePageObjects")
    public JsonResult doDeletePageObjects(Integer ... ids){
        int rows = sysLogService.deleteObject(ids);
        return new JsonResult("删除成功，删除数据"+rows +"条");
    }


}
