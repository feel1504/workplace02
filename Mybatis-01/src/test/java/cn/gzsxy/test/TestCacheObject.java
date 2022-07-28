package cn.gzsxy.test;

import cn.gzsxy.blog.dao.AuthorDao;
import cn.gzsxy.blog.pojo.Author;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestCacheObject extends TestBase{
    /**
     * 结论：一次会话重复sql->缓存
     *      二次会话重复sql->不共享缓存
     */
    //分页查询
    @Test
    public void testFirstLevel(){
        //1、获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        //2、执行查询
        //2.1、获取AutorDao代理对象
        AuthorDao dao = sqlSession.getMapper(AuthorDao.class);
        AuthorDao dao1 = sqlSession1.getMapper(AuthorDao.class);
        //2.2、基于代理执行sql
        List<Author> authors = dao.selectByLimit(0, 3);
        //执行事务提交操作session.commit()或者释放资源操作session.close()，二级缓存才会有数据
        sqlSession.commit();
//        sqlSession.close();

        System.out.println(authors.size());
        List<Author> authors1 = dao1.selectByLimit(0, 3);
        System.out.println(authors1.size());
        //3、关闭查询
        sqlSession.close();
    }

    //据id查询
    @Test
    public void testSelectById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        AuthorDao dao = sqlSession.getMapper(AuthorDao.class);
        Author author1 = dao.selectById(2);
        System.out.println(author1);

        sqlSession.close();

        //演示二次session会话查询
        sqlSession = sqlSessionFactory.openSession();
        dao = sqlSession.getMapper(AuthorDao.class);
        Author author2 = dao.selectById(2);
        System.out.println(author2);

        //两次对象(不)相等：如果readOnly = true返回true，否则默认false
        System.out.println(author1 == author2);//false
    }
}
