package cn.gzsxy.seriablizale;

import java.io.*;

//演示序列化
public class TestSerializable01 {

    public static void main(String[] args) throws Exception {
        //造一个SysLog对象，将该对象写入f1.dat文件，然后读f1.dat文件，反序列化
        SysLog log = new SysLog();
        log.setId(1).setUserName("张三");
        FileOutputStream fs = new FileOutputStream("f1.dat");
        //对象序列化
        try (ObjectOutputStream oos = new ObjectOutputStream(fs)) {
            oos.writeObject(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对象反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f1.dat"));
        SysLog log1 = (SysLog) ois.readObject();
        ois.close();
        System.out.println(log1);
        //反序列化后的对象和序列化之前的对象不是同一个
        System.out.println(log1 == log);//false
        System.out.println(log1.equals(log));//false
    }
}

class SysLog implements Serializable {

    private static final long serialVersionUID = -448589018902050660L;
    //日志id
    private int id;
    //操作用户名
    private String userName;

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public SysLog setId(int id) {
        this.id = id;
        return this;
    }

    public SysLog setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}