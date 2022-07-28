package cn.gzsxy.oop.features.compose;

/*
组合新特性
 */
public class TestCompose01 {
    public static void main(String[] args) {//装饰模式
        Object search = new TimeSearchService(new DefaultSercherService()).search("8848");
        System.out.println(search);
    }
}


final class DefaultSercherService{
    public Object search(String key){
//        long start = System.currentTimeMillis();
        System.out.println("search :" + key);
//        long end = System.currentTimeMillis();
//        System.out.println("search time:"+(end - start));
        return "search data form database";
    }
}

class TimeSearchService{
    //has a(有一个这样的属性)。ref
    DefaultSercherService sercherService;
    //通过构造方法为属性赋值（依赖注入）
    public TimeSearchService(DefaultSercherService sercherService) {
        this.sercherService = sercherService;
    }

    public Object search(String key){
        long start = System.currentTimeMillis();
        Object result = sercherService.search(key);
        long end = System.currentTimeMillis();
        System.out.println("search time:"+(end - start));
        return result;
    }
}