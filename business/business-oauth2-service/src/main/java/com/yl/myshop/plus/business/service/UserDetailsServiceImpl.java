package com.yl.myshop.plus.business.service;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @Author : YeLei
 * @Date : 2021/5/4 11:17
 * @Version : 1.0
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String USERNAME = "TEST";

    private static final String PASSWORD = "$2a$10$sCqNaUbnIZydXOrTAG73uOvIC.08qWhWDFUqh/5wjuAiftBUGuwQu";

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        return new User(USERNAME, PASSWORD, grantedAuthorities);
    }
}
