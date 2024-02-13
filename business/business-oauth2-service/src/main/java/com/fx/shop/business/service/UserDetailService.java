package com.fx.shop.business.service;

import com.alibaba.nacos.common.utils.JacksonUtils;
import com.alibaba.nacos.shaded.com.google.common.collect.Lists;
import com.fx.shop.business.domain.UserInfo;
import com.fx.shop.commons.util.JacksonUtil;
import com.fx.shop.provider.api.UmsAdminService;
import com.fx.shop.provider.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class UserDetailService implements UserDetailsService {

    @DubboReference(version = "umsAdminImpl")
    private UmsAdminService umsAdminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsAdmin umsAdmin = umsAdminService.getByUserName(username);

        if (Objects.isNull(umsAdmin)){
            throw new RuntimeException("用户不存在！");
        }

        // 授权信息
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();

        return new User(umsAdmin.getUsername(), umsAdmin.getPassword(), grantedAuthorities);
    }

}
