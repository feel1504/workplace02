package cn.gzsxy.jackson;

//ObjectMapper：对象与json相互转换

import cn.gzsxy.seriablizale.Article;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class TestJackson01 {
    public static void main(String[] args) throws IOException {
        //造对象
        Article a = new Article();
        a.setId(100);
        a.setTitle("领券系统");
        a.setContent("过滤敏感词汇");

        //对象转换为json
        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(a);
        System.out.println(s);

        //json转换为对象
        Article ac = om.readValue(s, Article.class);
        System.out.println(ac);
    }
}
