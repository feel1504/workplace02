package cn.gzsxy.reflect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TestReflect03 {
    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("k1",100);
        map.put("k2",200);

        //1、获取字节码对象
        Class<? extends Map> cls = map.getClass();
        //2、获取对象下的方法对象
        Method put = cls.getDeclaredMethod("put", Object.class, Object.class);
        //3、执行方法对象
        put.invoke(map,"海贼王","罗兵");
        System.out.println(map);
    }

}
