package cn.gzsxy.seriablizale;

import org.apache.ibatis.cache.impl.PerpetualCache;

/*
基于kryo框架实现对象序列化和反序列化
存入PerpetualCache中，使用之前学习的序列化到缓存里面
*/
public class TestSerializable06 {
    public static void main(String[] args) {
        //建对象
        Article a = new Article();
        a.setId(12);
        a.setTitle("起风了");
        a.setContent("linp");

        Serializable_Kryo_Cache skc = new Serializable_Kryo_Cache(new PerpetualCache(null));
        //序列化到cache
        skc.putObject("a",a);
        //cache反序列化到对象
        Object a1 = skc.getObject("a");

        System.out.println(a1);
        System.out.println(a == a1);//false


    }
}
