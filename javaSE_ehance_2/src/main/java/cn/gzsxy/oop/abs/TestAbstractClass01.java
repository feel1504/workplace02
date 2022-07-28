package cn.gzsxy.oop.abs;

/*
接口里面可以定义的类型:
    常量
    抽象方法
    default修饰的默认方法：由实现类对象调用，有方法体
    静态方法：接口名调用，有方法体
 */
public class TestAbstractClass01 {
    public static void main(String[] args) {
        BBB.display();//接口静态方法
        new B().show();//接口default方法
    }
}

interface AAA{
    static final int A = 123;
    void B();//public abstract void B();
}

interface BBB{
    default void show(){
        System.out.println("default修饰方法");
    }
    static void display(){
        System.out.println("静态方法");
    }
}
class B implements BBB{

}