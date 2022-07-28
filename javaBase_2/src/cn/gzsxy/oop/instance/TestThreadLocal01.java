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
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThreadLocal01 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                Date d1 = DateUtil.format("2000-12-12");
                System.out.println(d1);
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                Date d1 = DateUtil.format("2020-01-01");
                System.out.println(d1);
            }
        }.start();
    }
}

class DateUtil{
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-MM-dd");
    public static Date format(String dateStr){
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
