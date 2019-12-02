package com.liuyanzhao.rocketmq.example.controller;

import com.alibaba.fastjson.JSON;
import com.liuyanzhao.rocketmq.example.common.ErrorCode;
import com.liuyanzhao.rocketmq.example.common.MessageEntity;
import com.liuyanzhao.rocketmq.example.common.Response;
import com.liuyanzhao.rocketmq.example.producer.SimpleProducer;
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

    @Value("${rocketmq.topic.default}")
    private String topic;

    private static final String KEY = "key";

    @PostMapping("/send")
    public Response send(@RequestBody MessageEntity message) {
        try {
            log.info("rocketmq的消息：{}", JSON.toJSONString(message));
            this.simpleProducer.send(topic, KEY, message);
            log.info("rocketmq消息发送成功！");
            return new Response(ErrorCode.SUCCESS, "rocketmq消息发送成功");
        } catch (Exception ex) {
            log.error("rocketmq消息发送失败：", ex);
            return new Response(ErrorCode.EXCEPTION, "rocketmq消息发送失败");
        }
    }
}
