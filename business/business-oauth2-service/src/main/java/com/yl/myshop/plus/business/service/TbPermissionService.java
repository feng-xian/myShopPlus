package com.yl.myshop.plus.business.service;

import com.yl.myshop.plus.business.entity.TbPermission;

import java.util.List;

/**
 * 权限表(TbPermission)表服务接口
 *
 * @author makejava
 * @since 2021-06-27 11:55:42
 */
public interface TbPermissionService {

    /**
     * 通过用户id获取权限
     * @param userId 用户ID
     * @return 权限集合
     */
    List<TbPermission> getPermissionByUserId(Long userId);

}
