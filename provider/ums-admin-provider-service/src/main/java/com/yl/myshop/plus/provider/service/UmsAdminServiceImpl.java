package com.yl.myshop.plus.provider.service;

import com.yl.myshop.plus.provider.api.UmsAdminService;
import com.yl.myshop.plus.provider.entity.TUmsAdmin;
import com.yl.myshop.plus.provider.mapper.TUmsAdminMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author : 凤仙
 * @Date : 2021/5/3 10:57
 * @Version : 1.0
 */
@DubboService
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private TUmsAdminMapper tUmsAdminMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String helloTest(String say) {
        return "helloTest "+ say;
    }

    @Override
    public int registeredUmsAdmin(TUmsAdmin tUmsAdmin) {
        initTumsAdmin(tUmsAdmin);
        int row = tUmsAdminMapper.insert(tUmsAdmin);
        return row;
    }

    @Override
    public TUmsAdmin getAdmin(String username) {
        Example example = new Example(TUmsAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        TUmsAdmin admin = tUmsAdminMapper.selectOneByExample(example);
        return admin;
    }

    @Override
    public TUmsAdmin getAdmin(TUmsAdmin tUmsAdmin) {
        TUmsAdmin admin = tUmsAdminMapper.selectOne(tUmsAdmin);
        return admin;
    }

    public void initTumsAdmin(TUmsAdmin tUmsAdmin){
        if (null == tUmsAdmin.getStatus()){
            tUmsAdmin.setStatus(0);
        }

        tUmsAdmin.setCreateDate(new Date());
        tUmsAdmin.setUpdateDate(new Date());
        tUmsAdmin.setLoginDate(new Date());
        tUmsAdmin.setPassword(passwordEncoder.encode(tUmsAdmin.getPassword()));
    }
}
