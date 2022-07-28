package cn.gzsxy.oop;

/*
演示调用方法时，数组类型成员变量不加载
延迟加载
https://blog.csdn.net/qq_38606783/article/details/83269640?ops_request_misc=&request_id=&biz_id=102&utm_term=java%E4%B8%AD%E5%BB%B6%E8%BF%9F%E5%8A%A0%E8%BD%BD&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-0-83269640.142^v32^new_blog_pos_by_title,185^v2^control&spm=1018.2226.3001.4187
 */

import java.util.Arrays;

public class TestClassObject05 {
    public static void main(String[] args) {
        ClassB.doSayHello();
        /*
        访问ClassB的doSayHello方法，inner内部类没有被加载，只加载了外部类ClassB
        Inner类里面的数组没有被初始化，这个过程就叫延迟加载
         */
        int[] arr = ClassB.add(2);
        System.out.println(Arrays.toString(arr));

    }
}
class ClassB{
    //内部类实现延迟加载，当访问方法时，内部类不会被加载
    static class Inner{
        static int[] array = new int[10];
    }
    private static int size;
    public static void doSayHello(){
        System.out.println("doSayHello");
    }

    public static int[] add(int number){
        if(size == Inner.array.length){
            return null;
        }
        Inner.array[size] = number;
        size++;
        return Inner.array;
    }

}
