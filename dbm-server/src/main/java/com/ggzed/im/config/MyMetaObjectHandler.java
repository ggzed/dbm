package com.ggzed.im.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ggzed.im.common.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: ggzed
 * @date: 2024/2/21 18:06
 * @description: mybatis-plus设置默认字段
 */
@Configuration
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 属性名称，不是字段名称
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("isDeleted", Constants.NOT_DELETED,metaObject);
        this.setFieldValByName("creator","sys",metaObject);
        this.setFieldValByName("updater","",metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("updater","sys",metaObject);
    }
}
