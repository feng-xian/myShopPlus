package com.yl.myshop.plus.provider.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author : YeLei
 * @Date : 2021/5/3 15:37
 * @Version : 1.0
 */
@Configuration
public class ResourceConfigure {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
