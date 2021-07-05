package com.yl.myshop.plus.business.service.impl;

import com.yl.myshop.plus.business.entity.TbPermission;
import com.yl.myshop.plus.business.mapper.TbPermissionMapper;
import com.yl.myshop.plus.business.service.TbPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限表(TbPermission)表服务实现类
 *
 * @author makejava
 * @since 2021-06-27 11:55:42
 */
@Service("tbPermissionService")
public class TbPermissionServiceImpl implements TbPermissionService {

    @Resource
    private TbPermissionMapper tbPermissionDao;

    @Override
    public List<TbPermission> getPermissionByUserId(Long userId) {
        return tbPermissionDao.getPermissionByUserId(userId);
    }
}
