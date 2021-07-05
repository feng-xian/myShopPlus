package com.yl.myshop.plus.business.entity;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 角色表(TbRole)表实体类
 *
 * @author makejava
 * @since 2021-06-27 11:55:43
 */
@Data
@Accessors(chain = true)
@Table(name = "tb_role")
public class TbRole implements Serializable {

    private static final long serialVersionUID = -6003208573233736993L;

    @Id
    @Column(name = "id")
    private Long id;
    /**
     * 父角色
     */
    @Column(name = "parent_id")
    private Long parentId;
    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 角色英文名称
     */
    @Column(name = "enname")
    private String enname;
    /**
     * 备注
     */
    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;
}
