package cn.gzsxy.oop;

public class TestClassDemo02 {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);//AppClassLoader 启动类 负责加载我们自己写的类

        ClassLoader loader1 = loader.getParent();
        System.out.println(loader1);//ExtClassLoader 扩展类 负责加载jdk/lib.ext/*.jar

        ClassLoader loader2 = loader1.getParent();
        System.out.println(loader2);//BoostrapClassLoader 应用类（自己写的类） 负责加载jdk/lib包下的rt.jar
    }

}
