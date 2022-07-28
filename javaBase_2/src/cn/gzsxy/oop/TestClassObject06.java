package cn.gzsxy.oop;

import java.util.HashMap;

/**
 笔试题：分析以下代码是否有问题（类加载时属性初始化顺序问题）
 类加载顺序，从上到下，static修饰的属性，会从上到下顺序一次执行
 所以定义map要提前。否则在new ClassE的时候执行构造方法时map没定义，会报空异常NullPointerException
 */

public class TestClassObject06 {
    public static void main(String[] args) {
        new ClassE();
    }
}

class ClassE{//属性初始化，第一次赋值默认值，第二次将等号右边值赋值给变量
    static HashMap<String,Object> map = new HashMap<>();
    static ClassE instance = new ClassE();
//    static HashMap<String,Object> map = new HashMap<>();
    public ClassE() {
        map.put("A",12);
        map.put("B",20);
    }
}