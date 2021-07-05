package com.yl.myshop.plus.business.entity;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户表(TbUser)表实体类
 *
 * @author makejava
 * @since 2021-06-27 11:55:44
 */
@Data
@Accessors(chain = true)
@Table(name = "tb_user")
public class TbUser implements Serializable{

    private static final long serialVersionUID = -3242738845841420607L;

    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码，加密存储
     */
    @Column(name = "password")
    private String password;

    /**
     * 注册手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 注册邮箱
     */
    @Column(name = "email")
    private String email;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;
}
