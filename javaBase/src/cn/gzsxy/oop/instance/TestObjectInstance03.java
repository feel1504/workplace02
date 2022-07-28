package cn.gzsxy.oop.instance;

/*
    面试：谈谈你对单例模式的认识？
    对象的单例设计：设计类时保证类的实列对象再内存中只有一份
    1）内部设计实例：对象类自身进行设计
    2）外部设计实例：对类的对象提供一种池
 */
public class TestObjectInstance03 {
    public static void main(String[] args) {
//        doTestSingleThread01();   //单线程
        doTestManyThread02();   //多线程
    }

    public static void doTestManyThread02(){
        class Task implements Runnable{
            @Override
            public void run() {
                Sinleton03.getInstance();
            }
        }
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        Thread t3 = new Thread(new Task());
        t1.start();
        t2.start();
        t3.start();
    }

    private static void doTestSingleThread01() {
        Sinleton01 instance01 = Sinleton01.getInstance();
        Sinleton01 instance02 = Sinleton01.getInstance();
        System.out.println(instance02 == instance01);
    }
}
//如何保证以下类在内存中只有一份类的实例---（单线程）
/*
此类存在线程不安全
思考出现线程不安全的原因：
    1、多个线程执行
    2、多个线程共享的数据
    3、多个线程在共享数据上的操作是非原子操作
 */
//单例设计方案一：适合单线程
class Sinleton01{
    //设置为静态，保证一份
    private static Sinleton01 instance;
    //构造方法私有化，不允许外界直接构建对象
    private Sinleton01() {
        System.out.println("Singleton01---");
    }
    public static Sinleton01 getInstance(){
        if(instance == null){
            instance = new Sinleton01();
        }
        return instance;
    }
}

//单例设计方案二：适合大对象、并发大
class Sinleton02{//（多线程）
    //设置为静态，保证一份
    /*
    volatile 关键字作用：一般修饰类中属性
        1）保证线程可见性
        2）禁止指令重排序
        3）但不能保证其原子性
     */
    //记住：当多个线程对一个共享变量进行操作时，请使用volatile
    private static volatile Sinleton02 instance;
    //构造方法私有化，不允许外界直接构建对象
    private Sinleton02() {
        System.out.println("Singleton02---");
    }
    //synchronized保证代码的原子性，不能同时有多个线程对这个代码进行访问
    //synchronized要让多个线程在这个代码块上顺序执行
    //此设计虽然保证了安全，但性能会被降低

//    public synchronized static Sinleton02 getInstance(){
//        if(instance == null){
//            instance = new Sinleton02();
//        }
//        return instance;
//    }

    //重构上面方法设计，即保证安全，又考虑性能
    public static Sinleton02 getInstance(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(instance == null){
            synchronized (Sinleton02.class) {
                System.out.println("synchronized----");
                if (instance == null) {
                    instance = new Sinleton02();
                }
            }
        }
        return instance;
    }
}

//单例设计方案三：小对象，频繁访问
class Sinleton03{
/*
    线程安全且不阻塞
    饿汉模式：积极类加载
    适合：小对象，频繁访问
 */
    //此单例缺陷：可能会对资源占用比较多，尤其是大对象
    int[] array = new int[2048];
    private Sinleton03(){
        System.out.println("Sinleton03--");
    }
    //类加载时对象创建只创建一次
    private static Sinleton03 instance = new Sinleton03();
    public static Sinleton03 getInstance(){
        return instance;
    }
}

//单例设计方案四：大对象、频繁访问
class Sinleton04{
/*
    线程安全且不阻塞
    懒汉模式：内部类里面，延迟加载
    适合：大对象、频繁访问
 */
   int[] array = new int[2048];
   private Sinleton04(){
       System.out.println("Sinleton04--");
   }
   static class Inner{
       private static Sinleton04 instance = new Sinleton04();
   }
   public static Sinleton04 getInstance(){
       return Inner.instance;
   }
}