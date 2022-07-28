package cn.gzsxy.seriablizale;

import java.util.Date;

/*基于kryo框架实现对象序列化和反序列化*/
public class TestSerializable05 {
    //测试
    public static void main(String[] args) throws Exception {
        Article1 ac = new Article1(2, "Python", "难",new Date());
        byte[] array = Serializable_Kryo_Util.serialize(Article1.class, ac);
        Article1 o = Serializable_Kryo_Util.doserialize(Article1.class,array);
        System.out.println(o);
    }
}
