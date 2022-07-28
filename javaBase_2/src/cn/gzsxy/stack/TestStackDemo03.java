package cn.gzsxy.stack;

/*
演示栈上分配、逃逸对象
 */

public class TestStackDemo03 {
    static Stack01 s2;

    public static void main(String[] args) {
        //小对象：占用内存资源小的对象，可能在内存分配中分配在栈帧中
        //好处在于线程消亡后，资源也会释放，在堆内存的话就会由GC来回收

        //栈上分配：小对象在方法执行结束，生命周期结束
        Stack01 s = new Stack01();

        //逃逸对象：方法外的引用指向方法内的对象
        //逃逸对象不会在栈上分配，会在堆内
        s2 = new Stack01();
    }
}

class Stack01{}
