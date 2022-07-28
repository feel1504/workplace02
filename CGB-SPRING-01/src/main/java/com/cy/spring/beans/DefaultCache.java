package com.cy.spring.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Component注解用于告诉spring容器
 * 请将这个类交给spring管理
 * @Lazy用于告诉spring容器此对象要延迟加载
 * @Scope用于告诉spring容器bean作用域
 */
@Lazy
@Scope("singleton")
@Component
public class DefaultCache implements Cache {
    public DefaultCache(){
        System.out.println("构造");
    }
    @PostConstruct //告诉spring此对象初始化时执行init方法
    public void init(){
        System.out.println("init");
    }
    @PreDestroy
    public void close(){
        System.out.println("销毁");
    }
}
