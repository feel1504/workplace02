package cn.gzsxy.stack;

/*
测试方法栈：方法调用时执行入栈操作，方法执行结束后会自动出栈操作
 */

public class TestStackDemo01 {
    public static void main(String[] args) {
        doMethod01();
    }

    private static void doMethod01() {
        doMethod02();
    }

    private static void doMethod02() {
        Thread t = Thread.currentThread();
        StackTraceElement[] stack = t.getStackTrace();//获取调用类的方法名
        for(StackTraceElement s : stack){
            System.out.println(s.getMethodName());
        }
    }
}
