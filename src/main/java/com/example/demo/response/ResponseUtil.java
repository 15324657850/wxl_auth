package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author wxl
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class ResponseUtil<T> implements Serializable {
    int code;
    String message;
    T data;


    public ResponseUtil(int code) {
        this.code = code;
    }

    public ResponseUtil(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseUtil(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseUtil(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.code;
    }

    private Boolean isFail() {
        return !isSuccess();
    }

    public static <T> ResponseUtil<T> bySuccess() {
        return new ResponseUtil<>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseUtil<T> bySuccess(String message) {
        return new ResponseUtil<T>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> ResponseUtil<T> bySuccessData(T data) {
        return new ResponseUtil<>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ResponseUtil<T> bySuccess(String message, T data) {
        return new ResponseUtil<>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResponseUtil<T> byError() {
        return new ResponseUtil<>(ResponseCode.FAIL.getCode());
    }

    public static <T> ResponseUtil<T> byError(String message) {
        return new ResponseUtil<>(ResponseCode.FAIL.getCode(), message);
    }

    public static <T> ResponseUtil<T> byErrorData(T data) {
        return new ResponseUtil<>(ResponseCode.FAIL.getCode(), data);
    }

    public static <T> ResponseUtil<T> byError(String message, T data) {
        return new ResponseUtil<>(ResponseCode.FAIL.getCode(), message, data);
    }

    public static <T> ResponseUtil<T> byError(int status, String message) {
        return new ResponseUtil<>(status, message, null);
    }

    public static <T> ResponseUtil<T> byResponseCode(ResponseCode responseCode) {
        return new ResponseUtil<>(responseCode.getCode(), responseCode.getMessage());
    }
}
