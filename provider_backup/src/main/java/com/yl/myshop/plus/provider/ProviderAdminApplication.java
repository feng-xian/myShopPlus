package com.yl.myshop.plus.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author : 凤仙
 * @Date : 2021/5/2 15:04
 * @Version : 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.yl.myshop.plus.provider.mapper")
public class ProviderAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderAdminApplication.class, args);
    }
}
