package cn.gzsxy.seriablizale;

/*
hession框架应用
 */

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TestSerializable04 {
    public static void main(String[] args) throws Exception {
        Article ar = new Article();
        ar.setId(1);
        ar.setTitle("海贼王");
        ar.setContent("贼好看");
        seriablize(ar);
        Article obj = (Article)doseriablize();
        System.out.println(obj);

    }
    /*序列化*/
    private static void seriablize(Object obj) throws Exception{
        OutputStream outputStream = new FileOutputStream("test.xml");
        Hessian2Output ho = new Hessian2Output(outputStream);
        ho.writeObject(obj);
        ho.flush();
        ho.close();
    }

    /*反序列化*/
    private static Object doseriablize() throws Exception {
        FileInputStream inputStream = new FileInputStream("test.xml");
        Hessian2Input hi = new Hessian2Input(inputStream);
        Object obj = hi.readObject();
        hi.close();
        inputStream.close();
        return obj;
    }
}
