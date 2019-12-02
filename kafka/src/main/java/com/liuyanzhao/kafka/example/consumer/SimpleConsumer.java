package com.liuyanzhao.kafka.example.consumer;

import com.alibaba.fastjson.JSONObject;
import com.liuyanzhao.kafka.example.common.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author 言曌
 * @date 2019-12-01 15:38
 */

@Component
@Slf4j
public class SimpleConsumer {

    @KafkaListener(topics = "${kafka.topic.default}")
    public void listen(ConsumerRecord<?, ?> record,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        //判断是否NULL
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            //获取消息
            Object message = kafkaMessage.get();

            MessageEntity messageEntity = JSONObject.parseObject(message.toString(), MessageEntity.class);

            log.info("接收消息Topic：{}", topic);
            log.info("接收消息Record：{}", record);
            log.info("接收消息Message：{}", messageEntity);
        }
    }

}
