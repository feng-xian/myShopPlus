package com.yl.myshop.plus.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author : 凤仙
 * @Date : 2021/5/4 11:05
 * @Version : 1.0
 */
@SpringBootApplication
@MapperScan(value = "com.yl.myshop.plus.business.mapper")
public class BusinessOAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(BusinessOAuth2Application.class, args);
    }

}
