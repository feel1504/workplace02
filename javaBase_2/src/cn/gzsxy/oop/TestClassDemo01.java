package cn.gzsxy.oop;

/*
演示类加载方式会不会触发类加载
 */

public class TestClassDemo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //定义类变量不会触发类加载
        Class<?> c0;
        //1.类加载.class：不会执行静态代码块
//        Class<?> cls = ClassA.class;//static不会被加载
        //2.类加载forName():会执行静态代码块
//        Class.forName("cn.gzsxy.oop.ClassA");
        //3.类加载forName(有参数)
        /*
        当参数为True，static会加载，默认为true
        当参数false，static代码块不会被加载
         */
//        ClassLoader lader = ClassLoader.getSystemClassLoader();
//        Class.forName("cn.gzsxy.oop.ClassA",false,lader);
        //4.类加载类加载器加载：不会执行代码块
        ClassLoader lader = ClassLoader.getSystemClassLoader();
        lader.loadClass("cn.gzsxy.oop.ClassA");
    }
}

class ClassA{
    //静态代码块，在类加载时可以执行，但不一定会被执行
    static {
        System.out.println("static{}被加载了");
    }
}
