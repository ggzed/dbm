package com.ggzed.im.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.ggzed.im.model.common.BaseModel;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.StringTypeHandler;

import java.util.List;

/**
 * <p>
 * 权限信息
 * </p>
 *
 * @author ggzed
 * @since 2024-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "role_info",autoResultMap = true)
public class RoleInfo extends BaseModel {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 编码
     */
    private String code;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Long> menus;

    /**
     * 名称
     */
    private String name;
}
