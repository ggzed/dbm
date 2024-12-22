package com.ggzed.im.model.req.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: ggzed
 * @date: 2024/2/22 14:42
 * @description:
 */
@Data
public class RoleEditReq {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "用户邮箱")
    private String code;

    @ApiModelProperty(value = "权限菜单")
    private List<Long> menus;

}
