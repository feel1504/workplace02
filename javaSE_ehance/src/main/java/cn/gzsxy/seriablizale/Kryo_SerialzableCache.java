package cn.gzsxy.seriablizale;

import org.apache.ibatis.cache.Cache;

import java.io.*;
import java.util.concurrent.locks.ReadWriteLock;

/*
实现序列化Cache
 */
public class Kryo_SerialzableCache implements Cache{
    private Cache cache;

    //为注入ParameterCache做的构造方法
    Kryo_SerialzableCache(Cache cache){
        this.cache = cache;
    }



    //序列化方法
    @Override
    public void putObject(Object key, Object value) {
        //将对象转为字节数组后存入一个cache-----序列化
        if(value != null && value instanceof Serializable) {
            try {
                cache.putObject(key, Serializable_Kryo_Util.serialize(value.getClass(),(Serializable)value));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //反序列化方法
    @Override
    public Object getObject(Object key) {
        //1、从cache中根据key取出对象字节数组
        Object array = cache.getObject(key);
        Object obj = null;
        try {
            if(array != null) {
                //2、字节数组反序列化，并返回对象
                obj = Serializable_Kryo_Util.doserialize(Article1.class,(byte[]) array);
            }else{
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("反序列化异常");
        }
        return obj;
    }

    @Override
    public Object removeObject(Object key) {
        return cache.removeObject(key);
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }
}
