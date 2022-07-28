package cn.gzsxy.oop.instance;

/*
ThreadLocal是java提供的一个对象类型
通过此类型的对象可以将某个对象绑定到当前线程
也可以从当前线程获取该对象

线程内部单例：某个类的实例在一个线程只有一份

方法：
    1）get()方法可以从当前线程获取绑定的对象
    2）set(obj)方法将对象绑定到当前线程
说明：可以借助ThreadLocal实现线程内部单例
    1）保证线程安全
    2）保证性能
    3）空间换时间
使用场景：
    1、每个线程需要有自己单独的实例
    2、实例需要在多个方法中共享，但不希望被多线程共享
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThreadLocal01 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                Date d1 = DateUtil.format("2022/07/10");
                Date d2 = DateUtil.format("2022/02/10");
                System.out.println("date1="+d1);
                System.out.println("date2="+d2);
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                Date d1 = DateUtil.format("2022/07/10");
                Date d2 = DateUtil.format("2022/02/10");
                System.out.println("date1="+d1);
                System.out.println("date2="+d2);
            }
        }.start();
    }
}
class DateUtil{
    private static final ThreadLocal<SimpleDateFormat> td = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            System.out.println("ThreadLocal");
            return new SimpleDateFormat("yyyy/MM/dd");
        }
    };
    //SimpleDateFormat是线程不安全的
    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    public static Date format(String dateStr){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            //td.get()从当前线程获取SimpleDateFormat对象
            //如果当前线程没有SimpleDateFormat对象，则调用initiaValue()方法创建
            //SimpleDateFormat对象被创建以后，会绑定到当前线程
            return td.get().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
