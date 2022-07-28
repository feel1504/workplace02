package cn.gzsxy.oop.abs;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //返回连接
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();//返回连接
    }

    //执行删除操作
    public int deleteObject(String sql, Object[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
             conn = dataSource.getConnection();
             ps = conn.prepareStatement(sql);
             for(int i=0; i<args.length; i++){
                 ps.setObject(i+1,args[i]);
             }
             int rows = ps.executeUpdate();
             return rows;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }finally {
            try {
                if(conn != null){
                    conn.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}