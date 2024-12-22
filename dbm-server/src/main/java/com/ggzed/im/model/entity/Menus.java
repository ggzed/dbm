package com.ggzed.im.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ggzed.im.model.common.BaseModel;
import lombok.*;
import lombok.experimental.Accessors;

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
@TableName("menus")
public class Menus extends BaseModel {

    /**
     * 名称
     */
    private String name;
    /**
     * 名称
     */
    private String path;
    /**
     * 编码
     */
    private String code;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 类型 1：目录 2：页面 3：按钮
     */
    private Integer nodeType;
}
