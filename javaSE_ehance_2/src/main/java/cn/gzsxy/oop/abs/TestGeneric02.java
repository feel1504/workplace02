package cn.gzsxy.oop.abs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestGeneric02{
    public static void main(String[] args) {
//        List<Integer> syn = Collections.synchronizedList(new ArrayList_<Integer>());
        List<Integer> syn = new ArrayList<>();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    for (int j = 0; j < 20; j++) {

                    }
                    syn.add(i);
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    for (int j = 0; j < 20; j++) {

                    }
                    syn.add(i);
                }
            }
        };
        Thread t = new Thread(r1);
        t.start();
        Thread t1 = new Thread(r2);
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(syn);
    }
}

class ArrayList_<E> extends ArrayList<E>{
    private static final long serialVersionUID = 8497818339574942183L;

    @Override
    public synchronized boolean add(E e) {
        return super.add(e);
    }

    @Override
    public synchronized E get(int index) {
        return super.get(index);
    }
}

class synchronizedHashMap<K,V> extends HashMap<K,V>{
    private static final long serialVersionUID = -7305421722133817610L;

    @Override
    public synchronized V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    public synchronized V get(Object key) {
        return super.get(key);
    }
}
