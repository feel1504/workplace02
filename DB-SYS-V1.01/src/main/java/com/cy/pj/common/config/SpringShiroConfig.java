package com.cy.pj.common.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;

@Configuration
public class SpringShiroConfig {
    @Bean   //其返回值交给spring管理
    public SecurityManager newSecurityManager(@Autowired Realm realm){
        DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
        sManager.setRealm(realm);
        return sManager;
    }


    /**
     * 负责创建过滤器工厂，通过此工厂创建过滤器
     */
    @Bean("shiroFilterFactory")
    public ShiroFilterFactoryBean newShiroFilterFactoryBean(@Autowired SecurityManager securityManager){
        //构建ShiroFilter工厂
        ShiroFilterFactoryBean sfBean = new ShiroFilterFactoryBean();
        //关联securityManager对象
        sfBean.setSecurityManager(securityManager);
        //假如没有认证请求先访问此认证的url
        sfBean.setLoginUrl("/doLoginUI");
        //定义map指定请求过滤规则（允许那些匿名访问，那些认证访问）
        //先指定那些匿名访问，再指定认证访问
        LinkedHashMap<String ,String> map = new LinkedHashMap<>();
        //"anon"表示允许匿名访问，用再静态资源
        map.put("/bower_components/**","anon");
        map.put("/build/**","anon");
        map.put("/dist/**","anon");
        map.put("/plugins/**","anon");
        map.put("/user/doLogin","anon");
        map.put("/doLogout","logout");
        //authc表示认证访问
        map.put("/**","authc");
        //过滤器工厂根据map创建过滤器
        sfBean.setFilterChainDefinitionMap(map);
        return sfBean;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor
    newLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @DependsOn("lifecycleBeanPostProcessor")
    @Bean
    public DefaultAdvisorAutoProxyCreator newDefaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor
    newAuthorizationAttributeSourceAdvisor(
            @Autowired SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor=
                new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
