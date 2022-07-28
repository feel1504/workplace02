package com.cy.test;

import com.cy.TestBase;
import com.cy.spring.beans.DefaultCache;
import org.junit.Test;

public class TestCache extends TestBase {
    @Test
    public void TestDefaultCache(){
        DefaultCache cache01 = ctx.getBean("defaultCache", DefaultCache.class);
        DefaultCache cache02 = ctx.getBean("defaultCache", DefaultCache.class);
        System.out.println(cache02 == cache01);

    }
}
