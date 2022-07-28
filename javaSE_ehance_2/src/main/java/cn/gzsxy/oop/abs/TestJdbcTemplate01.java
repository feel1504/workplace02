package cn.gzsxy.oop.abs;

public class TestJdbcTemplate01 {
    public static void main(String[] args) {
        JdbcTemplate jdbc = new JdbcTemplate();
        jdbc.setDataSource(DataSourceFactory.getDataSource());
        String sql = "update sys_logs set username=? where id=?";
        Object[] arr = {"root",13};
        int rows = jdbc.deleteObject(sql, arr);
        System.out.println(rows);
    }
}
