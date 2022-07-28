package cn.gzsxy.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.InputStream;


public class TestBase {
    protected SqlSessionFactory factory;

    @Before
    public void init() throws Exception{
        InputStream in= Resources.getResourceAsStream("mybatis-configs.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        System.out.println(factory);
    }

}
