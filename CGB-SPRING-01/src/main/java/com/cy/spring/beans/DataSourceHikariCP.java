package com.cy.spring.beans;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceHikariCP {
    @Bean(value = "hiKar")
    public DataSource getHikarConnection(){
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl("jdbc:mysql:///blog?serverTimezone=GMT");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setMaxWait(10000);
        return ds;
    }
}
