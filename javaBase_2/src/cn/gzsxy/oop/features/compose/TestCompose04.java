package cn.gzsxy.oop.features.compose;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TestCompose04 {
    public static void main(String[] args) {
        FifoCache cache = new FifoCache(3);
        cache.put("A",1);
        cache.put("S",2);
        cache.put("K",5);
        cache.put("W",55);
        System.out.println(cache);
    }
}

class FifoCache{
    //存存进去的key顺序
    private LinkedList<String> keyList;
    //存数据
    private Map<String,Integer> map;
    //定义这个map要存的数据量
    private int maxSize;

    public FifoCache(int maxSize){
        keyList = new LinkedList<>();
        map = new HashMap<>(maxSize);
        this.maxSize = maxSize;
    }
    public void put(String key,Integer val){
        //加入keyList
        keyList.addLast(key);
        //判断是否超过容量，超过删除先进去的
        if(keyList.size()>maxSize){
            map.remove(keyList.removeFirst());
        }
        //添加新的到map
        map.put(key,val);
        System.out.println(map);
    }

    @Override
    public String toString() {
        return "FifoCache{" +
                "keyList=" + keyList +
                ", map=" + map +
                ", maxSize=" + maxSize +
                '}';
    }
}
