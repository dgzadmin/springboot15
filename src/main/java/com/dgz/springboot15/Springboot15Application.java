package com.dgz.springboot15;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.dgz.springboot15.mapper")
@EnableCaching    //开启基于注解的缓存
public class Springboot15Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot15Application.class, args);
    }

}
