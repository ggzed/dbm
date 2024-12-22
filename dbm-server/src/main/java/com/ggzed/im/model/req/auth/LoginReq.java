package com.ggzed.im.model.req.auth;

import lombok.Data;

/**
 * 详细介绍类情况.
 *
 * @ClassName LoginReq
 * @Author ggzed
 * @Date 2024/2/5
 * @Version 1.0
 */
@Data
public class LoginReq {
    private String username;
    private String password;
}