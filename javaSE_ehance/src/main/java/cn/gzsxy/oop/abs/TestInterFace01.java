package cn.gzsxy.oop.abs;

public class TestInterFace01 {
    public static void main(String[] args) {
        //在接口中的静态方法，直接使用接口名点访问抽象类中的静态方法
        IB.display();

        //在接口中default修饰的方法，通过实现类的对象调用
        B b = new B();
        b.show();
    }
}

interface IA{
    static final int CAP = 100;//静态变量
    public abstract void show();//抽象方法
}

//JDK8.0新增
interface IB{
    //JDK8.0提供默认方法，使用default修饰
    default void show(){
        System.out.println("default修饰方法");//默认方法
    }

    //可以使用静态方法
    static void display(){
        System.out.println("静态方法");//静态方法
    }
}

class B implements IB{

}