package cn.gzsxy.blog.dao;

/*
基于接口方式实现Mybatis映射操作需要：
    1）接口的全类名与映射文件的命名空间namespace相同
    2）接口中的方法与映射文件元素id相同
    3）接口方法参数与映射文件元素需要的参数相同，多于一个参数，使用@Paranm注解
    4）接口口方法返回值类型与映射文件元素resultType属性值一致
 */

import cn.gzsxy.blog.pojo.Author;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
/*如果只有Dao接口文件，无xml映射文件，在接口上加@CacheNamespace，启动二级缓存文件*/
//@CacheNamespace(size = 2048)

/*如果接口和映射文件xml同时存在，则在接口上加CacheNamespaceRef，其中name属性是映射文件xml的命名空间，相当于xml引用<cache>*/
//这样Doo接口通过引用映射配置文件中的cache元素
@CacheNamespaceRef(name = "cn.gzsxy.blog.dao.AuthorDao")
public interface AuthorDao {
    Author findObjectById();
    /**
     * 分页查询
     * 当方法的参数对于一个时，可以使用@Param注解对参数进行修饰，由底层将参数封装到mao对象中
     * 使用@Param注解的值和映射文件（mapper
     * ）中参数名一致
     * @param start 分页起始下标
     * @param end 页面大小
     * @return
     */
    /*
    @param注解：
    不加这个注解的话，默认传过来的map是[arg0:val,arg1,val]=[0:val,1:val,2:val]
    加了注解相当于是将arg0.1....替换成了我们要传的key
     */
    //分页显示
    List<Author> selectByLimit(@Param("start") int start,@Param("end") int end);
    //删除多条
    int deleteByIds(Integer ... ids);
    //修改密码
    @Update("update author set password=#{newPassword},modifiedTime=now() where username=#{username}")
    int updatePassword(@Param("username") String username, @Param("newPassword") String newPassword);
    //根据id查询数据
    @Select("select * from author where id=#{id}")
    Author selectById(@Param("id") int id);
}
