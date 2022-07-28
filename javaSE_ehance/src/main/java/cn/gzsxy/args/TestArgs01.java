package cn.gzsxy.args;

public class TestArgs01 {
    public static void main(String[] args) {
        doMethod(10);
        doMethod(10,20);
        doMethod(10,20,30);
        deMethod(10,20,30,50);
    }
    static void doMethod(int a){
        System.out.println("doMethod(int a)");
    }
    static void doMethod(int a,int b){
        System.out.println("doMethod(int a,int b)");
    }
    static void doMethod(int a,int b,int c){
        System.out.println("doMethod(int a,int b,int c)");
    }

    /*
    可变参数从jdk1.5开始
    可变参数：特殊的数组
    场景：用于简化参数类型相同，但是个数不同的重载方法的定义
     */
    //固定参数写法比可变参数的优先级别更高，但是下面这种写法可以简化重载，这叫可变参数应用
    static void deMethod(int ... args){
        System.out.println("doMethod(int...args)="+args.length);
    }
    //如果方法除了可变参数还有其他参数，可变参数放在最后面
    static void doMethod(String str,int ... args){
        System.out.println("doMethod(int...args)="+args.length);
    }


}
