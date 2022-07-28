package cn.gzsxy.seriablizale;
/*
用于测试序列化到cache中
 */
import org.apache.ibatis.cache.impl.PerpetualCache;

public class TestSerializable_Cache02 {
    public static void main(String[] args) {
        //1、构建Problem对象
        Problem p = new Problem();
        p.setId(1);
        p.setTitle("JVM 内存结构");
        //2、构建序列化cache对象
        SerialzableCache cache = new SerialzableCache(new PerpetualCache(null));
        //3、将对象存储到cache中--序列化
        cache.putObject("p1",p);
        //4、从cache获取某个对象
        Object p1 = cache.getObject("p1");
        System.out.println(p1);
        System.out.println(p1.equals(p));

        System.out.println("===========");

        //存储对象
        PerpetualCache pcache = new PerpetualCache(null);
        pcache.putObject("p2",p);
        Object p2 = pcache.getObject("p2");
        System.out.println(p == p2);//true
    }
}
