package com.gz;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class SeckKill_redis {
    public static void main(String[] args) throws IOException, InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            String uid = random.nextInt(1000)+"";
            Thread.sleep(1000);
            boolean b = doSecKill(uid, "0101");
            if(b){
                System.out.println("成功");
            }
        }
    }
    public static boolean doSecKill(String uid,String prodid) throws IOException{
        //1、传入参数校验
        if(uid==null){
            System.out.println("用户id不能为空");
            return false;
        }
        if(prodid==null){
            System.out.println("商品id不能为空");
            return false;
        }
        //2、连接redis
        Jedis jedis = new Jedis("192.168.38.130",6379);//使用线程池实现连接超时问题
        //3、拼接key
            //3.1存量key
            String kcKey = "sk:"+prodid+":qt";
            //3.2秒杀成功用户key
            String userKey = "sk:"+prodid+":user";

        //4、获取库存，如果库存为null,秒杀未开始
        String kc = jedis.get(kcKey);
        if (kc == null) {
            System.out.println("秒杀还未开始");
            jedis.close();
            return false;
        }
        //5、判断用户是否重复秒杀操作
        Boolean sismember = jedis.sismember(userKey, uid);
        if(sismember){
            System.out.println("已经秒杀成功，不能重复");
            jedis.close();
            return false;
        }
        //6、判断商品数量，小于1，秒杀结束
        int count = Integer.parseInt(kc);
        if(count < 1){
            System.out.println("秒杀结束");
            jedis.close();
            return false;
        }
        //7、秒杀过程
            //库存减一

        //解决超卖问题，线程安全问题
        //监视库存
        jedis.watch(kcKey);
        //使用事务
        Transaction multi = jedis.multi();
        //添加操作到队列
        multi.decr(kcKey);
        multi.sadd(userKey,uid);
        //执行
        List<Object> exec = multi.exec();
        if(exec.size()==0||exec==null){
            System.out.println("秒杀失败");
            jedis.close();
            return false;
        }
//        jedis.decr(kcKey);
//        //秒杀成功用户加入清单
//        jedis.sadd(userKey,uid);
        jedis.close();
        return true;
    }
}





















