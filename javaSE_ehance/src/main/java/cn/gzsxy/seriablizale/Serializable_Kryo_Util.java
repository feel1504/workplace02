package cn.gzsxy.seriablizale;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Serializable_Kryo_Util {
    //构建kryo对象
//    static Kryo kryo = new Kryo();
    private static ThreadLocal<Kryo> td = new ThreadLocal<Kryo>(){
        @Override
        protected Kryo initialValue() {
            return new Kryo();
        }
    };
    //序列化
//    public static void serialize(Class<?> cls, Object obj) throws Exception{
    public static byte[] serialize(Class<?> cls, Object obj) throws Exception{
        Kryo kryo = td.get();
        kryo.register(cls, new JavaSerializer());//必须要有无参构造
//        Output output = new Output(new FileOutputStream("file.dat"));//存入文件
        ByteArrayOutputStream bos = new ByteArrayOutputStream();//存入内存一个byte
        Output output = new Output(bos);
        kryo.writeObject(output,obj);
        output.close();
        return bos.toByteArray();
    }
    //反序列化
//    public static <T>T doserialize(Class<T> cls) throws Exception{
    public static <T>T doserialize(Class<T> cls, byte[] array) throws Exception{
        Kryo kryo = td.get();
        kryo.register(cls, new JavaSerializer());//必须要有无参构造
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
//        Input input = new Input(new FileInputStream("file.dat"));//从文件输出反序列
        Input input = new Input(bis);
        T o = kryo.readObject(input, cls);
        input.close();
        return o;
    }
}
class kk{
    private static ThreadLocal<Kryo> td = new ThreadLocal<Kryo>(){
        @Override
        protected Kryo initialValue() {
            return new Kryo();
        }
    };
    public static <T>T doserialize1(Class<T> cls,byte[] array) throws Exception{
        Kryo kryo = td.get();
        kryo.register(cls, new JavaSerializer());//必须要有无参构造
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
//        Input input = new Input(new FileInputStream("file.dat"));//从文件输出反序列
        Input input = new Input(bis);
        T o = kryo.readObject(input, cls);
        input.close();
        return o;
    }
    public static byte[] serialize1(Class<?> cls, Object obj) throws Exception{
        Kryo kryo = td.get();
        kryo.register(cls, new JavaSerializer());//必须要有无参构造
//        Output output = new Output(new FileOutputStream("file.dat"));//存入文件
        ByteArrayOutputStream bos = new ByteArrayOutputStream();//存入内存一个byte
        Output output = new Output(bos);
        kryo.writeObject(output,obj);
        output.close();
        return bos.toByteArray();
    }
}