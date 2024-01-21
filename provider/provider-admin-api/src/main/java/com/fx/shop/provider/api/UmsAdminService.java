package com.fx.shop.provider.api;

import com.fx.shop.provider.domain.UmsAdmin;

public interface UmsAdminService {

    int insertUmsAdmin(UmsAdmin umsAdmin);

    UmsAdmin getByUserName(String userName);

}
