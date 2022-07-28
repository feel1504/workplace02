package cn.gzsxy.seriablizale;

import java.io.IOException;

/*
基于kryo框架实现对象序列化和反序列化，基于字节数组实现
 */
public class TestSerializable05 {
    public static void main(String[] args) throws IOException {
        Article a = new Article();
        a.setId(22);
        a.setTitle("蓝莲花");
        a.setContent("许巍");

        byte[] array = Serializable_Kryo_Util.serialzable(Article.class, a);
        Article ar = Serializable_Kryo_Util.doserialzable(Article.class, array);

        System.out.println(ar);
    }
}
