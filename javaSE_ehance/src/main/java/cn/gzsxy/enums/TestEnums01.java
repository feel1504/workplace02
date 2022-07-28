package cn.gzsxy.enums;

//第六种：ThreadLocal，线程内部单例算一种单例模式
//枚举中的单例模式，饿汉式，类加载就会造INSTANCE对象，第七种单例模式
enum Singleton{
    INSTANCE;
    public static Singleton getInstance(){
        return INSTANCE;
    }
}

/*性别要求*/
enum Gender{//会生成class文件
    MALE,FEMALE,NONE;//三个实例，类加载时就创建
    Gender(){
        System.out.println("Gender()");
    }

}
class Good{
    Long id;
    String name;
    Gender gender=Gender.NONE;//定义为枚举类型的默认值

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

public class TestEnums01 {
    //-XX:+TraceClassLoading  jvm类加载命令
    public static void main(String[] args) {
//        Class<Gender> c = Gender.class;
        Gender female = Gender.FEMALE;

        //字符串转枚举
        String genderStr = "MALE";//字符串要和枚举里面的某个实例一样
        //所有的枚举类型在编译时都会默认生成valueOf方法，知识编译时优化
        Gender male = Gender.valueOf(genderStr);
        System.out.println(male);

        Good good = new Good();
        good.setGender(male);
        System.out.println(good.gender);
    }
}
