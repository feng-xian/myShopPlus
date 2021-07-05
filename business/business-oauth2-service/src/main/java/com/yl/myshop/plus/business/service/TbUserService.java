package com.yl.myshop.plus.business.service;

import com.yl.myshop.plus.business.entity.TbUser;

/**
 * 用户表(TbUser)表服务接口
 *
 * @author makejava
 * @since 2021-06-27 11:55:45
 */
public interface TbUserService {

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return TbUser {@link TbUser}
     */
    TbUser getUserByUsername(String username);

}
