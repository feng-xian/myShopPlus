package com.yl.myshop.plus.business.configure.service;

import com.google.common.collect.Lists;
import com.yl.myshop.plus.business.entity.TbPermission;
import com.yl.myshop.plus.business.entity.TbUser;
import com.yl.myshop.plus.business.service.TbPermissionService;
import com.yl.myshop.plus.business.service.TbUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : YeLei
 * @Date : 2021/5/4 11:17
 * @Version : 1.0
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private TbUserService userService;

    @Resource
    private TbPermissionService permissionService;

    private static final String USERNAME = "admin";

    private static final String PASSWORD = "$2a$10$X30aCoiMsCHHERgwEw2H7.NPM3AYAL2WzMq.Xjn87fFEdJNdgOd7e";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (true){
            ArrayList<GrantedAuthority> grantedAuthList = Lists.newArrayList();
            return new User(USERNAME, PASSWORD, grantedAuthList);
        }

        TbUser tbUser = userService.getUserByUsername(username);
        if (null == tbUser){
            return null;
        }

        ArrayList<GrantedAuthority> grantedAuthList = Lists.newArrayList();
        List<TbPermission> permissionList = permissionService.getPermissionByUserId(tbUser.getId());
        permissionList.forEach(permission -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnname());
            grantedAuthList.add(grantedAuthority);
        });

        return new User(tbUser.getUsername(),tbUser.getPassword(), grantedAuthList);
    }
}
