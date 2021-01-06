package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wxl
 */

/**
 * 用户角色中间表
 */
@ApiModel(value = "com-example-demo-entity-UserRole")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_user_role")
public class UserRole implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * user id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "user id")
    private Long userId;

    /**
     * role id
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value = "role id")
    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_ROLE_ID = "role_id";
}