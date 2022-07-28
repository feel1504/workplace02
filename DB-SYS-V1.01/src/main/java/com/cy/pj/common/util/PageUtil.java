package com.cy.pj.common.util;

import com.cy.pj.common.vo.PageObject;

import java.util.List;

public class PageUtil {
    public static <T> PageObject<T> newInstance(int rowCount, List<T> records, int pageCurrent, int pageSize){
        PageObject pageObject = new PageObject<T>();
        int pageCount = (rowCount-1)*pageSize+1;
        pageObject.setPageCount(pageCount);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(records);
        pageObject.setRowCount(rowCount);
        return pageObject;
    }
}
