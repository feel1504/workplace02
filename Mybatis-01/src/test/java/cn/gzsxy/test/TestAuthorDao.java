package cn.gzsxy.test;

import cn.gzsxy.blog.pojo.Author;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

//基于xml配置，使用mybatis配置文件
public class TestAuthorDao extends TestBase {

    @Test
    public void testInsertObject(){
        //1、构建Author对象
        Author author = new Author(null,"mybatis-03","852333",
                "肉丝","31221@qq.com","10086","java傻瓜"
                );
        //2、将对象写入数据库
            //2.1、获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
            //2.2、持久化数据到数据库
        String statement = "cn.gzsxy.blog.dao.AuthorDao.insertById";
        int rows = sqlSession.insert(statement, author);
        System.out.println(rows);
        //2.3、提交事务
        sqlSession.commit();
            //2.4、释放资源
        sqlSession.close();

    }
    @Test
    public void testUpdateObject(){
        //1、获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //2、查询指定对象id
            String statement = "cn.gzsxy.blog.dao.AuthorDao.findObjectById";
            Author obj = sqlSession.selectOne(statement, 1);
            System.out.println(obj);
            //3、修改对象
            obj.setPhone("120");
            obj.setEmail("112@qq.com");
            String state = "cn.gzsxy.blog.dao.AuthorDao.updateObjectById";
            int rows = sqlSession.update(state, obj);
            System.out.println(rows);
            //4、提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5、释放资源
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteObject(){
        //获取sqlSession对像
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取sql语句和对象
        String stement = "cn.gzsxy.blog.dao.AuthorDao.deleteById";
        Author author = new Author();
        author.setId(7);
        HashMap<String, Integer> mmap = new HashMap<>();
        mmap.put("io",11);
        //执行语句
        int rows = sqlSession.delete(stement, mmap);
        System.out.println(rows);
        //提交事务
        sqlSession.commit();
        //关闭连接
        sqlSession.close();
    }

    //分页
    @Test
    public void testLimitObject(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String stement = "cn.gzsxy.blog.dao.AuthorDao.selectByLimit";
        HashMap<String, Integer> map = new HashMap<>();
        map.put("start",0);
        map.put("end",3);
        List<Author> author = sqlSession.selectList(stement,map);
        for(Author a: author){
            System.out.println(a);
        }
        sqlSession.close();
    }

    //删除多条
    @Test
    public void testDeObject(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String stement = "cn.gzsxy.blog.dao.AuthorDao.deleteByIds";
        Integer[] ids = {8,9};
        int row = sqlSession.delete(stement, ids);
        sqlSession.commit();
        System.out.println("影响行数："+row);
        sqlSession.close();
    }

    //接口方法实现分页查询

}


