package cn.gzsxy.seriablizale;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

//演示序列化安全问题
public class TestSerailzable03 {
    //客户端
    static void client(Object obj) {
        try {
            Socket socket = new Socket("127.0.0.1",8859);
            //序列化
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(obj);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //服务端
    static void Server(){
        try {
            ServerSocket server = new ServerSocket(8859);
            System.out.println("server start yes");
            Socket socket = server.accept();
            System.out.println("connection ok");

            //反序列化
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            Object o = ois.readObject();
            System.out.println("序列化成功"+o);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUserName("张十三");
        user.setPassWord("123");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Server();
            }
        }).start();
        client(user);
    }

}
class User implements Serializable {

    private static final long serialVersionUID = 2526920589948171011L;
    private int id;
    private String userName;
    private String passWord;

    //加密序列化方法--固定写法
    private void writeObject(ObjectOutputStream out) throws IOException {
        //获取加密器
        Base64.Encoder encoder = Base64.getEncoder();
        //对内容进行加密
        byte[] user = encoder.encode(userName.getBytes());
        byte[] pwd = encoder.encode(passWord.getBytes());
        //给成员赋值为加密后的内容
        userName = new String(user);
        passWord = new String(pwd);
        //固定写法
        out.defaultWriteObject();
    }

//    //解密序列化方法--固定写法
    private void readObject(ObjectInputStream ois) throws Exception {
        //1、先默认反序列化，将字节读出，自动赋值给属性
        ois.defaultReadObject();
        //2获取解密对象
        Base64.Decoder decoder = Base64.getDecoder();
        //3解密对象
        byte[] u = decoder.decode(userName.getBytes());
        byte[] p = decoder.decode(passWord.getBytes());
        userName = new String(u);
        passWord = new String(p);

    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
