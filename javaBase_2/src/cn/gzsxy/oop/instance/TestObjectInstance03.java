package cn.gzsxy.oop.instance;

/*
    面试：谈谈你对单例模式的认识？
     对象的单例设计：设计类时保证类的实列对象再内存中只有一份
    1）内部设计实例：对象类自身进行设计
    2）外部设计实例：对类的对象提供一种池
 */
//https://blog.csdn.net/qq_38606783/article/details/83269640?ops_request_misc=&request_id=&biz_id=102&utm_term=java%E4%B8%AD%E5%BB%B6%E8%BF%9F%E5%8A%A0%E8%BD%BD&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-0-83269640.142^v32^new_blog_pos_by_title,185^v2^control&spm=1018.2226.3001.4187
public class TestObjectInstance03 {
    public static void main(String[] args) {
//        doTestSingleThread01();//单线程
        doTestManyThread02();
    }

    //单线程
    public static void doTestSingleThread01() {
        Sinleton01 instance01 = Sinleton01.getInstance();
        Sinleton01 instance02 = Sinleton01.getInstance();
        System.out.println(instance01 == instance02);
    }
    //多线程
    public static void doTestManyThread02(){
        class Task implements Runnable{
            @Override
            public void run() {
//                Sinleton02.getInstance1();//效率低，安全
//                Sinleton02.getInstance2();//效率高，安全
//                Sinleton03.getInstance();//无延迟加载，频繁访问
                Sinleton03.show();//内存溢出
//                Sinleton04.getInstance();//延迟加载，频繁访问
                Sinleton04.show();//内存不溢出
            }
        };
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        Thread t3 = new Thread(new Task());
        t1.start();
        t2.start();
        t3.start();
    }

}
//如何保证以下类在内存中只有一份类的实例
/*
此类存在线程不安全
思考出现线程不安全的原因：
    1、多个线程执行
    2、多个线程共享的数据
    3、多个线程在共享数据上的操作是非原子操作
 *///单例模式方法1：适合单线程
class Sinleton01{
    private static Sinleton01 instance;
    private Sinleton01(){
        System.out.println("Sinleton01");
    }
    public static Sinleton01 getInstance(){
        if(instance == null){
            instance = new Sinleton01();
        }
        return instance;
    }
}

//单例设计方案2：适合大对象，并发大
class Sinleton02{
    private static volatile Sinleton02 instance;
    private Sinleton02(){
        System.out.println("Sinleton02");
    }

    //第一种，效率低一点
    public synchronized static Sinleton02 getInstance1(){
        if(instance == null){
            instance = new Sinleton02();
        }
        return instance;
    }

    //第二种，效率高一点
    public static Sinleton02 getInstance2() {
        if (instance == null) {
            synchronized (Sinleton02.class) {
                if (instance == null) {
                    instance = new Sinleton02();
                }
            }
        }
        return instance;
    }
}

//单例设计方案3：饿汉式，小对象，频繁访问，没有延迟加载
class Sinleton03{
    /*
    线程安全不阻塞
    积极类加载
    适合：小对象，频繁访问
     */
    int[] arr = new int[1024*1024*5];//大对象，加载
    private Sinleton03(){
        System.out.println("Sinleton03");
    }
    private static Sinleton03 instance = new Sinleton03();

    public static Sinleton03 getInstance(){
        return instance;
    }
    public static void show(){}
}

//单例设计方案4：懒汉式，延迟加载，大对象，频繁访问
class Sinleton04{
    /*
    线程不阻塞安全
    懒汉模式：内部类，延迟加载
    适合：大对象，频繁访问
     */
    int[] arr = new int[1024*1024*5];//大对象，不加载
    static class Inner{
        private static Sinleton04 instance = new Sinleton04();
    }
    private Sinleton04(){
        System.out.println("Sinleton04");
    }
    public static Sinleton04 getInstance(){
        return Inner.instance;
    }
    public static void show(){}
}