package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 次接口不能被扫描到，否则会出错
 * @Author : 凤仙
 * @Date : 2021/5/26 21:22
 * @Version : 1.0
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
