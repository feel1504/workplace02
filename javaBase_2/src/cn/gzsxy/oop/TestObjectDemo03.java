package cn.gzsxy.oop;

/*
编写对象工厂，通过工厂基于类的字节码对象创建类的实例对象
 */

import java.util.Date;

public class TestObjectDemo03 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Object o = ObjectFactory.newInstance(Date.class);
        System.out.println(o);

        class AAA{}

        Object o1 = ObjectFactory.newInstance(AAA.class);
        System.out.println(o1);
    }
}

class ObjectFactory{
    public static Object newInstance(Class<?> cls) throws InstantiationException, IllegalAccessException {
        return cls.newInstance();
    }
}