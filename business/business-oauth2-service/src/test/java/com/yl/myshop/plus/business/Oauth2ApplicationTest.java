package com.yl.myshop.plus.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author : 凤仙
 * @Date : 2021/5/4 11:19
 * @Version : 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Oauth2ApplicationTest {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void generatePassword(){
        String psw = passwordEncoder.encode("123456");
        System.out.println(psw);
    }

}
