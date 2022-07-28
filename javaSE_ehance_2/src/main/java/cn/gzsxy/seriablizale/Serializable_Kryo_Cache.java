package cn.gzsxy.seriablizale;

import org.apache.ibatis.cache.Cache;

import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;

public class Serializable_Kryo_Cache implements Cache {

    private Cache cache;

    public Serializable_Kryo_Cache(Cache cache){
        this.cache = cache;
    }

    @Override
    public void putObject(Object key, Object value) {
        try {
            byte[] array = Serializable_Kryo_Util.serialzable(Article.class, value);
            cache.putObject(key,array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getObject(Object key) {
        try {
            Article a = Serializable_Kryo_Util.doserialzable(Article.class, (byte[]) cache.getObject(key));
            return a;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        return null;
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
