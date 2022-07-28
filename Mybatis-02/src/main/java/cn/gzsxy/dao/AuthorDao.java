package cn.gzsxy.dao;

import cn.gzsxy.pojo.Author;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@CacheNamespaceRef(name = "cn.gzsxy.dao.AuthorDao")
public interface AuthorDao {
    int deleteByIds(int ... arr);

    List<Author> findAllLimit(@Param("start") int s,@Param("rows") int rows);

    @Update("update author set password=#{pwd} where username=#{name}")
    int updateByName(@Param("name") String name,@Param("pwd") String pwd);
}
