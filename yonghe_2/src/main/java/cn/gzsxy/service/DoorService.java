package cn.gzsxy.service;

import cn.gzsxy.pojo.Door;

import java.util.List;

public interface DoorService {
    //查询所有门店信息
    List<Door> findAll();
    //删除门店
    void deleteById(Integer id);
    //修改门店
    //1)返回修改门店消息
    Door selectById(Integer id);
    //2)点击提交按钮
    void updateDoor(Door door);
    //添加门店
    void insertDoor(Door door);
}
