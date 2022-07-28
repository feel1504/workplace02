package cn.gzsxy.dao;

import cn.gzsxy.pojo.Door;

import java.util.List;

public interface DoorMapper {
    //映射DoorMapper.xml文件
    List<Door> findAll();
    //删除门店
    void deleteById(Integer id);
    //修改门店
    //1)返回修改门店信息
    Door selectById(Integer id);
    //2)点击提交按钮
    void updateDoor(Door door);
    //添加门店
    void inserDoor(Door door);
}
