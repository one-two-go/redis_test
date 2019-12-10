package com.sunhao.controller.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * 项目名称：redistest
 * 类 名 称：MsgListener
 * 类 描 述：TODO
 * 创建时间：2019/12/10 11:16 上午
 * 创 建 人：sunhao
 */
public class MsgListener implements MessageListener<String,String> {


    @Override
    public void onMessage(ConsumerRecord<String, String> data) {
        String msg = data.value();
        System.out.println(msg);
    }
}
