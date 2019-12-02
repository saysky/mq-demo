package com.liuyanzhao.kafka.example.controller;

import com.alibaba.fastjson.JSON;
import com.liuyanzhao.kafka.example.common.ErrorCode;
import com.liuyanzhao.kafka.example.common.MessageEntity;
import com.liuyanzhao.kafka.example.common.Response;
import com.liuyanzhao.kafka.example.producer.SimpleProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${kafka.topic.default}")
    private String topic;

    private static final String KEY = "key";

    @PostMapping("/send")
    public Response sendKafka(@RequestBody MessageEntity message) {
        try {
            log.info("kafka的消息：{}", JSON.toJSONString(message));
            this.simpleProducer.send(topic, KEY, message);
            log.info("kafka消息发送成功！");
            return new Response(ErrorCode.SUCCESS, "kafka消息发送成功");
        } catch (Exception ex) {
            log.error("kafka消息发送失败：", ex);
            return new Response(ErrorCode.EXCEPTION, "kafka消息发送失败");
        }
    }
}
