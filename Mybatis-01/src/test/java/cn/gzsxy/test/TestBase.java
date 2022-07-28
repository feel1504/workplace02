package cn.gzsxy.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;

public class TestBase {
    protected static SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        String resource = "mybatis-configs.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    //类加载自动执行
//    static {
//        String resource = "mybatis-configs.xml";
//    InputStream inputStream = null;
//    try {
//        inputStream = Resources.getResourceAsStream(resource);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//    }

    @Test
    public void testSqlSessionFactory(){
        //sqlSessionFactory指向DefaultSqlSessionFactory
        System.out.println(sqlSessionFactory);
        //sqlSession指向的是DefaultSqlSession       Defau... implements sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);
        /*
            从哪里获取的连接？PooleDataSource连接池
            Connection对象指向谁？mysql驱动中的一个连接对象
         */
        Connection connection = sqlSession.getConnection();
        System.out.println(connection);
        System.out.println(connection.getClass());
    }

//    @After
}