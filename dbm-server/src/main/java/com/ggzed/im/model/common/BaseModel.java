package com.ggzed.im.model.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 详细介绍类情况.
 *
 * @ClassName BaseModel
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模型的唯一标识，主键ID。
     */
    @TableId(value = "id_key", type = IdType.AUTO)
    private Long idKey;

    /**
     * 是否删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Byte isDeleted;

    /**
     * 模型的创建时间，插入时自动填充。
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 模型的更新时间，插入和更新时自动填充。
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;

    /**
     * 模型的创建人，插入时自动填充。
     */
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    /**
     * 模型的更新人，插入和更新时自动填充。
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

}
