package cn.gzsxy.oop.abs;

import java.sql.SQLException;

public class TestJdbcTemplate01 {

    public static void main(String[] args) throws SQLException {
        JdbcTemplate jt = new JdbcTemplate();
        //下面的代码，参数对象要求dataSource为DruidDataSource对象，如何写代码
        jt.setDataSource(DataSourceFactory.getDataSource());
        String sql = "delete from sys_logs where id=?";
        Object[] arr={12};
        int rows = jt.deleteObject(sql, arr);
        System.out.println("delete row:"+rows);
    }
}
