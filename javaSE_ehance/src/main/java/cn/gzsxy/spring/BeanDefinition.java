package cn.gzsxy.spring;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanDefinition {
     private static Map<String,String> map1;
     static {
         try {
            map1 = new HashMap<>();
            SAXReader reader = new SAXReader();
            Document read = reader.read("./javaSE_ehance/src/main/resources/spring-configs.xml");
            Element rootElement = read.getRootElement();
            List<Element> bean = rootElement.elements("bean");
            for (Element e : bean){
                String id = e.attribute("id").getText();
                String className = e.attribute("class").getText();
                map1.put(id,className);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getClassName(String key){
         return map1.get(key);
    }
}
