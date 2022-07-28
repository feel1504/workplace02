package cn.gzsxy.stack;

/**
 * 测试方法栈：方法调用时会执行入栈操作，方法执行结束会自动出栈操作
 */
public class TestStackDemo01 {
    public static void main(String[] args) {
        doMethod01();
    }
    public static void doMethod01(){
        doMethod02();
    }
    public static void doMethod02(){
        Thread t = Thread.currentThread();
        StackTraceElement[] stackTrace = t.getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            System.out.println(stackTrace[i].getMethodName());
        }
    }
}
