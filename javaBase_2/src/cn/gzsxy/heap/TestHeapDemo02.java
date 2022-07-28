package cn.gzsxy.heap;

/*
演示GC自动操作
JVM法分析
Xmx：最大值
Xms：最小值
参数应用：在configuraction中配置参数
    -Xmx5M -Xms5M -XX:+PrintGCDatils
读懂gc日志
jvm调优
 */

public class TestHeapDemo02 {
    public static void main(String[] args) {
        byte[] array1 = new byte[1024*1024*5];

    }
}
