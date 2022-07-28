package cn.gzsxy.oop.instance;

public class TestObjectInstance01 {
    public static void main(String[] args) {
        //o1为强引用，引用堆内存中的Object对象
        Object o1 = new Object();
        //1、如果没有类加载，先类加载，同时在方法区开辟空间，存储类的字节码信息
        //2、堆内存分配空间，初始化属性
        //3、执行构造方法，造实例对象
        //以上操作过程都是先父类再子类

        /*
        注意：
            1、对象能重用则重用（构造对象，销毁对象非常耗时），列如用对象池
            2、对象能用局部变量引用，就不用实例变量进行引用
            3、缓存或者池中对象能不用强引用就不要用强引用（强引用引用的对象不会被GC回收）
         */

    }
}
