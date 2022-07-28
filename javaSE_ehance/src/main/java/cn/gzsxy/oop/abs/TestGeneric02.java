package cn.gzsxy.oop.abs;

public class TestGeneric02 {
    public static void main(String[] args) {
        ConvertTask task = new ConvertTask();
        Integer i = task.execut("10000");
        System.out.println(i);
    }
}

//泛型接口定义
interface Task<Param,Result>{
    Result execut(Param param);
}

class ConvertTask implements Task<String,Integer>{
    @Override
    public Integer execut(String param) {
        return Integer.parseInt(param);
    }
}