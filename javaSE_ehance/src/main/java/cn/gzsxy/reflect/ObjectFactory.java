package cn.gzsxy.reflect;

import java.lang.reflect.Constructor;

public class ObjectFactory {
    /**
     *
     * @param cls
     * @param paramters
     * @param array
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T>T newInstance(Class<T> cls,Class<?>[] paramters,Object[] array) throws Exception {
        //获取类构造方法
        Constructor<T> constructor = cls.getDeclaredConstructor(paramters);
        //设置可访问
        if(!constructor.isAccessible()){
            constructor.setAccessible(true);
        }
        //构造实例对象
        T t = constructor.newInstance(array);
        return t;
    }
    public static <T>T newInstance(Class<T> cls) throws Exception{
        return newInstance(cls,null,null);
    }
}
