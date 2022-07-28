package cn.gzsxy.oop;


import java.text.DateFormat;
import java.util.Date;

public class TestObjectDemo04 {
    public static void main(String[] args) throws Exception {
        Date o = (Date)ObjectFactory.newInstance(Date.class);
        System.out.println(DateFormat.getInstance().format(o.getTime()));

        class AAA{}
        Object o1 = ObjectFactory.newInstance(AAA.class);
        System.out.println(o1);


    }
}
//3.编写对象工厂，通过工厂基于类的字节码对象创建类的实列对象
class ObjectFactory{
    public static Object newInstance(Class<?> cls) throws Exception {
        return cls.newInstance();
    }
}
