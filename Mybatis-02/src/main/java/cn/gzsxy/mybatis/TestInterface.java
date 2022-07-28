package cn.gzsxy.mybatis;

import cn.gzsxy.dao.AuthorDao;
import cn.gzsxy.pojo.Author;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestInterface extends TestBase{
    @Test
    public void deleteByIds(){
        SqlSession sqlSession = factory.openSession();
        AuthorDao dao = sqlSession.getMapper(AuthorDao.class);
        int rows = dao.deleteByIds(4, 5, 6);
        System.out.println(rows);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void selectById(){
        SqlSession sqlSession = factory.openSession();
        AuthorDao dao = sqlSession.getMapper(AuthorDao.class);
        List<Author> au = dao.findAllLimit(0, 3);
        System.out.println("size="+au.size());
        sqlSession.close();
    }
    @Test
    public void updateByName(){
        SqlSession sqlSession = factory.openSession();
        AuthorDao dao = sqlSession.getMapper(AuthorDao.class);
        int row = dao.updateByName("mybatis-01", "6.16");
        System.out.println(row);
        sqlSession.commit();
        sqlSession.close();
    }
}
