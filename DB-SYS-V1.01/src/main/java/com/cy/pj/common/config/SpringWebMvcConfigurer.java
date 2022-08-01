package com.cy.pj.common.config;

import com.cy.pj.sys.web.TimeAccessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringWebMvcConfigurer implements WebMvcConfigurer {
    /**配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeAccessInterceptor()).addPathPatterns("/user/doLogin");
    }
}
