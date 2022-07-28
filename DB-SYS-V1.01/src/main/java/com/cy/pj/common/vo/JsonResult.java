package com.cy.pj.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * VO：
 * 借助对象封装服务器端的响应数据
 * JsonResult是一个VO对象：
 * 1）响应的状态码，1为正常，0为异常数据
 * 2）响应信息,呈现给用户的信息，例如一个弹窗中的数据
 * 3）响应数据，要呈现的正常数据，例如日志记录信息
 */
@Data
public class JsonResult implements Serializable {

    private static final long serialVersionUID = -5371897016966305399L;
    /**状态码，默认正常*/
    private int state=1;
    /**状态码对应的状态信息，默认是ok*/
    private String message = "ok";
    /**数据*/
    private Object data;
    public JsonResult(){}
    //如果有数据，默认状态是1，状态描述是ok
    public JsonResult(Object data){
        this.data = data;
    }
    //如果有异常，状态码为0，状态信息从异常中获取
    public JsonResult(Throwable e){
        this.state=0;
        //this.data = e;
        this.message = e.getMessage();//错误描述--状态描述
    }


}
