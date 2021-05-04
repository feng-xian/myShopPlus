package com.yl.myshop.plus.provider.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.io.Serializable;

/**
 * (TUmsAdmin)实体类
 *
 * @Author : 凤仙
 * @since 2021-05-02 14:43:15
 */
@Data
@Table(name = "t_ums_admin")
public class TUmsAdmin implements Serializable {

    private static final long serialVersionUID = -69986771655063022L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    /**
     * 0:女，1：男
     */
    @Column(name = "sex")
    private Integer sex;

    @Column(name = "phone")
    private String phone;

    @Column(name = "id_card")
    private String idCard;

    /**
     * 0:未启用，1：已启用
     */
    @Column(name = "status")
    private Integer status;

    @Column(name = "login_date")
    private Date loginDate;

    @Column(name = "password")
    private String password;


}
