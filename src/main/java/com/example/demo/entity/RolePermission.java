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
 * 角色权限中间表
 */
@ApiModel(value = "com-example-demo-entity-RolePermission")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_role_permission")
public class RolePermission implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * role id
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value = "role id")
    private Integer roleId;

    /**
     * permission id
     */
    @TableField(value = "permission_id")
    @ApiModelProperty(value = "permission id")
    private Integer permissionId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_ROLE_ID = "role_id";

    public static final String COL_PERMISSION_ID = "permission_id";
}