package cn.gzsxy.oop.abs;

import java.io.Serializable;

public class TestGeneric01 {
    public static void main(String[] args) {
        /*List<String> list1 = new ArrayList<String>();

        //定义泛型上下界
        List<? extends Object> list2 = new ArrayList<String>();
        List<? super String> list3 = new ArrayList<Object>();

        List<?> list4 = new ArrayList<String>();*/
        ArrayContainer<String> c1 = new ArrayContainer<>();
        c1.add("100");
        Container<Serializable> c2 = new LinkedContainer();
        c2.add(222);
        Serializable o = c2.get(0);
        System.out.println(o);
    }
}

interface Container<T>{//泛型接口，用于限定参数类型和返回值类型
    void add(T t);
    T get(int i);
    int size();
}

//定义泛型类，假如泛型类实现的接口是一个泛型接口
//那么此类，要么传入一个具体类型，要么将此类定义为和接口定义一样的泛型
//泛型类还可以比接口中的泛型更多，但是前提是类中必须有一个泛型和接口中的一样
//class ArrayContainer<T,E> implements Container<String>{//普通类接口，用于限定参数类型和返回值类型
    class ArrayContainer<T> implements Container<String>{
    public void add(String t){};

    public String get(int index){
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

class LinkedContainer implements Container<Serializable>{

    @Override
    public void add(Serializable serializable) {

    }

    @Override
    public Serializable get(int i) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}