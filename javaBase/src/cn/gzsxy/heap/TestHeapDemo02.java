package cn.gzsxy.heap;

/*
演示GC自动操作
JVM参数分析
    1）-Xmx 最大值
    2）-Xms 最小值
参数应用：在configuraction中配置jvm参数
    -Xmx5M -Xms5M -XX:+PrintGCDetails 配置jvm的内存大小为5M，并打印输出jvm的一个轨迹

作业：学会读懂GC日志
jvm调优就是调节jvm内存大小
 */
public class TestHeapDemo02 {
    public static void main(String[] args) {
        byte[] array1 = new byte[1024*1024];
        byte[] array4 = new byte[1024*1024];
        byte[] array3 = new byte[1024*1024];
        byte[] array2 = new byte[1024*1024];
//        byte[] array5 = new byte[1024*1024];

    }
}
