package cn.gzsxy.seriablizale;

/*
hessian 框架的应用
 */

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.*;
import java.util.Base64;
import java.util.Date;

public class TestSerializable04 {
    public static void main(String[] args) throws Exception {
        Article1 obj = new Article1(1,"Java","Java容易拖头");
        serizlize(obj);
        Article1 o = (Article1) doserizlize();
        System.out.println(o);

        System.out.println(o == obj);//false

    }
    /*序列化*/
    private static void serizlize(Object obj) throws Exception{
        OutputStream os = new FileOutputStream("test.xml");
        Hessian2Output ho = new Hessian2Output(os);
        ho.writeObject(obj);
        ho.flush();
        os.close();
    }

    /*反序列化*/
    private static Object doserizlize() throws Exception{
        InputStream is = new FileInputStream("test.xml");
        Hessian2Input hi = new Hessian2Input(is);
        Object o = hi.readObject();
        is.close();
        return o;
    }
}

class Article1 implements Serializable {
    private static final long serialVersionUID = -5430829382987557738L;
    private int id;
    private String title;
    private String content;
    private Date createDate;

    public Article1() {
    }

    public Article1(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Article1(int id, String title, String content,Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = date;
    }


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

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Article1{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}