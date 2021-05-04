package com.yl.myshop.plus.provider.api;

import com.yl.myshop.plus.provider.entity.TUmsAdmin;

/**
 * 接口
 * @Author : 凤仙
 * @Date : 2021/5/3 10:56
 * @Version : 1.0
 */
public interface UmsAdminService {

    /**
     * 测试
     * @param say
     * @return
     */
    String helloTest(String say);

    /**
     * 注册
     * @return
     */
    int registeredUmsAdmin(TUmsAdmin tUmsAdmin);

    /**
     * 获取用户
     * @param username
     * @return admin {@link TUmsAdmin}
     */
    TUmsAdmin getAdmin(String username);

    /**
     * 获取用户
     * @param tUmsAdmin {@link TUmsAdmin}
     * @return admin {@link TUmsAdmin}
     */
    TUmsAdmin getAdmin(TUmsAdmin tUmsAdmin);

}
