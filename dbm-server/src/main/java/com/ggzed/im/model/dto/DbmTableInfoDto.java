package com.ggzed.im.model.dto;

import lombok.Data;

/**
 * @author: ggzed
 * @date: 2024/2/21 16:23
 * @description:
 */

@Data
public class DbmTableInfoDto {
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
    private String comments;

    /**
     * 创建时间
     */
    private String tableCreateDate;
}
