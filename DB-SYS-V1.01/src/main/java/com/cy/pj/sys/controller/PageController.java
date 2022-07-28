package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PageController负责呈现项目中所有的页面
 */

@Controller
@RequestMapping("/")  //localhost/doIndexUI
public class PageController {
    @RequestMapping("doIndexUI")
    public String doIndexUI(){
        //System.out.println("doIndexUI");
        return "starter";
    }

    @RequestMapping("doPageUI")
    public String doPageUI(){
        return "common/page";
    }

    @RequestMapping("{model}/{ui}")
    //基于rest框架风格返回某个模块的UI页面
    public String doModelUI(@PathVariable("ui") String ui){
        return "sys/"+ui;
    }

    /**返回登录页面**/
    @RequestMapping("/doLoginUI")
    public String doLoginUI(){
        return "login";
    }
 /*   log/log_list
    @RequestMapping("log/log_list")
    public String doLogUI(){
        return "sys/log_list";
    }

    @GetMapping("menu/menu_list")
    public String doMenu_list(){
        return "sys/menu_list";
    }

    @GetMapping("dept/dept_list")
    public String doDept_list(){
        return "sys/dept_list";
    }

    @GetMapping("role/role_list")
    public String doRole_list(){
        return "sys/role_list";
    }

    @GetMapping("user/user_list")
    public String doUser_list(){
        return "sys/user_list";
    }

    @GetMapping("dept/dept_edit")
    public String doDept_edit(){
        return "sys/dept_edit";
    }

    @GetMapping("menu/menu_edit")
    public String doLoadEditUI(){
        return "sys/menu_edit";
    }

    @GetMapping("pwd/pwd_edit")
    public String doLoadPwd_edit(){
        return "sys/pwd_edit";
    }*/

}
