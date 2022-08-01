package com.cy.pj.common.aspect;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.util.IPUtils;
import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Service
public class SysLogAspect {
    @Autowired
    private SysLogDao sysLogDao;

    @Pointcut("bean(*ServiceImpl)")
    public void doLog(){}

    @Around("doLog()")
    public Object around(ProceedingJoinPoint jp) throws Throwable{
        long t1 = System.currentTimeMillis();
        Object result = jp.proceed();
        long t2 = System.currentTimeMillis();
        Method method = getTargetMethod(jp);
        String methodName = getTargetMethodName(method);
        saveObject(jp,(t2-t1));
        return result;

    }
    @Transactional(readOnly = false)
    void saveObject(ProceedingJoinPoint jp, long time) throws Throwable {
        //1、获取用户行为日志信息
        //用户名
        String username = ShiroUtils.getUsername();
        //method
        Method targetMethod = getTargetMethod(jp);
        String method = getTargetMethodName(targetMethod);
        //params
        String params = Arrays.toString(jp.getArgs());
        //operation
        String operation = "operation";
        RequiredLog rlog = targetMethod.getDeclaredAnnotation(RequiredLog.class);
        if(rlog != null && StringUtils.isEmpty(rlog.value())){
            operation = rlog.value();
        }
        //ip
        String ip = IPUtils.getIpAddr();

        //
        //2、封装用户行为日志
        SysLog log = new SysLog();
        log.setUsername(username);
        log.setParams(params);
        log.setMethod(method);
        log.setOperation(operation);
        log.setIp(ip);
        log.setTime(time);
        log.setCreatedTime(new Date());
        //3、将日志信息持久化
        System.out.println("-------"+log);
        sysLogDao.insertObject(log);
    }

    /**获取目标方法的名称：类全名+方法名**/
    private String getTargetMethodName(Method method){
        StringBuilder name = new StringBuilder(method.getDeclaringClass().getName());
        name.append(method.getName());
        return name.toString();
    }

    /**获取目标方法对象**/
    private Method getTargetMethod(ProceedingJoinPoint jp) throws Exception{
        //1、获取目标类对象
        Class<?> targetCls = jp.getTarget().getClass();
        //2、获取方法签名信息（方法名，参数列表）
        MethodSignature ms = (MethodSignature)jp.getSignature();
        //3、获取目标方法对象
        Method method = targetCls.getDeclaredMethod(ms.getName(),ms.getParameterTypes());
        return method;
    }
}
