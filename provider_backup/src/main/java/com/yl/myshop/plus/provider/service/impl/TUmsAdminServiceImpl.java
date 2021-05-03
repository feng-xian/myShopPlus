package com.yl.myshop.plus.provider.service.impl;

import com.yl.myshop.plus.provider.entity.TUmsAdmin;
import com.yl.myshop.plus.provider.mapper.TUmsAdminDao;
import com.yl.myshop.plus.provider.service.TUmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (TUmsAdmin)表服务实现类
 *
 * @author makejava
 * @since 2021-05-02 14:43:32
 */
@Service
public class TUmsAdminServiceImpl implements TUmsAdminService {

    @Autowired
    private TUmsAdminDao tUmsAdminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUmsAdmin queryById(Long id) {
        return this.tUmsAdminDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TUmsAdmin> queryAllByLimit(int offset, int limit) {
        return this.tUmsAdminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tUmsAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public TUmsAdmin insert(TUmsAdmin tUmsAdmin) {
        this.tUmsAdminDao.insert(tUmsAdmin);
        return tUmsAdmin;
    }

    /**
     * 修改数据
     *
     * @param tUmsAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public TUmsAdmin update(TUmsAdmin tUmsAdmin) {
        this.tUmsAdminDao.update(tUmsAdmin);
        return this.queryById(tUmsAdmin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tUmsAdminDao.deleteById(id) > 0;
    }
}
