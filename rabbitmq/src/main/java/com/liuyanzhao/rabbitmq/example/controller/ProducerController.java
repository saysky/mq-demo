package com.liuyanzhao.rabbitmq.example.controller;

import com.alibaba.fastjson.JSON;
import com.liuyanzhao.rabbitmq.example.common.ErrorCode;
import com.liuyanzhao.rabbitmq.example.common.MessageEntity;
import com.liuyanzhao.rabbitmq.example.common.Response;
import com.liuyanzhao.rabbitmq.example.producer.SimpleProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 言曌
 * @date 2019-12-01 15:49
 */

@RestController
@RequestMapping("/producer")
@Slf4j
public class ProducerController {


    @Autowired
    private SimpleProducer simpleProducer;

    private static final String KEY = "key";
    
    private static final String QUEUE = "myQueue";

    @PostMapping("/send")
    public Response send(@RequestBody MessageEntity message) {
        try {
            log.info("rabbitmq的消息：{}", JSON.toJSONString(message));
            this.simpleProducer.send(QUEUE, KEY, message);
            log.info("rabbitmq消息发送成功！");
            return new Response(ErrorCode.SUCCESS, "rabbitmq消息发送成功");
        } catch (Exception ex) {
            log.error("rabbitmq消息发送失败：", ex);
            return new Response(ErrorCode.EXCEPTION, "rabbitmq消息发送失败");
        }
    }
}
