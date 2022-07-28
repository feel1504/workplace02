package cn.gzsxy.test;

//使用接口方式演示查询

import cn.gzsxy.blog.dao.AuthorDao;
import cn.gzsxy.blog.pojo.Author;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class testAuthorMapper extends TestBase{
    @Test
    public void testFindPageObjects(){
        //1、获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2、执行查询
            //2.1、获取AutorDao代理对象
        AuthorDao dao = sqlSession.getMapper(AuthorDao.class);
            //2.2、基于代理执行sql
        List<Author> authors = dao.selectByLimit(0, 3);
        for (Author author : authors){
            System.out.println(author);
        }
        //3、关闭查询
        sqlSession.close();
    }

    //删除多条数据
    @Test
    public void testDeleteObjects(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            AuthorDao dao = sqlSession.getMapper(AuthorDao.class);
            Integer[] ids = {12,13,14};
            int row = dao.deleteByIds(ids);
            sqlSession.commit();
            System.out.println(row);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
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
