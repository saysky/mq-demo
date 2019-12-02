package com.liuyanzhao.rabbitmq.example.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
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
    private AmqpTemplate amqpTemplate;

    public void send(String queue, String key, Object entity) {
        log.info("发送消息入参：{}", entity);
        amqpTemplate.convertAndSend(queue, entity);
    }
}
