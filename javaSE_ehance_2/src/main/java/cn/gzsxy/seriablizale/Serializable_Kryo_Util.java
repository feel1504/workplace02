package cn.gzsxy.seriablizale;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Serializable_Kryo_Util{
    //构建一个线程内部单例的kryo对象
    private static ThreadLocal<Kryo> td = new ThreadLocal<Kryo>(){
        @Override
        protected Kryo initialValue() {
            return new Kryo();
        }
    };
    //序列化为字节数组
    public static byte[] serialzable(Class<?> cls,Object obj) throws IOException {
        Kryo kryo = td.get();
        kryo.register(cls,new JavaSerializer());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Output output = new Output(outputStream);

        kryo.writeObject(output,obj);

        output.close();
        outputStream.close();
        return outputStream.toByteArray();
    }
    //字节数组反序列化为对象
    public static <T>T doserialzable(Class<T> cls, byte[] array) throws IOException {
        Kryo kryo = td.get();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(array);
        Input input = new Input(inputStream);

        T t = kryo.readObject(input, cls);
        input.close();
        inputStream.close();
        return t;
    }
}
