package com.cy.test;

import com.cy.TestBase;
import com.cy.spring.service.DefaultSearchService;
import org.junit.Test;

public class TestSearchService  extends TestBase {
    @Test
    public void testDruidDataSource() throws Exception{
        DefaultSearchService ds = ctx.getBean("defaultSearchService", DefaultSearchService.class);
        System.out.println(ds);
    }
}
