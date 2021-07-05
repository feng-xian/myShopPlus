package com.yl.myshop.plus.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author : 凤仙
 * @Date : 2021/5/3 10:34
 * @Version : 1.0
 */
@SpringBootApplication
@MapperScan("com.yl.myshop.plus.provider.mapper")
public class ProviderAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderAdminApplication.class, args);
    }
}
