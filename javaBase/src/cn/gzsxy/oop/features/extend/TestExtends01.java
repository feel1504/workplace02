package cn.gzsxy.oop.features.extend;
/*
继承
 */
public class TestExtends01 {
    public static void main(String[] args) {
        new LogSearchService().searchTime("abcdefg");
    }
}

/*搜索服务
* OCP原则：在不修改源代码的情况下。实现对功能的扩展，也就是开闭原则，对扩展开放，对修改关闭
* */
class DefaultSercherService{
    public Object search(String key){
//        long start = System.currentTimeMillis();
        System.out.println("search :" + key);
//        long end = System.currentTimeMillis();
//        System.out.println("search time:"+(end - start));
        return "search data form database";
    }
}
//需求：基于OCP原则，计算搜索时长
class LogSearchService extends DefaultSercherService{
    public Object searchTime(String key){
        long start = System.currentTimeMillis();
        Object search = super.search(key);
        long end = System.currentTimeMillis();
        System.out.println("search time:"+(end - start));
        return search;
    }
}