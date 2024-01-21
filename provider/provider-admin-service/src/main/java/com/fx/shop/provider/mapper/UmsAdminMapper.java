package com.fx.shop.provider.mapper;

import com.fx.shop.provider.domain.UmsAdmin;
import tk.mybatis.mapper.MyMapper;

public interface UmsAdminMapper extends MyMapper<UmsAdmin> {

    Object selectDemo();

}
