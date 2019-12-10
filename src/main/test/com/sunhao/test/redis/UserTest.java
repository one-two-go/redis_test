package com.sunhao.test.redis;

import com.sunhao.entity.User;
import com.sunhao.utils.StringUtils;
import com.sunhao.utils.UserUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：redistest
 * 类 名 称：UserTest
 * 类 描 述：随机生成五万条数据，然后存在以json序列化和jdk hash 序列化存储在redis中
 * 创建时间：2019/12/7 9:33 上午
 * 创 建 人：sunhao
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:redis.xml")
public class UserTest {

   @Autowired
    RedisTemplate redisTemplate;

   @Test
    public  void jdkTest(){
       long start = System.currentTimeMillis();
       for (int i = 0;i<10000;i++) {
           User user = new User();
           user.setId(UserUtils.getNum(1, 100000));
           user.setName(UserUtils.getName());
           user.setPhonenum(UserUtils.getPhone());
           user.setGender(UserUtils.getSex());
           user.setEmail(UserUtils.getMail());
           user.setBirthday(UserUtils.getBirthday());
            redisTemplate.opsForValue().set("user"+1,user);
       }
       long end = System.currentTimeMillis();
       System.out.println("......");
       System.out.println("......");
       System.out.println("......");

   }
    @Test
   public void JsonTest(){
        long start = System.currentTimeMillis();
        for (int i = 0;i<10000;i++) {
            User user = new User();
            user.setId(UserUtils.getNum(1, 100000));
            user.setName(UserUtils.getName());
            user.setPhonenum(UserUtils.getPhone());
            user.setGender(UserUtils.getSex());
            user.setEmail(UserUtils.getMail());
            user.setBirthday(UserUtils.getBirthday());
            redisTemplate.opsForValue().set("user"+1,user);
        }
        long end = System.currentTimeMillis();
    }

    @Test
    public void HashTest(){
        long start = System.currentTimeMillis();
        HashMap<String, User> map = new HashMap<>();
        for (int i = 0;i<10000;i++) {
            User user = new User();
            user.setId(UserUtils.getNum(1, 100000));
            user.setName(UserUtils.getName());
            user.setPhonenum(UserUtils.getPhone());
            user.setGender(UserUtils.getSex());
            user.setEmail(UserUtils.getMail());
            user.setBirthday(UserUtils.getBirthday());
            map.put("s"+1,user);
            redisTemplate.opsForHash().put("user"+i,"use"+i,map);
        }
        redisTemplate.opsForHash().putAll("user",map);

    }


}

















