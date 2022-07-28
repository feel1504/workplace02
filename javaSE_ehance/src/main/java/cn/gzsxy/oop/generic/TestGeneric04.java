package cn.gzsxy.oop.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//求证：泛型在运行时无效
//面试：泛型类型擦除
public class TestGeneric04 {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        //需求：将100这个整数通过反射添加道list集合上
        //反射起点：class类型的对象
        //1：获取list的字节码对象
        Class<?> cls = list.getClass();
        //2：获取list集合中的add方法
        Method method = cls.getDeclaredMethod("add", Object.class);
            //获取list集合中的add方法，将元素添加指定位置
        Method method1 = cls.getDeclaredMethod("add",int.class,Object.class);
        //3；反射执行list集合的add方法
        method.invoke(list,100);
        method1.invoke(list,0,520);
        System.out.println(list);

        //Integer.class和int.class是两个不同的字节码对象，不能相互替代
        System.out.println(Integer.class == int.class);
    }
}

