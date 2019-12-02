package com.liuyanzhao.rabbitmq.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author 言曌
 * @date 2019-12-01 22:48
 */
@Component
@Slf4j
public class SimpleConsumer  {


    /**
     * 数码供应商 接受消息
     * 只接受 computer 这个key的消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void processComputer(String message) {
        log.info("接收消息Message：{}", message);
    }
}