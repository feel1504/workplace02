package cn.gzsxy.service;

import cn.gzsxy.dao.DoorMapper;
import cn.gzsxy.pojo.Door;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoorServiceImpl implements DoorService {
    @Autowired
    DoorMapper doorMapper;
    @Override
    public List<Door> findAll() {
        return doorMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        doorMapper.deleteById(id);
    }

    @Override
    public Door selectById(Integer id) {
        return doorMapper.selectById(id);
    }

    @Override
    public void updateDoor(Door door) {
        doorMapper.updateDoor(door);
    }

    @Override
    public void insertDoor(Door door) {
        doorMapper.inserDoor(door);
    }
}
