package com.gzsxy.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class JedisDemo01 {
    public static void main(String[] args) {
        //1、创建jedis对象
        Jedis jedis = new Jedis("192.168.38.130",6379);
        //2、测试
        String value = jedis.ping();
        System.out.println(value);
    }
    //操作key
    @Test
    public void demo1(){
        //1、创建jedis对象
        Jedis jedis = new Jedis("192.168.38.130",6379);
        jedis.select(1);
        //2、添加（set、ttl(设置存活时长)、mset(批量添加)）
        jedis.set("name","lucy");
        jedis.setex("user",10,"张三");

        System.out.println("--------------------");
        jedis.mset("u1","1","u2","2");
        //批量获取
        List<String> mget = jedis.mget("u1", "u2");
        for (String m : mget) {
            System.out.println(m);
        }

        //3、获取
        String name = jedis.get("name");
        System.out.println(name);
        //获取所有key输出
        Set<String> keys = jedis.keys("*");
        for (String s : keys) {
            System.out.println(s);

        }
        //测试exists、ttl、方法
        Boolean ex = jedis.exists("mame");
        System.out.println(ex);

        //看还存在多少时间
        Long ttl = jedis.ttl("name");
        System.out.println(ttl);

//        for (int i = 0;; i++) {
//            ttl = jedis.ttl("user");
//            System.out.print(ttl);
//            if(ttl == -2){
//                break;
//            }
//        }

    }

    //操作list
    //双向链表
    @Test
    public void demo2(){
        //1、创建jedis对象
        Jedis jedis = new Jedis("192.168.38.130",6379);
        jedis.select(1);

        //添加
        jedis.lpush("list1","lucy","mary","jack","mary");
        //获取
        List<String> list1 = jedis.lrange("list1", 0, -1);
        System.out.println(list1);

    }
    //操作set
    @Test
    public void demo3() throws InterruptedException {
        //1、创建jedis对象
        Jedis jedis = new Jedis("192.168.38.130",6379);
        jedis.select(1);

        //添加
        jedis.sadd("setList","lucy","mary","jack","mary");
        //获取
        Set<String> setList = jedis.smembers("setList");
        System.out.println(setList);
        //设置存活时长
        jedis.expire("setList",5);
        Thread.sleep(1000*5);
        System.out.println(jedis.smembers("setList"));
    }
    //操作hash
    @Test
    public void demo4() throws InterruptedException {
        //1、创建jedis对象
        Jedis jedis = new Jedis("192.168.38.130",6379);
        jedis.select(1);
        //添加
        jedis.hset("hashset", "age", "20");
        jedis.hset("hashset","name","yang");
        //获取
        String hget = jedis.hget("hashset", "age");

        HashMap<String, String> map = new HashMap<>();
        map.put("name","jack");
        map.put("age","20");
        map.put("addr","china");
        jedis.hmset("user",map);
        List<String> user = jedis.mget("user");
        for (String u :
                user) {
            System.out.println(u);
        }

        System.out.println(hget);
    }

}