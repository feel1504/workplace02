package cn.gzsxy.enums;

//枚举中的单例模式，饿汉式，类加载就造对象
enum Singleton{
    INSTANCE("单例模式");
    private String model;
    Singleton(String model){//构造方法必须是私有的
        this.model = model;
    }
    public static Singleton getInstance(){
        return INSTANCE;
    }
}

enum Gender{
    M,FM,No;//三个实例，类加载时就创建
}

class Good{
    Long id;
    String name;
    Gender sex = Gender.FM;//定义为枚举类型默认值
    public void setGender(Gender gender){
        this.sex = gender;
    }
}
/*
类被加载的时机：

1、用Class.forName()显示加载的时候;

2、实例化一个类的时候;

3、调用类的静态方法的时候;

4、调用类的静态变量的时候;
 */
public class TestEnums01 {
    public static void main(String[] args) {
        Gender g = Gender.FM;

        //字符串转枚举（字符串和枚举里面的某个实例一样）
        String gStr = "M";
        Gender m = Gender.valueOf(gStr);
        System.out.println(m);
    }
}
