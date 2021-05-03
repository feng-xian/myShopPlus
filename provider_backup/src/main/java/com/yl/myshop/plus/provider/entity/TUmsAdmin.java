package com.yl.myshop.plus.provider.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;
import java.io.Serializable;

/**
 * (TUmsAdmin)实体类
 *
 * @author makejava
 * @since 2021-05-02 14:43:15
 */
@Data
@Table(name = "t_ums_admin")
public class TUmsAdmin implements Serializable {

    private static final long serialVersionUID = -69986771655063022L;

    @Column(name = "id")
    private Long id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "name")
    private String name;

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
     * 待定
     */
    @Column(name = "status")
    private Integer status;


}
