package cn.gzsxy.seriablizale;

import org.apache.ibatis.cache.Cache;

import java.io.*;
import java.util.concurrent.locks.ReadWriteLock;

/*
实现序列化Cache
 */
public class SerialzableCache implements Cache{
    private Cache cache;

    //为注入ParameterCache做的构造方法
    SerialzableCache(Cache cache){
        this.cache = cache;
    }

    //该方法只接受实现了SerSerializable的对象，将对象序列化为一个字节数组
    public byte[] serializable(Serializable obj){
        try {
            //字节数组输出流内置一个可扩容的数组
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            //构造对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            //将对象序列化到数组
            oos.writeObject(obj);
            oos.flush();
            //取出字节数组
            byte[] array = bos.toByteArray();
            //关闭连接
            oos.close();
            return array;
        } catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException("序列化异常");
        }
    }

    //序列化方法
    @Override
    public void putObject(Object key, Object value) {
        //将对象转为字节数组后存入一个cache-----序列化
        if(value != null && value instanceof Serializable) {
            cache.putObject(key, serializable((Serializable) value));
        }
    }

    //将对象字节数组转为对象
    private Object deserializable(byte[] array) throws Exception{
        //1、构造字节数组输入流
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
        //2、构造对象输入流
        ObjectInputStream ois= new ObjectInputStream(bis);
        //3、反序列化数组，并返回对象
        Object obj = ois.readObject();
        ois.close();
        return obj;
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
                obj = deserializable((byte[]) array);
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
