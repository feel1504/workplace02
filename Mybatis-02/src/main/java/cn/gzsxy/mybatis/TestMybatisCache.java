package cn.gzsxy.mybatis;

import cn.gzsxy.dao.AuthorDao;
import cn.gzsxy.pojo.Author;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatisCache extends TestBase{
    @Test
    public void testCache(){
        //第一次访问
        SqlSession sqlSession = factory.openSession();
        AuthorDao dao = sqlSession.getMapper(AuthorDao.class);
        List<Author> au1 = dao.findAllLimit(0, 3);
        System.out.println("size="+au1.size());
        sqlSession.commit();
        //相同sqlSession二次访问
        List<Author> au2 = dao.findAllLimit(0, 3);
        System.out.println("size="+au2.size());
        System.out.println(au1 == au2);
        sqlSession.close();
        //不同会话二次访问
        sqlSession = factory.openSession();
        dao = sqlSession.getMapper(AuthorDao.class);
        List<Author> au3 = dao.findAllLimit(0, 3);
        System.out.println("size="+au3.size());
        System.out.println(au2 == au3);
    }
}
