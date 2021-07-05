package com.yl.myshop.plus.business.service.impl;

import com.yl.myshop.plus.business.entity.TbUser;
import com.yl.myshop.plus.business.mapper.TbUserMapper;
import com.yl.myshop.plus.business.service.TbUserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * 用户表(TbUser)表服务实现类
 *
 * @author makejava
 * @since 2021-06-27 11:55:45
 */
@Service("tbUserService")
public class TbUserServiceImpl  implements TbUserService {

    @Resource
    private TbUserMapper tbUserDao;

    @Override
    public TbUser getUserByUsername(String username) {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username", username);
        TbUser tbUser = tbUserDao.selectOneByExample(example);
        return tbUser;
    }
}
