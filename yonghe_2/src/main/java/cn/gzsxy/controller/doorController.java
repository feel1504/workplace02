package cn.gzsxy.controller;

import cn.gzsxy.pojo.Door;
import cn.gzsxy.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class doorController<STrin> {
    @Autowired
    DoorService doorService;

    //查询门店
    @RequestMapping("/doorList")
    public String list(Model model){
        List<Door> list = doorService.findAll();
        model.addAttribute("list",list);
        return "door_list";
    }

    //删除门店
    @RequestMapping("/doorDelete")
    public String delete_door(Integer id){
        doorService.deleteById(id);
        return "redirect:/doorList";
    }

    //修改门店
    //1）通过id返回信息
    @RequestMapping("/doorInfo")
    public String doorInfo(Integer id,Model model){
        Door door = doorService.selectById(id);
        model.addAttribute("door",door);
        return "/door_update";
    }
    //2）点击确认修改按钮
    @RequestMapping("/doorUpdate")
    public String doorUpdate(Door door){
        doorService.updateDoor(door);
        return "redirect:/doorList";
    }

    //添加门店
    @RequestMapping("/doorAdd")
    public String insertDoor(Door door){
        doorService.insertDoor(door);
        System.out.println(door);
        return "redirect:/doorList";
    }
}
