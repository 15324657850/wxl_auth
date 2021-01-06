package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wxl
 */

/**
 * 日志表
 */
@ApiModel(value = "com-example-demo-entity-Log")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_log")
public class Log implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 用户编号
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户编号")
    private Long userId;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 0 登录日志 1 操作日志
     */
    @TableField(value = "log_type")
    @ApiModelProperty(value = "0 登录日志 1 操作日志")
    private String logType;

    /**
     * 操作
     */
    @TableField(value = "operation")
    @ApiModelProperty(value = "操作")
    private String operation;

    /**
     * ip 地址
     */
    @TableField(value = "ip")
    @ApiModelProperty(value = "ip 地址")
    private String ip;

    /**
     * 请求方法
     */
    @TableField(value = "request_method")
    @ApiModelProperty(value = "请求方法")
    private String requestMethod;

    /**
     * 请求 url
     */
    @TableField(value = "request_url")
    @ApiModelProperty(value = "请求 url")
    private String requestUrl;

    /**
     * 请求类型
     */
    @TableField(value = "request_type")
    @ApiModelProperty(value = "请求类型")
    private String requestType;

    /**
     * 请求参数
     */
    @TableField(value = "request_param")
    @ApiModelProperty(value = "请求参数")
    private String requestParam;

    /**
     * 响应时间
     */
    @TableField(value = "response_time")
    @ApiModelProperty(value = "响应时间")
    private Integer responseTime;

    /**
     * 是否成功
     */
    @TableField(value = "is_success")
    @ApiModelProperty(value = "是否成功")
    private Boolean isSuccess;

    /**
     * 失败信息
     */
    @TableField(value = "error_message")
    @ApiModelProperty(value = "失败信息")
    private String errorMessage;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_LOG_TYPE = "log_type";

    public static final String COL_OPERATION = "operation";

    public static final String COL_IP = "ip";

    public static final String COL_REQUEST_METHOD = "request_method";

    public static final String COL_REQUEST_URL = "request_url";

    public static final String COL_REQUEST_TYPE = "request_type";

    public static final String COL_REQUEST_PARAM = "request_param";

    public static final String COL_RESPONSE_TIME = "response_time";

    public static final String COL_IS_SUCCESS = "is_success";

    public static final String COL_ERROR_MESSAGE = "error_message";

    public static final String COL_CREATE_TIME = "create_time";
}