package cn.gzsxy.reflect;

import java.util.Date;

class Problem{
    private Long id;
    private String title;
    private Date createTime;

    private Problem(){
    }

    private Problem(Long id,String title){
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

public class TestReflect01 {
    public static void main(String[] args) throws Exception {
        Class<Problem> cls = Problem.class;
        Problem problem = ObjectFactory.newInstance(cls, new Class[]{Long.class,String.class}, new Object[]{1L,"222"});
        System.out.println(problem);
    }
}

