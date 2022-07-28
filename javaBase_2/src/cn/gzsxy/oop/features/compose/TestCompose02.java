package cn.gzsxy.oop.features.compose;

public class TestCompose02 {

}
class Team{
    private Family family;
    public Team(Family family){
        this.family = family;
    }
}
class Family{//has a
    private Male m1;
    private Female m2;
}
class Male extends Person{
//is a
}
class Female extends Person{

}
class Person{

}
