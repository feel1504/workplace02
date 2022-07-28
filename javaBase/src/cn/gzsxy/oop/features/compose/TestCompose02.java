package cn.gzsxy.oop.features.compose;

public class TestCompose02 {
    public static void main(String[] args) {
        //use a System对象
        System.out.println();
    }
}

class Person{}

class Team{
    private Family f;
    private void a(){
        f=new Family();
    }
}

class Family{
    //has a (Family有一个male)
    private Male male;
    //has a (Family有一个female)
    private Female female;
}

class Male extends Person{}//is a Male是Person

class Female extends Person{}//is a female是Person
