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
 * 用户表
 */
@ApiModel(value = "com-example-demo-entity-User")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_user")
public class User implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 用户名称
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名称")
    private String username;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    @ApiModelProperty(value = "用户密码")
    private String password;

    /**
     * 用户电话
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "用户电话")
    private String phone;

    /**
     * 用户邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "用户邮箱")
    private String email;

    /**
     * 盐值
     */
    @TableField(value = "salt")
    @ApiModelProperty(value = "盐值")
    private String salt;

    /**
     * 性别 0男 1女 2保密
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别 0男 1女 2保密")
    private String sex;

    /**
     * 用户状态 0锁定 1有效
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "用户状态 0锁定 1有效")
    private Boolean status;

    /**
     * 描述
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 创建用户
     */
    @TableField(value = "create_user")
    @ApiModelProperty(value = "创建用户")
    private String createUser;

    /**
     * 注册日期
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "注册日期")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";

    public static final String COL_PHONE = "phone";

    public static final String COL_EMAIL = "email";

    public static final String COL_SALT = "salt";

    public static final String COL_SEX = "sex";

    public static final String COL_STATUS = "status";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_CREATE_USER = "create_user";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}