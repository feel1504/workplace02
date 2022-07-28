package cn.gzsxy.oop.features.compose;

/*
新特性：组合
一个类是用于查询数据库
现在加一个类用于计算查询数据库所有时间。
 */

public class TestCompose01 {
    public static void main(String[] args) {
        TimeSearchService ser = new TimeSearchService(new DefaultSercherService());
        Object o = ser.timeSearch("2222");
        System.out.println(o);
    }
}

class DefaultSercherService{
    public Object Search(String key){
        System.out.println("查询到的数据为：" + key);
        return "search from database";
    }
}

class TimeSearchService{
    private DefaultSercherService search;
    public TimeSearchService(DefaultSercherService search){
        this.search = search;
    }
    public Object timeSearch(String key){
        long l = System.nanoTime();
        Object o = this.search.Search(key);
        long e = System.nanoTime();
        System.out.println("查询用时" + (e - l));
        return o;
    }
}
