package cn.gzsxy.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @interface：用于定义注解
 * @Target：用于描述注解，告诉编译器，这些注解可以描述那些成员
 * @Retention：用于描述注解的有效范围
 */


//@Target(ElementType.METHOD)   //用于让Entity描述方法
//@Target(ElementType.TYPE)   //用于让Entity描述类
@Target({ElementType.METHOD,ElementType.TYPE})  //即可描述方法又能描述类,数组来装
@Retention(RetentionPolicy.RUNTIME)
@interface Entity{
    String value() default "";
}

@Retention(RetentionPolicy.RUNTIME)     //运行时有效
@interface Mapper{}

@Retention(RetentionPolicy.RUNTIME)
@interface ID{
    String value() default "";
}


@Entity("goods")
class Goods{
    @ID(value = "22")
    Long id;
}

@Mapper
interface GoodsMapper{

}

@Entity
class SysLog{

}

public class TestAnnotation01 {
    public static void main(String[] args) throws NoSuchFieldException {
//        doMethod01();
        doMethod02();

    }

    private static void doMethod02() throws NoSuchFieldException {
        //1、获取Goods的字节码对象
        Class<Goods> goods = Goods.class;
        //2、获取Goods上的@Entity注解
        Entity entity = goods.getAnnotation(Entity.class);
        System.out.println(entity);
        System.out.println(entity.value());
        //3、获取Goods类中的id属性
        Field field = goods.getDeclaredField("id");
        //4、获取id属性上的ID注解
        ID id = field.getAnnotation(ID.class);
        //5、获取ID注解的value属性值
        System.out.println(id.value());
    }

    private static void doMethod01() {
        //1、获取GoodsMapper接口的字节码对象
        Class<GoodsMapper> goods = GoodsMapper.class;
        //2、获取GoodsMapper上的@Mapper注解
        //反射是运行时有效，所有注解默认实现Annotation接口
        Annotation mapper = goods.getAnnotation(Mapper.class);
        System.out.println(mapper);
    }
}
