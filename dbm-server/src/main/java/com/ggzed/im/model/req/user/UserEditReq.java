package com.ggzed.im.model.req.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author: ggzed
 * @date: 2024/2/22 14:42
 * @description:
 */
@Data
public class UserEditReq {
    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private Integer avatar;

    @ApiModelProperty(value = "生日")
    private LocalDate birthday;

    @ApiModelProperty(value = "性别")
    private Byte sex;

    @ApiModelProperty(value = "介绍")
    private String shortIntroduce;

}
