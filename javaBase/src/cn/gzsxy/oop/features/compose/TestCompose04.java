package cn.gzsxy.oop.features.compose;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TestCompose04 {
    public static void main(String[] args) {
        FifoCache fifoCache = new FifoCache(2);
        fifoCache.put("A",100);
        fifoCache.put("E",300);
        fifoCache.put("D",1100);
        fifoCache.put("Q",3400);
        System.out.println(fifoCache);
    }
}

//构建先进先出的一个cache对象
class FifoCache{
    //借助此（Map）对象缓存数据
    private Map<String, Object> cacheMap;
    //借助此（LinkedList）对象记录顺序
    private LinkedList<String> keyList;
    //限制最大容量
    private int maxCap;

    public FifoCache(int maxCap){
        cacheMap = new HashMap<String, Object>(maxCap);
        keyList = new LinkedList<>();
        this.maxCap = maxCap;
    }
    //将数据存到cache中
    public void put(String key,Object val){
        //1、记录key的顺序
        keyList.addLast(key);
        //2、判定容器是否满了，若满了则移除第一个
        if(keyList.size() > maxCap){
            cacheMap.remove(keyList.removeFirst());
        }
        //3、添加新元素
        cacheMap.put(key,val);
        System.out.println(cacheMap);
    }
    public Object get(String key){
        return cacheMap.get(key);
    }

    @Override
    public String toString() {
        return "FifoCache{" +
                "cacheMap=" + cacheMap +
                ", keyList=" + keyList +
                ", maxCap=" + maxCap +
                '}';
    }
}
