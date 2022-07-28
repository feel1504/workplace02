package cn.gzsxy.oop;

public class TestClassObject02 {
    public static void main(String[] args) throws ClassNotFoundException {
        //定义类变量不会触发类加载
        Class<?> c0;
        //类加载方式一：不会执行静态代码块
//        Class<?> cls = ClassA.class;//static不会被加载
        //类加载方式二：会执行静态代码块
//        Class.forName("cn.gzsxy.oop.ClassA");//static会被加载
        //类加载方式三：false不会执行，true会执行
        /*
        当参数为true，static会被加载，默认是true
        当参数为false，static代码块不会被加载
         */
        Class.forName("cn.gzsxy.oop.ClassA",false,
                ClassLoader.getSystemClassLoader());
        //类加载方式四，不会执行静态代码块
//        ClassLoader lader = ClassLoader.getSystemClassLoader();
//        lader.loadClass("cn.gzsxy.oop.ClassA");

    }
}

class ClassA{
    //静态代码块，在类加载时可以执行，但不一定被执行
    static {
        System.out.println("static{}我被加载了");
    }
}

