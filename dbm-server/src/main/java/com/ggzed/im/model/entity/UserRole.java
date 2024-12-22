package com.ggzed.im.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ggzed.im.model.common.BaseModel;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.StringTypeHandler;

import java.util.List;

/**
 * <p>
 * 用户-角色关联
 * </p>
 *
 * @author ggzed
 * @since 2024-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "user_role")
public class UserRole extends BaseModel {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 编码
     */
    private String userId;
}
