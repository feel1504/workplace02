package cn.gzsxy.args;

public class TestArgs01 {
    public static void main(String[] args) {
        doMethod(2);
        doMethod(1,2);
        doMethod(1,2,2,2);
        doMethod("as",12,1);
    }
    static void doMethod(int a){
        System.out.println(a);
    }
    static void doMethod(int a, int b){
        System.out.println(a + b);
    }
    static void doMethod(int ... args){
        System.out.println(args);
    }
    static void doMethod(String a,int ... args){
        System.out.println(a + args);
    }
}

