package cn.gzsxy.spring;

import java.util.HashMap;
import java.util.Map;

public class DefaultBeanFactory {
    private static Map<String,Object> map;

    private static void getObject(String key){
        map = new HashMap<>();
        String className = BeanDefinition.getClassName(key);
        try {
            Class<?> aClass = Class.forName(className);
            Object o = aClass.newInstance();
            map.put(key,o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static Object getBean(String key){
        getObject(key);
        return map.get(key);
    }
}
