/*
 * @(#)Role.java     v1.01, 2012-5-1
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.system.model;

import java.util.HashSet;
import java.util.Set;

import com.mynms.core.base.BasePOJO;

/**
 * ClassName:   Role.java
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-23 下午08:13:25
 */
public class Role extends BasePOJO {

    // Fields

    /**
     * serialVersionUID:
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = 6072439087986773671L;

    /**
     * id:
     * <p>角色标示</p>
     *
     * @since   v1.01
     */
    private int id;

    /**
     * name:
     * <p>角色名</p>
     *
     * @since   v1.01
     */
    private String name;

    /**
     * level:
     * <p>等级</p>
     *
     * @since   v1.01
     */
    private int level;

    /**
     * fatherId:
     * <p>父角色标示</p>
     *
     * @since   v1.01
     */
    private int fatherId;

    /**
     * description:
     * <p>角色描述</p>
     *
     * @since   v1.01
     */
    private String description;

    /**
     * userRoles:
     * <p>属于该角色的用户集合</p>
     *
     * @since   v1.01
     */
    private Set<UserRole> userRoles = new HashSet<UserRole>(0);

    // Constructors

    /**
     * Role:
     * <p>默认的构造方法，构造一个新 {@link Role} 的实例</p>
     *
     * @since   v1.01
     */
    public Role() {
    }

    /**
     * getId:
     * <p>获取角色标示</p>
     *
     * @return  {@link Integer}
     *          - {@link Integer} 类型的角色标示
     * @since   v1.01
     */
    public int getId() {
        return id;
    }


    /**
     * setId:
     * <p>设置角色标示</p>
     *
     * @param   id
     *          - {@link Integer} 类型的角色标示
     * @since   v1.01
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * getName:
     * <p>获取角色名</p>
     *
     * @return  {@link String}
     *          - {@link String} 类型的角色名
     * @since   v1.01
     */
    public String getName() {
        return name;
    }


    /**
     * setName:
     * <p>设置角色名</p>
     *
     * @param   name
     *          - {@link String} 类型的角色名
     * @since   v1.01
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getLevel:
     * <p>获取等级</p>
     *
     * @return  {@link Integer}
     *          - {@link Integer} 类型的等级
     * @since   v1.01
     */
    public int getLevel() {
        return level;
    }

    /**
     * setLevel:
     * <p>设置等级</p>
     *
     * @param   level
     *          - {@link Integer} 类型的等级
     * @since   v1.01
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * getFatherId:
     * <p>获取父角色标示</p>
     *
     * @return  {@link Integer}
     *          - {@link Integer} 类型的父角色标示
     * @since   v1.01
     */
    public int getFatherId() {
        return fatherId;
    }


    /**
     * setFatherId:
     * <p>设置父角色标示</p>
     *
     * @param   fatherId
     *          - {@link Integer} 类型的父角色标示
     * @since   v1.01
     */
    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }


    /**
     * getDescription:
     * <p>获取角色描述</p>
     *
     * @return  {@link String}
     *          - {@link String} 类型的角色描述
     * @since   v1.01
     */
    public String getDescription() {
        return description;
    }


    /**
     * setDescription:
     * <p>设置角色描述</p>
     *
     * @param   description
     *          - {@link String} 类型的角色描述
     * @since   v1.01
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * getUserRoles:
     * <p>获取属于该角色的用户集合</p>
     *
     * @return  Set<UserRole>
     *          - {@link Set} 类型的属于该角色的用户集合
     * @since   v1.01
     */
    public Set<UserRole> getUserRoles() {
        return userRoles;
    }


    /**
     * setUserRoles:
     * <p>设置属于该角色的用户集合</p>
     *
     * @param   userRoles
     *          - {@link Set} 类型的属于该角色的用户集合
     * @since   v1.01
     */
    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }


    /**
     * toString:
     * <p>{@link Role} 实例的 {@link String} 表现形式。</p>
     *
     * @return  {@link String}
     *          - 返回 {@link Role} 实例的 {@link String} 表现形式。
     *
     * @since   v1.01
     * @see     com.mynms.core.base.BasePOJO#toString()
     */
    @Override
    public String toString() {
        return this.id + "\t" + this.name + "\t" + this.level + "\t"
                + this.fatherId + "\t" + this.description;
    }

}

