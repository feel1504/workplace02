package cn.gzsxy.service;

import cn.gzsxy.dao.OrderMapper;
import cn.gzsxy.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;
    //查询所有订单
    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }
    //删除订单
    @Override
    public void deleteById(Integer id) {
        orderMapper.deleteById(id);
    }

    //修改订单
    //1)返回修改信息
    @Override
    public Order selectById(Integer id) {
        Order order = orderMapper.selectById(id);
        return order;
    }
}
