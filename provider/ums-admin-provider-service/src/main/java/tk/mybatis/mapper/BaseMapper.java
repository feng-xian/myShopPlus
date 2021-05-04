package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author : 凤仙
 * @Date : 2021/5/3 11:16
 * @Version : 1.0
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
