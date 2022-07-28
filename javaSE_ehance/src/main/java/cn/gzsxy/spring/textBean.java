package cn.gzsxy.spring;

public class textBean {
    public static void main(String[] args) {
        Object door = DefaultBeanFactory.getBean("Door");
        System.out.println(door);
    }
}
