package com.yl.myshop.plus.business.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author : 凤仙
 * @Date : 2021/7/15 15:20
 * @Version : 1.0
 */
@Data
@Accessors(chain = true)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 2532724995534867319L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;
}
