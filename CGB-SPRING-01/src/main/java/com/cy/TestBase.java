package com.cy;

import com.cy.spring.config.SpringConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class TestBase {
    protected AnnotationConfigApplicationContext ctx;

    @Before
    public void init(){
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
    }
    @After
    public void close(){
        ctx.close();
    }
    @Test
    public void testCtx(){
        System.out.println(ctx);
        DataSource as = ctx.getBean("druid", DataSource.class);
        System.out.println(as);
    }
}
