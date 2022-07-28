package cn.gzsxy.annotation;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URL;
import java.util.Arrays;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface Component{
    String value() default "";
    boolean lazy();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ComponentScan{
    String value() default "";
}

@ComponentScan("cn.gzsxy.annotation")
class ServiceConfig{

}

@Component(value = "searchService",lazy = true)
class DefaultSearchService{

}

public class TestAnnotation02 {

    public static void main(String[] args) {
//        doMethod01();
        doMethod02();
    }

    private static void doMethod02() {
        //获取注解下的value路径
        Class<ServiceConfig> configClass = ServiceConfig.class;
        ComponentScan scan = configClass.getAnnotation(ComponentScan.class);
        String path_P = scan.value();
        String path = path_P.replace(".","/");

        //将路径转为URL
        URL uri = ClassLoader.getSystemResource(path);
        System.out.println(uri);

        //将URL的path添加到File流中获取文件
        File file = new File(uri.getPath());
        File[] files = file.listFiles();
        System.out.println(Arrays.toString(files));
        for (File f : files){
            System.out.println(f.getName());
        }
    }

    private static void doMethod01() {
        //获取字节码对象
        Class<DefaultSearchService> cls = DefaultSearchService.class;
        //获取类上注解
        Component com = cls.getAnnotation(Component.class);
        //获取注解的属性值
        String value = com.value();
        boolean lazy = com.lazy();
        System.out.println(value + " " + lazy);
    }
}
