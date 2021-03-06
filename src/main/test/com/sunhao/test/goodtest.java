package com.sunhao.test;

import com.sunhao.entity.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * 项目名称：redistest
 * 类 名 称：goodtest
 * 类 描 述：获取本地的文件
 * 创建时间：2019/12/6 6:22 下午
 * 创 建 人：sunhao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:redis.xml")
public class goodtest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void goodtest() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("/Users/sunhao/Documents/BW/1707d/redistest/src/main/test/resources/Goods.txt"));
        String line = "";
        ArrayList<Goods> list = new ArrayList<>();
        while ((line=br.readLine())!=null){
            System.out.println(line+"========");
            String[] split = line.split("==");
            Goods goods = new Goods();
            goods.setId(Integer.parseInt(split[0]));
            goods.setName(split[1]);
            String sprice = split[2].replace("¥", "");
            goods.setPrice(Double.parseDouble(sprice));
            String bfb = split[3].replace("%", "");
            goods.setBfb(Integer.parseInt(bfb));
            list.add(goods);
            redisTemplate.opsForZSet().add("goods_zset",goods,goods.getBfb());
        }

        redisTemplate.opsForList().leftPushAll("goods_list",list.toArray());
    }



}
