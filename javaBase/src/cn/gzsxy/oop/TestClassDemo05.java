package cn.gzsxy.oop;
/*
演示何时触发类加载
1、显性加载，会直接使用类的加载器进行加载
2、隐形加载：
    1）构造类的对象（实例对象）
    2）访问类的成员（分情况）
 */
public class TestClassDemo05 {
    public static void main(String[] args) {
        ClassC c1;
        //隐形加载1）实例对象
//        new ClassC();
        //隐形加载2）访问类成员
        System.out.println(ClassC.d);
    }
}
class ClassC{
    static int a = 100;//会加载
    /*
    编译时的优化，在jvm中定义的一种规范:
        使用static final 8种基本数据类型+字符串,
        当他们被访问时不会触发类加载，而其他类型都没有这种优化，都被触发类加载
     */
    final static int B = 200;//不会触发类加载，放在常量池中 编译优化
    final static Integer C = 300;//会触发类加载
    final static String d = "我是一个";//不会触发类加载 编译优化

    static{
        System.out.println("我是静态代码块");
    }
    public static void show(){}
    public static final void display(){}
    /*
    总结：
    隐式加载的第一种：创建类对象，new对象
    隐式加载第二种：访问final static 修饰的成员变量,基本数据类型8种+字符串

     */
}
