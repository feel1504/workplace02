package cn.gzsxy.stack;

/**
 * 测试方法栈：方法调用时会执行入栈操作，方法执行结束会自动出栈操作
 */
public class TestStackDemo02 {
    int o=2;//堆
    public static void main(String[] args) {
        doMethod01();
    }
    public static void doMethod01(){
        doMethod02(2);
    }
    public static void doMethod02(int b) {//栈
        int c=5;//栈
        throw new RuntimeException();//非检测性异常不用抛
    }
}
