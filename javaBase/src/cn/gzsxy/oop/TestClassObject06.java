package cn.gzsxy.oop;

/*
演示当调用方法时，数组成员不加载
 */

public class TestClassObject06 {
    public static void main(String[] args) {
        /*
        访问ClassD的doSayHello放，Inner内部类没有被加载，只加载了外部类ClassD
        Inner类里面的数组没有被初始化，这个过程就叫延迟加载
         */
        ClassB.doSayHello();
        ClassB.add(12);
    }
}

class ClassB{
    //将数组加入内部类中
    static class Inner{
        //延迟加载
        static int[] array = new int[1024];
    }
//    static int[] array = new int[1024];
    static int size;//记录有效元素个数（添加到数组中的元素个数）
    public static void doSayHello(){
        System.out.println("doSayHello");
    }
    public static void add(int number){
        if(size == Inner.array.length){
            System.out.println("数组已满");
            return;
        }
        Inner.array[size] = number;
        size++;
    }
}