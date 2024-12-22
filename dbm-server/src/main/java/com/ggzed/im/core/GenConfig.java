package com.ggzed.im.core;

import lombok.Data;

@Data
public class GenConfig {
    /**
     * 项目地址
     */
    private String projectPath;

    /**
     * 作者
     */
    private String author;

    /**
     * 项目的包
     */
    private String projectPackage;

    /**
     * 核心模块的包
     */
    private String corePackage;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 忽略的表前缀
     */
    private String ignoreTabelPrefix;

    /**
     * 业务名称
     */
    private String bizName;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 父级菜单名称
     */
    private String parentMenuName;

    /**
     * driver-class
     */
    public String driverClassName;

    /**
     * 数据库url
     */
    public String url;

    /**
     * 数据库用户名
     */
    public String username;

    /**
     * 数据库密码
     */
    public String password;
    /**
     * 数据库类型：mysql、oracle、dm、kingbasees、h2、sqlserver、postgresql等
     */
    public String dbtype;
}
