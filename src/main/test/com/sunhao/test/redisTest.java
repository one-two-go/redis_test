//package com.sunhao.test;
//
//import com.sunhao.redis.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.*;
//
///**
// * 项目名称：_1707d2test
// * 类 名 称：redisTest
// * 类 描 述：TODO
// * 创建时间：2019/12/5 1:26 下午
// * 创 建 人：sunhao
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:redis.xml")
//public class redisTest {
//
//    @Autowired
//    RedisTemplate redisTemplate;
//    //测试zset
//    @Test
//    public  void zsetTest(){
//
//        redisTemplate.opsForZSet().add("kkk","score1",100);
//        redisTemplate.opsForZSet().add("mmmm","score2",90);
//
//        Set kkk = redisTemplate.opsForZSet().range("kkk", 0, -1);
//        Set kkk1 = redisTemplate.opsForZSet().rangeByScoreWithScores("kkk", 0, -1);
//
//        System.out.println(kkk);
//        System.out.println(kkk1);
//
//    }
//
//
//    //测试set
//    @Test
//    public void setTest(){
//
//        //存
//        redisTemplate.opsForSet().add("myset","a","b","c","d");
//        redisTemplate.opsForSet().add("myset1","c","d","e","f","g");
////        //取
////        Set myset = redisTemplate.opsForSet().members("myset");
////        System.out.println(myset);
//        //差集
//        Set difference = redisTemplate.opsForSet().difference("myset", "myset1");
//        System.out.println(difference);
//        //交集
//        Set intersect = redisTemplate.opsForSet().intersect("myset", "myset1");
//        System.out.println(intersect);
//        //并集 （以 前一个的为准 ）
//        Set union = redisTemplate.opsForSet().union("myset", "myset");
//        System.out.println(union);
//
//    }
//
//
//    //测试hash
//    @Test
//    public void hashTest() {
//        User user = new User();
//        user.setId(1);
//        user.setName("hushasha");
//        User user1 = new User();
//        user1.setId(2);
//        user1.setName("equan");
//        HashMap<String, User> map = new HashMap<String, User>();
//        map.put(user.getId() + "", user);
//        map.put(user1.getId() + "", user1);
//
//        redisTemplate.opsForHash().putAll("myhash", map);
//        Map entries = redisTemplate.opsForHash().entries("myhash");
//        Set set = entries.entrySet();
//        for (Object object : set) {
//            System.out.println(object);
//        }
//    }
//
//
//    //测试list
//    @Test
//    public void listTest() {
//        User user = new User();
//        user.setId(1);
//        user.setName("hushasha");
//        User user1 = new User();
//        user1.setId(2);
//        user1.setName("equan");
//
//        ArrayList<User> list = new ArrayList<User>();
//        list.add(user);
//        list.add(user1);
//        redisTemplate.opsForList().leftPushAll("mylist", list.toArray());
//
//        List range = redisTemplate.opsForList().range("mylist", 0, -1);
//        for (Object object : range) {
//            System.out.println(object);
//        }
//    }
//
//    //测试String
//    @Test
//    public void StringTest() {
////        //存
////        redisTemplate.opsForValue().set("name","zhangsan");
////        //取
////        String name = (String) redisTemplate.opsForValue().get("name");
////        System.out.println(name);
//        //存对象
//        User user = new User();
//        user.setId(11);
//        user.setName("lissssi");
//
//        redisTemplate.opsForValue().set("kkk", user);
//
//        User user1 = (User) redisTemplate.opsForValue().get(user);
//        System.out.println(user1);
//
//    }
//
//
//}
