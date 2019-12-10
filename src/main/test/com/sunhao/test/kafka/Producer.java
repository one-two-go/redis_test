package com.sunhao.test.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 项目名称：redistest
 * 类 名 称：Producer
 * 类 描 述：TODO
 * 创建时间：2019/12/10 1:16 下午
 * 创 建 人：sunhao
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:producer.xml")
//public class Producer {
//    @Autowired
//    KafkaTemplate<String,String> kafkaTemplate;
//
//    //生产者发送消息
//    @Test
//    public void producer(){
////        kafkaTemplate.send("1707d2kafka","全都是泡沫");
//             //kafka里面的组和要发送的消息
//        kafkaTemplate.send("1707d2kafka","HELLO WORLD");
//    }
//}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:producer.xml")
public class Producer {
    @Autowired
    KafkaTemplate kafkaTemplate;
    @Test
    public void producer(){
        kafkaTemplate.send("1707d2kafka","戒了烟我不习惯");
    }

}
