package cn.gzsxy.controller;

import cn.gzsxy.pojo.Order;
import cn.gzsxy.service.DoorService;
import cn.gzsxy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class orderController {
    @Autowired
    OrderService orderService;
    @Autowired
    DoorService doorService;

    //显示所有订单
    @RequestMapping("/orderList")
    public String findAll(Model model){
        List<Order> order = orderService.findAll();
        model.addAttribute("list",order);
        return "/order_list";
    }
    //删除订单
    @RequestMapping("/orderDelete")
    public String deleteById(Integer id){
        orderService.deleteById(id);
        return "redirect:/orderList";
    }
    //修改订单
    //1)返回修改信息
    @RequestMapping("/orderInfo")
    public String orderInfo(Integer id,Model model){
        Order order = orderService.selectById(id);
        model.addAttribute("order",order);
        return "redirect:/orderList";
    }
    //2)提交
}
