package com.cy.pj.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

@Configuration
public class SpringWebConfig {//取代web.xml中filter配置
    //注册filter对象
    @Bean
    public FilterRegistrationBean<Filter> newFilterRegistrationBean(){
        //构建过滤器注册器
        FilterRegistrationBean<Filter> fBean = new FilterRegistrationBean<>();
        //创建过滤器对象
        DelegatingFilterProxy filter = new DelegatingFilterProxy("shiroFilterFactory");
        //过滤器注册道容器中
        fBean.setFilter(filter);
        //配置过滤器映射路径
        fBean.addUrlPatterns("/*");
        return fBean;
    }
}
