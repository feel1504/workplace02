package cn.gzsxy.reflect;

import java.lang.reflect.Constructor;

public class ObjectFactory {
    public static <T>T newInstance(Class<T> cls,Class<?>[] pram,Object[] array) throws Exception {
        Constructor<T> constructor = cls.getDeclaredConstructor(pram);
        if(!constructor.isAccessible()){
            constructor.setAccessible(true);
        }
        T t = constructor.newInstance(array);
        return t;
    }
    public static <T>T newInstance(Class<T> cls) throws Exception {
       return newInstance(cls,null,null);
    }
}
