package com.fx.shop.provider.api;

import com.fx.shop.provider.domain.UmsAdmin;

import java.util.Map;

public interface UmsAdminService {

    int insertUmsAdmin(UmsAdmin umsAdmin);

    UmsAdmin getByUserName(String userName);

    Map<String, Object> getUserInfoMap(String userName);

}
