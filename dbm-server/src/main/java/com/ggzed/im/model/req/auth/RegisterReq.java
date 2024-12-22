package com.ggzed.im.model.req.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author: ggzed
 * @date: 2024/2/21 17:39
 * @description:
 */
@Data
public class RegisterReq {
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;
}
