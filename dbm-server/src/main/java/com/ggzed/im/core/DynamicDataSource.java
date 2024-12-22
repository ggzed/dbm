package com.ggzed.im.core;

import cn.hutool.core.util.StrUtil;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.reflect.Field;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态切换数据源具体实现类
 */
@EnableTransactionManagement
public class DynamicDataSource extends AbstractRoutingDataSource {
    // 通过ThreadLocal线程隔离的优势线程存储线程，当前线程只能操作当前线程的局部变量
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    // 把已有的数据源封装在Map里
    private Map<Object, Object> dynamicTargetDataSources = new HashMap<>();

    @Override
    protected Object determineCurrentLookupKey() {
        if (StrUtil.isEmpty(getDataSource())) {
            return "default";
        }
        return getDataSource();
    }

    // 设置默认数据源（必须要有，否则无法启动）
    @Override
    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
    }

    // 通过设置数据源
    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
    }
    // 获取数据源
    public static String getDataSource() {
        return contextHolder.get();
    }

    // 切换数据源,更改ThreadLocal中的局部变量
    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }

    // 删除数据源(每次切换数据源的时候都应先移除已有数据源)
    public static void clearDataSource() {
        contextHolder.remove();
    }


    /**
     * 创建一个新的数据源连接，并且设置此数据源为我们要用的数据源
     *
     * @param genConfig
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public boolean changeDataSource(GenConfig genConfig) throws NoSuchFieldException, IllegalAccessException {
        String url = genConfig.url;
        String driverClassName = genConfig.driverClassName;
        String username = genConfig.username;
        String password = genConfig.password;
        String dbtype = genConfig.dbtype;
        String dbName;
        if ("oracle".equals(dbtype)) {
            dbName = url.substring(url.lastIndexOf(":") + 1);
        } else {
            dbName = url.substring(url.lastIndexOf("/") + 1);
        }
        // 测试连接
        testConnection(driverClassName, url, username, password);

        // 通过Druid数据库连接池连接数据库
        DruidDataSource dataSource = new DruidDataSource();
        //接收前端传递的参数并且注入进去
        dataSource.setName(dbName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        // 设置最大连接等待时间
        dataSource.setMaxWait(4000);

        // 数据源初始化
        try {
            dataSource.init();
        } catch (SQLException e) {
            // 创建失败则抛出异常
            throw new RuntimeException();
        }
        //获取当前数据源的键值对存入Map
        this.dynamicTargetDataSources.put(dbtype, dataSource);
        // 设置数据源
        this.setTargetDataSources(this.dynamicTargetDataSources);
        // 解析数据源
        super.afterPropertiesSet();
        // 切换数据源
        setDataSource(dbtype);
        /*
         ** 修改mybatis的数据源
         * ！！！重要，不修改mybatis的数据源的话，
         * 即使切换了数据源之后还是会出现默认数据源的情况
         */
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) SpringContextUtils.getBean(SqlSessionFactory.class);
        Configuration configuration = sqlSessionFactory.getConfiguration();
        /*
         * ！！！重要，设置databaseId,用于在mapper.xml中找到对应的_databaseId,
         * 此处不设置databaseId，即使数据源切换了，但是在mapper.xml中还是对应不上
         */
        configuration.setDatabaseId(dbtype);
        Environment environment = configuration.getEnvironment();
        Field dataSourceField = environment.getClass().getDeclaredField("dataSource");
        //跳过检验
        dataSourceField.setAccessible(true);
        //修改mybatis的数据源
        dataSourceField.set(environment, dataSource);
        //修改完成后所有线程使用此数据源
        return true;
    }

    // 测试数据源连接的方法
    public void testConnection(String driveClass, String url, String username, String password) {
        try {
            Class.forName(driveClass);
            DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
