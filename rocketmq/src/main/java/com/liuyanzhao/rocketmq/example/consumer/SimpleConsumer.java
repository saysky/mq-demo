package com.liuyanzhao.rocketmq.example.consumer;

import com.alibaba.fastjson.JSON;
import com.liuyanzhao.rocketmq.example.common.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;


/**
 * @author 言曌
 * @date 2019-12-01 22:48
 */
@Component
@Slf4j
@RocketMQMessageListener(topic = "${rocketmq.topic.default}", consumerGroup = "my-consumer_test-topic")
public class SimpleConsumer implements RocketMQListener<MessageEntity> {

    @Override
    public void onMessage(MessageEntity message) {
        log.info("接收消息Message：{}", JSON.toJSONString(message));
    }


}