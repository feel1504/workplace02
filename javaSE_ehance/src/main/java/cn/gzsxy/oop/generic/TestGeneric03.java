package cn.gzsxy.oop.generic;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric03 {
    public static void main(String[] args) {
//        ObjectFactory factory = new ObjectFactory();
     /*   Date date = (Date) ObjectFactory.newObject(Date.class);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(date));

        ArrayList list = (ArrayList) ObjectFactory.newObject(ArrayList.class);
        list.add(20.2);
        list.add("lll");
        list.add(true);
        System.out.println(list);*/

        List<String> list = new ArrayList<>();
        list.add("aaa");
        PrintUtil.doPrint(list);

        List<Number> li = new ArrayList<>();
        li.add(200.2222222222F);
        li.add(100.0);
        PrintUtil.doSort(li);

    }
}
class ObjectFactory{
    public <T>T getObject(Class<T> t){
        return null;
    }

    public static <T>Object newObject(Class<T> t){
        /*
        返回值类型Object前面的泛型<T>没有实际意义，仅仅代表是个泛型方法
         */
        try {
            return t.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class ContainerUtil<T>{
    //接口和普通类在定义泛型只能作用于普通方法，不能作用于static方法。
    //static方法使用泛型只能是方法泛型
    //泛型接口和泛型类不作用于静态方法
    //泛型方法一定是静态方法吗？No，实例方法也可以是泛型
    public static <T>void sort(List<T> list){

    }
    public static <T>T show(){
        return null;
    }
}

class PrintUtil{
    //限定通配符，限定泛型的上限
    //总结，泛型没有直接的继承关系，需要通过通配符指定 ? extends 父类
    public static void doPrint(List<? extends Object> list){
        System.out.println(list);
    }

    public static void doSort(List<? super Integer> list){
        System.out.println(list);
    }
}