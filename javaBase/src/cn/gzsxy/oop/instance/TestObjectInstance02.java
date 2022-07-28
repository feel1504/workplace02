package cn.gzsxy.oop.instance;

import java.lang.ref.SoftReference;

public class TestObjectInstance02 {
    public static void main(String[] args) {
        //1、强引用（不会被GC回收）
/*        Member m = new Member(10,"A");
        //m = null;
        System.gc();*/

        //2、弱引用对象（WeakReference）
/*        //1）造弱引用对象(只要触发GC就回收)
        WeakReference<Member> wr = new WeakReference<>(new Member(100,"A"));
        //2）使用弱引用对象
        System.out.println(wr.get());
        //3)弱引用引用的对象只要触发GC，引用的对象就会被回收，回收弱引用
        System.gc();*/

        //3、软引用对象（softReference）
        //1)造软引用对象（内存不足时，软引用对象会被回收）
        SoftReference<Member> sr = new SoftReference<Member>(new Member(10,"A"));
        System.out.println(sr.get());
        //当内存不足时，软引用对象会被自动回收
//        System.gc();
        byte[] a1 = new byte[1024*1024*5];//我们设置了jvm的大小为5M，测试软引用

        //4、虚引用（记录被回收的对象）PlantonReference 了解


    }
}

class Member{
    int id;
    String name;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("回收了");
    }
}