package cn.gzsxy.stack;
/*
测试栈入栈出
 */
public class TestStackDemo02 {
    int o = 2;//堆内存

    public static void main(String[] args) {
        doMethod01();
    }

    private static void doMethod01() {
        doMethod02();
    }

    private static void doMethod02() {
        int c = 5;//栈
        throw new RuntimeException();//非检测性异常不抛
    }
}
