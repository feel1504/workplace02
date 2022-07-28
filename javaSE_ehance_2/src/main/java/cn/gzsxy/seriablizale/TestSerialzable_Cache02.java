package cn.gzsxy.seriablizale;

import org.apache.ibatis.cache.impl.PerpetualCache;

public class TestSerialzable_Cache02 {
    public static void main(String[] args) {
        SeriazableCache seriazableCache = new SeriazableCache(new PerpetualCache(null));
        Problem problem = new Problem();
        problem.setId(1);
        problem.setTitle("傻逼");
        seriazableCache.putObject("p",problem);
        Object p = seriazableCache.getObject("p");
        System.out.println("序列化成功="+p);

        System.out.println(p == problem);//false

        Object p1 = seriazableCache.removeObject("p");
        System.out.println("删除成功="+p1);

        //以对象格式存在cache中
        PerpetualCache cache = new PerpetualCache(null);
        cache.putObject("1",problem);
        Problem pp = (Problem) cache.getObject("1");
        System.out.println(pp == problem);//true map中value存储地址值
    }
}
