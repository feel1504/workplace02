package cn.gzsxy.mybatis;

import cn.gzsxy.pojo.Author;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class AuthorXml extends TestBase{
    @Test
    public void insertById(){
        SqlSession sqlSession = factory.openSession();
        Author author = new Author(null,"mybatis-03","852333",
                "肉丝","31221@qq.com","10086","java傻瓜"
        );
        String stement = "cn.gzsxy.dao.AuthorDao.insertById";
        int rows = sqlSession.insert(stement, author);
        System.out.println(rows);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void selectAllLimit(){
        SqlSession sqlSession = factory.openSession();
        String s = "cn.gzsxy.dao.AuthorDao.findAllLimit";
        HashMap<String, Integer> map = new HashMap<>();
        map.put("start",0);
        map.put("rows",3);
        List<Author> au = sqlSession.selectList(s, map);
        System.out.println("rows="+au.size());
        sqlSession.close();
    }
}
