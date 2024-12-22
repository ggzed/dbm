package com.ggzed.im.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ggzed.im.model.common.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * <p>
 * 表结构基本信息
 * </p>
 *
 * @author ggzed
 * @since 2024-02-20
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("dbm_table_info")
public class DbmTableInfo extends BaseModel {
    /**
     * 表名称
     */
    private String tableName;

    /**
     * 库名
     */
    private String tableSchema;

    /**
     * 注释
     */
    private String tableComment;

    /**
     * 创建时间
     */
    private String tableCreateDate;
}
