package cn.gzsxy.heap;

/*
演示对象被回收
输出GC的详细信息，-XX:+PrintGCDetails
 */
public class TestHeapDemo01 {
    static Container c1;
    public static void main(String[] args) {
        Container c = new Container();
        c1=c;//逃逸了，不回收
        c=null;//若让他执行null,则gc一定会回收

        //启动垃圾回收器，gc不一定会马上来回收
        System.gc();
    }
}
class Container{
    int[] array = new int[1024];

    /*
        finalize():该类的对象被回收之前调用，用于释放资源
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize()");
    }
}