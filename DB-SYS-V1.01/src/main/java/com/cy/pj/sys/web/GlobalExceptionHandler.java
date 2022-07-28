package com.cy.pj.sys.web;

import com.cy.pj.common.vo.JsonResult;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice   //使用此注解，则以下类为全局异常处理类
public class GlobalExceptionHandler {
    /*
    在此异常处理类中，我们对异常信息进行封装，定义异常处理方法，方法返回值为JsonResult,
    JsonResult可以封装正常信息，也可以封装异常信息
    异常处理方法名为doHandlerRuntionException，处理所有运行时异常，在方法中我们吧异常信息
    做一个封装，疯转的过程就是new一个JsonResult，传一个异常对象，给JsonResout，也可以吧异常信息
    打印在控制台上，以便调试
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class) //异常处理器
    public JsonResult doHandlerRuntionException(RuntimeException e){
        e.printStackTrace();
        return new JsonResult(e);
    }

    @ExceptionHandler(ShiroException.class) //异常处理器
    @ResponseBody
    public JsonResult doHandlerShiroException(ShiroException e){
        JsonResult r = new JsonResult();
        r.setState(0);
        if(e instanceof UnknownAccountException){
            r.setMessage("账户不存在");
        }else if(e instanceof LockedAccountException){
            r.setMessage("账户被禁用");
        }else if(e instanceof IncorrectCredentialsException){
            r.setMessage("密码不正确");
        }else if(e instanceof AuthorizationException){
            r.setMessage("没有此操作权限");
        }else {
            r.setMessage("系统维护中");
        }
        e.printStackTrace();
        return r;
    }
}
