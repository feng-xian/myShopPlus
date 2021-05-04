package com.yl.myshop.plus.provider.service;

import com.yl.myshop.plus.provider.entity.TUmsAdmin;

import java.util.List;

/**
 * (TUmsAdmin)表服务接口
 *
 * @Author : 凤仙
 * @since 2021-05-02 14:43:30
 */
public interface TUmsAdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUmsAdmin queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TUmsAdmin> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tUmsAdmin 实例对象
     * @return 实例对象
     */
    TUmsAdmin insert(TUmsAdmin tUmsAdmin);

    /**
     * 修改数据
     *
     * @param tUmsAdmin 实例对象
     * @return 实例对象
     */
    TUmsAdmin update(TUmsAdmin tUmsAdmin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
