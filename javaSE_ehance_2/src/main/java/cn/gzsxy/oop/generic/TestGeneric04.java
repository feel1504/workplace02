package cn.gzsxy.oop.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//求证：泛型在运行时无效
//泛型类擦除
public class TestGeneric04 {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("a");
        Class<? extends List> cls = list.getClass();
        Method add = cls.getDeclaredMethod("add", Object.class);
        add.invoke(list,100);
        System.out.println(list);

        Method add1 = cls.getDeclaredMethod("add", int.class, Object.class);
        add1.invoke(list,0,200);
        System.out.println(list);
    }
}
