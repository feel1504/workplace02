package com.gzsxy.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class PhoneCode {
    public static void main(String[] args) {
        setCode("18786262340");
//        getRedisCode("18786262340","57581");

    }
    //1、生成6为数字
    public static String getCode(){
        Random random = new Random();
        double i = Math.random();
        String code = Integer.toString((int) (i*1000000));
        System.out.println(code);
        return code;
    }
    //2、每天手机只能发送三次，验证码到redis中设置过期时间
    public static void setCode(String phone){
        Jedis jedis = new Jedis("192.168.38.130",6379);
        jedis.select(1);

        //拼接key
        String countKey = "VerifyCode"+phone+":count";
        String codeKey = "VerifyCode"+phone+":code";

        //每个手机每天发送三次
        String count = jedis.get(codeKey);
        if(count==null){
            jedis.setex(countKey,24*60*60,"1");
        }else if(Integer.parseInt(countKey)<=2){
            jedis.incr(countKey);
        }else if(Integer.parseInt(countKey)>2){
            System.out.println("发送次数超过三次");
            jedis.close();
        }
        //发送验证码到redis中
        String vcode = getCode();
        jedis.set(codeKey,vcode);
        jedis.expire(codeKey,120);
        jedis.close();
    }
    //3、验证吗校验
    public static void getRedisCode(String phone,String code){
        Jedis jedis = new Jedis("192.168.38.130",6379);
        jedis.select(1);
        String codeKey = "VerifyCode"+phone+":code";
        System.out.println(codeKey);
        String redisCode = jedis.get(codeKey);
        System.out.println(redisCode);

        if(redisCode.equals(code)){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
}
