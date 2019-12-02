package com.liuyanzhao.rabbitmq.example.common;

import lombok.Data;

/**
 * @author 言曌
 * @date 2019-12-01 15:23
 */

@Data
public class MessageEntity {

    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String body;

}
