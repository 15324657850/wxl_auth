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
 * 权限表
 */
@ApiModel(value = "com-example-demo-entity-Permission")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_permission")
public class Permission implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 父级权限 id
     */
    @TableField(value = "parent_id")
    @ApiModelProperty(value = "父级权限 id")
    private Integer parentId;

    /**
     * 权限标识
     */
    @TableField(value = "permission")
    @ApiModelProperty(value = "权限标识")
    private String permission;

    /**
     * 菜单/按钮名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "菜单/按钮名称")
    private String name;

    /**
     * 菜单地址
     */
    @TableField(value = "path")
    @ApiModelProperty(value = "菜单地址")
    private String path;

    /**
     * 图标
     */
    @TableField(value = "icon")
    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 权限类型(0:菜单、1:按钮)
     */
    @TableField(value = "type")
    @ApiModelProperty(value = "权限类型(0:菜单、1:按钮)")
    private String type;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 创建用户
     */
    @TableField(value = "create_user")
    @ApiModelProperty(value = "创建用户")
    private String createUser;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_PERMISSION = "permission";

    public static final String COL_NAME = "name";

    public static final String COL_PATH = "path";

    public static final String COL_ICON = "icon";

    public static final String COL_TYPE = "type";

    public static final String COL_SORT = "sort";

    public static final String COL_CREATE_USER = "create_user";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}