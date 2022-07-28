package cn.gzsxy.oop.abs;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

public interface DataSourceFactory {
    static DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///jtsys?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
}
