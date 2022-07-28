package cn.gzsxy.enums;

enum Sex{
    MAIL("男"),FEMAIL("女"),NONE;
    private String name;
    Sex(){}
    Sex(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

class Member{
    Long id;
    Sex sex = Sex.MAIL;
}

public class TestEnums02 {
    public static void main(String[] args) {
        Member m = new Member();
        System.out.println(m.sex.getName());

        String sexStr = "MAIL";
        m.sex = Enum.valueOf(Sex.class,sexStr);
        //java中我们写的所有的枚举都默认继承了Enum
        System.out.println(m.sex instanceof Enum);

    }
}
