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
 * 登录日志表
 */
@ApiModel(value = "com-example-demo-entity-LoginLog")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_login_log")
public class LoginLog implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 登录时间
     */
    @TableField(value = "login_time")
    @ApiModelProperty(value = "登录时间")
    private Date loginTime;

    /**
     * 登录地点
     */
    @TableField(value = "location")
    @ApiModelProperty(value = "登录地点")
    private String location;

    /**
     * IP地址
     */
    @TableField(value = "ip")
    @ApiModelProperty(value = "IP地址")
    private String ip;

    /**
     * 操作系统
     */
    @TableField(value = "system")
    @ApiModelProperty(value = "操作系统")
    private String system;

    /**
     * 浏览器
     */
    @TableField(value = "browser")
    @ApiModelProperty(value = "浏览器")
    private String browser;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_LOGIN_TIME = "login_time";

    public static final String COL_LOCATION = "location";

    public static final String COL_IP = "ip";

    public static final String COL_SYSTEM = "system";

    public static final String COL_BROWSER = "browser";
}