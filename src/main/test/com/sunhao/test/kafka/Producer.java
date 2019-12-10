package com.sunhao.test.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ��Ŀ���ƣ�redistest
 * �� �� �ƣ�Producer
 * �� �� ����TODO
 * ����ʱ�䣺2019/12/10 1:16 ����
 * �� �� �ˣ�sunhao
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:producer.xml")
//public class Producer {
//    @Autowired
//    KafkaTemplate<String,String> kafkaTemplate;
//
//    //�����߷�����Ϣ
//    @Test
//    public void producer(){
////        kafkaTemplate.send("1707d2kafka","ȫ������ĭ");
//             //kafka��������Ҫ���͵���Ϣ
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
        kafkaTemplate.send("1707d2kafka","�������Ҳ�ϰ��");
    }

}
