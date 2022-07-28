package cn.gzsxy.seriablizale;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class Article implements Serializable {

    private static final long serialVersionUID = 7099196282815008477L;

    private int id;
    private String title;
    private String content;

    //加密方法的固定写法
    //此方法会在执行ObjectOutPutStream对象writeObject的时候执行
    private void writeObject(ObjectOutputStream out) throws IOException {
        //1、获取加密对象
        Base64.Encoder encoder = Base64.getEncoder();

        //2、对内容进行加密
        byte[] titleArray = encoder.encode(title.getBytes());
        byte[] contentArray = encoder.encode(content.getBytes());

        //3、对title和content重新赋值为加密后的内容
        title = new String(titleArray);
        content = new String(contentArray);

        //固定写法
        out.defaultWriteObject();
    }

    //此方法在执行ObjectIntputStream的readObject方法的时候自动执行
    //此方法可以在反序列化时候执行解密等操作
    private void readObject(ObjectInputStream ois) throws Exception{
        //1、先默认反序列化，将字节读出，自动赋值给属性
        ois.defaultReadObject();
        //2、获取解密对象
        Base64.Decoder decoder = Base64.getDecoder();
        //3、执行解密操作
        byte[] titleArray = decoder.decode(title.getBytes());
        byte[] contentArray = decoder.decode(content.getBytes());
        title = new String(titleArray);
        content = new String(contentArray);

    }

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
