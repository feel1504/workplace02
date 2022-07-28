package cn.gzsxy.stack;

public class TestStackDemo03 {
    static Stack s2;
    public static void main(String[] args) {
        //小对象：占用内存资源比较少的对象
        //小对象有可能在内存分配资源时会存储到栈帧上
        //好处是在线程消亡后，资源也会释放，如果存放在堆则由GC回收
        //栈上分配：小对象在方法执行结束，生命周期结束
        Stack s = new Stack();

        //逃逸对象：方法外的引用指向方法内的对象
        //逃逸对象不会在栈上分配，会在堆内
        s2 = new Stack();

    }
}

class Stack{}
