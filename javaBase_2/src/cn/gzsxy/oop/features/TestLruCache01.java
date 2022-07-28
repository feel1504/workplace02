package cn.gzsxy.oop.features;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestLruCache01 {
    public static void main(String[] args) {
//        doTestLinkeHashMap01();
        LruCache cache = new LruCache(3);
        cache.put("A",123);
        cache.put("H",123);
        cache.put("B",113);
        cache.get("A");
        cache.put("D",1203);
        System.out.println(cache);
    }

    private static void doTestLinkeHashMap01() {
    /*
    LinkedHashMap:
        1）数据结构：链表加散列表
        2）算法：记录添加顺序（false），记录访问顺序(true)
     */
        LinkedHashMap<String , Integer> map = new LinkedHashMap<String,Integer>(
                3,
                0.75F,
                true
        ){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if(this.size() > 3){
                    return true;
                }
                return false;
            }
        };
        map.put("A",100);
        map.put("H",155);
        map.put("O",1050);
        map.get("A");
        map.put("P",4500);
        System.out.println(map);
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
    protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {//为true就删
        return size()>maxCap;
    }
}