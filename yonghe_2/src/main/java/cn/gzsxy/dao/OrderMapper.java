package cn.gzsxy.dao;

import cn.gzsxy.pojo.Order;

import java.util.List;

public interface OrderMapper {
    //查询所有订单
    List<Order> findAll();
    //删除订单
    void deleteById(Integer id);
    //修改订单
    //1)返回修改信息
    Order selectById(Integer id);
}
