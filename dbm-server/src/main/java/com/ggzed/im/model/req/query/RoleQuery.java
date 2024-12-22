package com.ggzed.im.model.req.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: ggzed
 * @date: 2024/2/22 10:56
 * @description:
 */
@Data
public class RoleQuery {
    @ApiModelProperty(value = "名称")
    private String name;
}
