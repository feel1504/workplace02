package com.cy.pj.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 通过此对象封装分页数据
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageObject<T> implements Serializable {

    private static final long serialVersionUID = 1684876792546164773L;
    /**总记录数*/
    private Integer rowCount;
    /**当前记录*/
    private List<T> records;
    /**总页数*/
    private Integer pageCount;
    /**当前页码值*/
    private Integer pageCurrent;
    /**页面大小*/
    private Integer pageSize=3;

    public PageObject(Integer rowCount,List<T> records,Integer pageCurrent,Integer pageSize){
        this.rowCount = rowCount;
        this.records = records;
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
        this.pageCount = (rowCount-1)/pageSize+1;
    }
}
