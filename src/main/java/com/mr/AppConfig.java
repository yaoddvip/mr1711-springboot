package com.mr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by ydd on 2018/5/30.
 * 普通类变为启动类
 *  1：@SpringBootApplication
 *  2:添加 main方法
 *
 *  作用：
 *      可以扫描（当前包以及子包的注解）注解。
 */
@SpringBootApplication
@MapperScan("com.mr.mapper")
@EnableCaching  //开启 redis 注解
@EnableSwagger2 //开启swagger2
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class,args);
    }
}
