package com.cy.test;

import com.cy.TestBase;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;

public class TestDataSource extends TestBase {
    @Test
    public void testDruidDataSource() throws Exception{
        DataSource ds = ctx.getBean("druid",DataSource.class);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
