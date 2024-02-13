package com.fx.shop.provider.mapper;

import com.fx.shop.provider.domain.UmsAdmin;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.Map;

public interface UmsAdminMapper extends MyMapper<UmsAdmin> {

    Object selectDemo();

    Map<String, Object> getUserInfoByUsername(@Param("username")String username);

}
