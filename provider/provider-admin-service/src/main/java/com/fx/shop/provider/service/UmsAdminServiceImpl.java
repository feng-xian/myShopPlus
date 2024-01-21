package com.fx.shop.provider.service;

import com.fx.shop.provider.api.UmsAdminService;
import com.fx.shop.provider.domain.UmsAdmin;
import com.fx.shop.provider.mapper.UmsAdminMapper;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.Objects;

@DubboService(version = "umsAdminImpl")
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public int insertUmsAdmin(UmsAdmin umsAdmin) {
        initUserInfo(umsAdmin);
        return umsAdminMapper.insert(umsAdmin);
    }

    @Override
    public UmsAdmin getByUserName(String userName) {

        Example example = new Example(UmsAdmin.class);
        example.createCriteria().andEqualTo("username", userName);

        return umsAdminMapper.selectOneByExample(example);
    }

    private void initUserInfo(UmsAdmin umsAdmin){

        umsAdmin.setLoginTime(new Date());
        umsAdmin.setLoginTime(new Date());

        if (Objects.isNull(umsAdmin.getStatus())){
            umsAdmin.setStatus(0);
        }

        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));

    }

}
