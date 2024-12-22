package com.ggzed.im.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class SpringContextUtils  implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(Objects.isNull(SpringContextUtils.applicationContext)){
            log.info("=====>ApplicationUtils初始化...");
            SpringContextUtils.applicationContext = applicationContext;
        }
        log.info("=====>ApplicationUtils初始化成功!");
    }

    /**
     * 获得当前的ApplicationContext
     *
     * @author LiDong
     * @date 2020/11/20
     * @param '[]'
     * @return org.springframework.context.ApplicationContext
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 根据名称拿到Bean
     *
     * @author LiDong
     * @date 2020/11/20
     * @param '[name]'
     * @return java.lang.Object
     */
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    /**
     * 从ApplicationContext中获得Bean并且转型
     *
     * @author LiDong
     * @date 2020/11/20
     * @param '[tClass]'
     * @return T
     */
    public static <T> T getBean(Class<T> tClass){
        return getApplicationContext().getBean(tClass);
    }
}
