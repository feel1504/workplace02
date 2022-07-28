package cn.gzsxy.reflect;

import java.lang.reflect.Constructor;
import java.util.Date;

//问题系统中的问题对象类型
class Problem{
    private Long id;
    private String title;
    private Date createTime;

    private Problem(){
    }

    private Problem(Long id,String title){
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

public class TestReflect01 {
    public static void main(String[] args) throws Exception {
        //1、获取字节码
//        Class<Problem> cls = Problem.class;
        Class<?> cls = Class.forName("cn.gzsxy.reflect.Problem");
        //2、通过字节码对象创建实例对象
            //2.1方法一：需要无参且public修饰的构造方法
//        doCreate01(cls);
            //2.2方法二：基于构造方法构建实例对象，无参构造
        doCreate02(cls);
            //2.3方法三：基于有参、私有构造方法造实例对象
//        doCreate03(cls,Long.class,String.class,10L,"大聪明");
        //工厂建对象
        Class<Problem> cls1 = Problem.class;
        Problem o = ObjectFactory.newInstance(cls1, new Class[]{Long.class, String.class}, new Object[]{10L, "JAVA"});
        System.out.println(o);

        Problem o1 = ObjectFactory.newInstance(cls1);
        System.out.println(o1);
    }

    private static void doCreate03(Class<?> cls, Class<Long> longClass, Class<String> stringClass,Long a,String b) throws Exception {
        //1、获取构造方法
        Constructor<?> constructor = cls.getDeclaredConstructor(longClass, stringClass);
        //2、设置权限true
        constructor.setAccessible(true);
        //3、创建实例
        Object obj = constructor.newInstance(a, b);
        System.out.println(obj);
    }

    private static void doCreate02(Class<?> cls) throws Exception{
        //获取构造方法对象
        Constructor<?> construtor = cls.getDeclaredConstructor();
        //设置构造方法访问权限为true
        construtor.setAccessible(true);
        //实例化对象
        Object obj = construtor.newInstance();
        System.out.println(obj);
    }

    private static void doCreate01(Class<?> cls) throws InstantiationException, IllegalAccessException {
        //创建实例
        Problem problem = (Problem) cls.newInstance();
        System.out.println(problem);
    }
}
