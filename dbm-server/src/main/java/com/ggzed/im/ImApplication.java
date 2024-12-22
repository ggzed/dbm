package com.ggzed.im;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类.
 *
 * @ClassName ImApplication
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ggzed.im.mapper")
public class ImApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImApplication.class, args);
    }

}
