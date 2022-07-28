package cn.gzsxy.heap;
/*
演示对象被回收
输出详细信息：-XX:+PrintGCDetails
 */
public class TestHeapDemo01 {
    static Container c1;

    public static void main(String[] args) {
        Container c  = new Container();
        c1 = c;//逃逸，不回收
//        c = null;
        System.gc();
    }
}

class Container{
    int[] array = new int[1024];
    /*
    finalize()：该类的对象被回收之前调用，用于释放资源
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
