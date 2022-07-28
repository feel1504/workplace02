package cn.gzsxy.oop;

import java.util.HashMap;
import java.util.Map;

public class TestClassObject07 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("cn.gzsxy.oop.ClassE");
    }
}
/**
    笔试题：分析以下代码是否有问题（类加载时属性初始化顺序问题）
    类加载顺序，从上到下，static修饰的属性，会从上到下顺序一次执行
    所以定义map要提前。否则在new ClassE的时候执行构造方法时map没定义，会报空异常
 */
class ClassE{//属性初始化有两次，第一次默认值，第二次将等号右边的值赋给变量
    static Map<String,Object> map = new HashMap<>();
    static ClassE instace = new ClassE();
//    static Map<String,Object> map = new HashMap<>();//发生空异常
    //构造方法
    public ClassE(){
        map.put("A",100);
        map.put("B",200);
    }
}