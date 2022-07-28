package cn.gzsxy.test;

import com.tedu.pojo.Door;

public class ClassA {
    public Door door;
    public void sepDoor(){
        door = new Door();
    }
}

class main{
    public static void main(String[] args) {
        ClassA a = new ClassA();
        System.out.println(a.door);
    }
}