package cn.gzsxy.seriablizale;

import org.apache.ibatis.cache.impl.PerpetualCache;

import java.util.Date;

/*基于kryo框架实现对象序列化和反序列化*/
public class TestSerializable06 {
    //测试
    public static void main(String[] args) throws Exception {
        Article1 ac = new Article1(2, "Python", "难",new Date());
        //对象序列化
        Kryo_SerialzableCache cache = new Kryo_SerialzableCache(new PerpetualCache(null));
        cache.putObject("a1",ac);
        //对象反序列化
        Object obj = cache.getObject("a1");
        System.out.println(obj);
    }
}
