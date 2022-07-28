package cn.gzsxy.oop.features.extend;

/*
继承下的组合
 */

public class TestExtends01 {
    public static void main(String[] args) {
        LogSearchService ser = new LogSearchService();
        Object search = ser.searchTime("8859");
        System.out.println(search);
    }
}

class DefaultSercherService{
    public Object search(String key){
        System.out.println("search:"+key);
        return key;
    }
}

class LogSearchService extends DefaultSercherService{
    public Object searchTime(String key){
        long l = System.currentTimeMillis();
        Object search = search(key);
        long e = System.currentTimeMillis();
        System.out.println("共花费时间："+(e - l));
        return key;
    }
}