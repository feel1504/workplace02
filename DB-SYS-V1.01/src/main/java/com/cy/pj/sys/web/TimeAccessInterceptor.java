package com.cy.pj.sys.web;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * spring mvc中的handler拦截器定义
 * 基于此拦截器实现时间点的拦截和放行
 */
@Component //交给spring管理
public class TimeAccessInterceptor extends HandlerInterceptorAdapter {
    /*
    该方法在后端控制器方法执行之前执行
    return 此返回值决定了这个请求继续传播还是到此为止
     */

    @Override
    /*
    返回值为true的时候放行
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //设置开始允许访问的时间
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,9);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        long start = c.getTimeInMillis();
        //设置结束访问的时间
        c.set(Calendar.HOUR_OF_DAY,19);
        long end = c.getTimeInMillis();
        //基于时间设置拦截和放行
        long time = System.currentTimeMillis();
        if(time>start && time<end){
            System.out.println("放行");
            return true;
        }
        System.out.println(start + "----" + time + "------" + end);
        System.out.println("no");
        return false;
    }
}
