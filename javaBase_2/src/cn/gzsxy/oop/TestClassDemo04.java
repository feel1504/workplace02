package cn.gzsxy.oop;

/*
演示如何触发类加载
1、显性加载：使用类的加载器进行加载
2、隐性加载：
    1）构造类对象（实例对象）
    2）访问类成员（分情况）
 */

public class TestClassDemo04 {
    public static void main(String[] args) {
        ClassC c1;

        //隐性加载1）实例对象
//        new ClassC();会加载static
        //隐性加载2）访问类成员
//        System.out.println(ClassC.a);//加载
//        System.out.println(ClassC.B);//不加载--基本数据类型
//        System.out.println(ClassC.C);//加载
//        System.out.println(ClassC.D);//加载
//        System.out.println(ClassC.E);//不加载--字符串
        ClassC.show();//加载


    }
}
class ClassC{
    static int a = 100;//会加载
    static final int B = 200;
    static final Integer C = 100;
    static final Integer D = 200;
    static final String E = "aaa";
    static{
        System.out.println("加载了");
    }
    public static final void show(){};
    /*
    总结：
    只有隐式加载中访问final static 修饰的基本数据类型的成员变量+字符串
     */
}
