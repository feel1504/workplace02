package cn.gzsxy.oop;

public class TestObjectDemo03 {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);//AppClassLoader 负责加载我们自己写的类

        ClassLoader loader01 = loader.getParent();
        System.out.println(loader01);//ExtClassLoader 负责加载jdk/lib.ext/*.jar

        ClassLoader loader02 = loader01.getParent();
        System.out.println(loader02);//BoostrapClassLoader 负责加载jdk/lib下/rt.jar
    }
}
