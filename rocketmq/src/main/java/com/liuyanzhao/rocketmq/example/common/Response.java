package com.liuyanzhao.rocketmq.example.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 言曌
 * @date 2019-12-01 15:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {

    private static final long serialVersionUID = -972246069648445912L;
    /**
     * 响应编码
     */
    private int code;
    /**
     * 响应消息
     */
    private String message;

}
