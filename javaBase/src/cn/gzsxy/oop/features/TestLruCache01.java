package cn.gzsxy.oop.features;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestLruCache01 {
    public static void main(String[] args) {
//        doTestLinkeHashMap01();
        doTestLinkeHashMap02();//测试删除缓存
    }

    private static void doTestLinkeHashMap02() {
        LruCache cache = new LruCache(3);
        cache.put("A",100);
        cache.put("D",400);
        cache.put("B",200);
        cache.get("A");
        cache.put("C",300);
        System.out.println(cache);
    }

    private static void doTestLinkeHashMap01() {
        /*
        LinkedHashMap:
            1）数据结构：链表+散列表
            2）算法：记录元素添加顺序（false），记录元素的访问顺序(true)
        */
        LinkedHashMap<String ,Integer> linkMap = new LinkedHashMap<String ,Integer>(
                3,//初始容量
                0.75F,//加载因子
                true//false记录添加顺序，默认false，true记录访问顺序
        ){//内部类
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                if(this.size() > 3){
                    return true;
                }
                return false;
            }
        };//有序
        linkMap.put("A",1231);
        linkMap.put("D",1232);
        linkMap.get("A");
        linkMap.put("C",1233);
        linkMap.put("B",1234);
        System.out.println(linkMap.get("D"));//get一个不存在的key，返回null
        System.out.println(linkMap);
    }
}

class LruCache extends LinkedHashMap<String,Object>{
    private static final long serialVersionUID = 7316490288930118999L;

    private int maxCap;
    public LruCache(int maxCap){
        super(maxCap,0.75F,true);
        this.maxCap = maxCap;
    }

    @Override
    protected synchronized boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
        return size()>maxCap;
    }
}
