package cn.gzsxy.seriablizale;

import org.apache.ibatis.cache.Cache;

import java.io.*;
import java.util.concurrent.locks.ReadWriteLock;

public class SeriazableCache implements Cache {
    private Cache cache;

    //注入
    public SeriazableCache(Cache cache) {
        this.cache = cache;
    }

    //序列化
    @Override
    public void putObject(Object key, Object value) {
        if(value != null && value instanceof Serializable){
            byte[] array = serializable((Serializable) value);
            cache.putObject("p",array);
        }
    }
    //将value转为字节数组
    private byte[] serializable(Serializable value) {
      try{
          ByteArrayOutputStream bos = new ByteArrayOutputStream();
          ObjectOutputStream oos = new ObjectOutputStream(bos);
          oos.writeObject(value);
          oos.flush();
          byte[] array = bos.toByteArray();
          oos.close();
          return array;
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
    }

    //反序列化
    @Override
    public Object getObject(Object key) {
        Object object = cache.getObject(key);
        try {
            if(object != null){
                return doSerialzable((byte[]) object);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //将字节数组转化为对象
    private Object doSerialzable(byte[] array) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object o = ois.readObject();
        ois.close();
        return o;
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
