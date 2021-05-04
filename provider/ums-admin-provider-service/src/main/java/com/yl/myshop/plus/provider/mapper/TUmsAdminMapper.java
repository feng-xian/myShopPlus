package com.yl.myshop.plus.provider.mapper;

import com.yl.myshop.plus.provider.entity.TUmsAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.BaseMapper;

import java.util.List;

/**
 * (TUmsAdmin)表数据库访问层
 *
 * @Author : 凤仙
 * @since 2021-05-02 14:43:22
 */
@Mapper
public interface TUmsAdminMapper extends BaseMapper<TUmsAdmin> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from t_ums_admin where id = 1")
    TUmsAdmin queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TUmsAdmin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tUmsAdmin 实例对象
     * @return 对象列表
     */
    List<TUmsAdmin> queryAll(TUmsAdmin tUmsAdmin);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUmsAdmin> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TUmsAdmin> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUmsAdmin> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TUmsAdmin> entities);

    /**
     * 修改数据
     *
     * @param tUmsAdmin 实例对象
     * @return 影响行数
     */
    int update(TUmsAdmin tUmsAdmin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

