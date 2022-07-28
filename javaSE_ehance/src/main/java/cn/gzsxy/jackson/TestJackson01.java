package cn.gzsxy.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class TestJackson01 {
    public static void main(String[] args) throws Exception {
       //造对象
        A a = new A();
        a.setId(100);
        a.setTitle("领券系统");
        a.setContent("过滤敏感词汇");
        //将对象转为json格式的字符串
        //格式转换为：{"id":100,"title":"领券系统","content":"过滤敏感词汇"}
        ObjectMapper om = new ObjectMapper();
        String jsonStr = om.writeValueAsString(a);
        System.out.println(jsonStr);

        //将json转换为对象格式
        A a1 = om.readValue(jsonStr, A.class);
        System.out.println(a1);

        System.out.println(a1 == a);//false

        //fastjson：阿里开发的jsom转换，快
    }
}
class A implements Serializable {

    private static final long serialVersionUID = 2611137171199948062L;
    private int id;
    private String title;
    private String content;
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
