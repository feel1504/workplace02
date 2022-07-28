package cn.gzsxy.seriablizale;

/*
序列化
 */

import java.io.*;

public class TestSeralizable01 {
    public static void main(String[] args) throws Exception {
        Log log = new Log();
        log.setId(2);
        log.setName("张三");

        //序列化到f1.dat
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f1.dat"));
        oos.writeObject(log);

        //反序列化到console
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f1.dat"));
        Log log1 = (Log) ois.readObject();
        System.out.println(log1);
        System.out.println(log1 == log);//false 不是同一个对象

        //关闭连接
        oos.close();
        ois.close();

    }
}


class Log implements Serializable {

//    private static final long serialVersionUID = 7175593422143203921L;
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
