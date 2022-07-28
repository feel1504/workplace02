package cn.gzsxy.controller;

import cn.gzsxy.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
    @Autowired
    DoorService service;

    //显示主页面
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }
}
