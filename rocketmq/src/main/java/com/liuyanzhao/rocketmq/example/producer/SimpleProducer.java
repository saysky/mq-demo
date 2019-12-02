package com.liuyanzhao.rocketmq.example.producer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 言曌
 * @date 2019-12-01 22:57
 */

@Component
@Slf4j
public class SimpleProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void send(String topic, String key, Object entity) {
        log.info("发送消息入参：{}", entity);
        rocketMQTemplate.convertAndSend(topic, entity);
    }
}
