package com.ggzed.im.model.vo;

import lombok.Data;

import java.util.List;

/**
 * 权限信息
 */
@Data
public class PermissionInfoVo {
    private String userId;
    private String username;
    private String password;
    private String realName;
    private String avatar;
    private String desc;
    private String token;
    private List<String> auths;
    private List<String> modules;
    private int is_admin;
    private String role_name;
    private String mobile;
    private String lastLogin;
    private int role;
}
