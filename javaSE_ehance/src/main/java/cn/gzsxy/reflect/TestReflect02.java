package cn.gzsxy.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
@interface value{
    int value() default 0;
}

class Pool{
    @value(value = 2)
    private int coreSize;

    public int getCoreSize() {
        return coreSize;
    }
}

public class TestReflect02 {
    public static void main(String[] args) throws Exception {
        //1、通过反射造对象
        Class<Pool> cls = Pool.class;
        Pool pool = ObjectFactory.newInstance(cls);
        //2、通过反射为pool对象的coreSize赋值
            //2.1获取注解上的value值
        Field coreSize = cls.getDeclaredField("coreSize");
        value va = coreSize.getAnnotation(value.class);
            //2.2权限设置
        if(!coreSize.isAccessible()){
            coreSize.setAccessible(true);
        }
            //2.3调用属性对象的set方法赋值，va.value获取@value注解的值
        coreSize.set(pool,va.value());

        System.out.println(pool.getCoreSize());

    }
}
