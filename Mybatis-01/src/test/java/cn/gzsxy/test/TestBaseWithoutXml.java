package cn.gzsxy.test;

import cn.gzsxy.blog.dao.AuthorDao;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

public class TestBaseWithoutXml {

    protected SqlSessionFactory sqlSessionFactory;

    @Before
    public void init(){
        //构建dataSource对象
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///blog?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //TransactionFactory事务管理工厂对象
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        //Environment环境对象
        Environment environment = new Environment("development",  transactionFactory, dataSource);
        //构建Configuration对象
        Configuration config = new Configuration(environment);
        //注册接口
        config.addMapper(AuthorDao.class);
        //构建sqlSessionFactory工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
    }
    @Test
    public void testSSF(){
        System.out.println(sqlSessionFactory);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);
        Connection conn = sqlSession.getConnection();
        System.out.println(conn);
    }
    //注解方式实现密码修改
    @Test
    public void testUpdateObjects(){
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取dao
            AuthorDao dao = sqlSession.getMapper(AuthorDao.class);
            //调dao方法
            int rows = dao.updatePassword("mybatis-01","ooop");
            System.out.println(rows);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();

        }
    }
}
