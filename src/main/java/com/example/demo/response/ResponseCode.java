package com.example.demo.response;

import lombok.Getter;

/**
 * @author wxl
 */
@Getter
public enum ResponseCode {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 成功
     */
    FAIL(1, "成功"),
    ;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 状态码
     */
    int code;
    /**
     * 消息
     */
    String message;
}
