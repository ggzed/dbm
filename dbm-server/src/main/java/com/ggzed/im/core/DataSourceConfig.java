package com.ggzed.im.core;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;

//数据源默认配置类
@Configuration
//事务管理，数据库连接这里涉及到事务的提交
@EnableTransactionManagement
public class DataSourceConfig {
    // 动态注入数据库信息
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.dbtype}")
    private String dataType;

    // 创建DynamicDataSource的bean交给SpringIOC容器管理
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dataSource() {
        // 配置默认数据源
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setTestWhileIdle(false);
        datasource.setName("default");

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("defaultDataSource",datasource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        // 将该数据源设置成默认数据源
        dynamicDataSource.setDefaultTargetDataSource(datasource);
        return dynamicDataSource;
    }

}
