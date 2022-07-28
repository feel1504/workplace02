package cn.gzsxy.oop.instance;

/*
强、弱、软引用
 */

import java.lang.ref.SoftReference;

public class TestObjectInstance02 {
    public static void main(String[] args) {
        //1、强引用（不会被GC回收）
/*        Member m1 = new Member(10,"A");
//        m1 = null;
        System.gc();*/

        //2、弱引用：weakReference（只要触发GC就回收）
/*            //1）造弱引用对象
        WeakReference<Member> wr = new WeakReference<>(new Member(20,"B"));
            //2）使用弱引用
        System.out.println(wr.get());
            //3）触发GC
        System.gc();*/

        //3、软引用：softReference（jvm内存不足时，软引用对象会被回收）
        SoftReference<Member> sf = new SoftReference<Member>(new Member(30,"C"));
        System.out.println(sf.get());
        byte[] b = new byte[1024*1024*5];


        //4、虚引用（记录被回收的对象）PlantonReference 了解

    }
}

class Member{
    int id;
    String name;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("回收了");
    }
}