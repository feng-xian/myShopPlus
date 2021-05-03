package com.yl.myshop.plus.provider.service;

import com.yl.myshop.plus.provider.api.UmsAdminService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Author : YeLei
 * @Date : 2021/5/3 10:57
 * @Version : 1.0
 */
@DubboService
public class UmsAdminServiceImpl implements UmsAdminService {

    @Override
    public String helloTest(String say) {
        return null;
    }
}
