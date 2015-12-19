/*
 * @(#)UserRole.java     v1.01, 2012-5-1
 *
 * Copyright (c) 2012, TNT All Rights Reserved.
 */

package com.mynms.system.model;

import com.mynms.core.base.BasePOJO;

/**
 * ClassName:   UserRole.java
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-23 下午08:13:25
 */
public class UserRole extends BasePOJO {

    // Fields

    /**
     * serialVersionUID:
     * <p>序列化ID</p>
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -8630924220138997180L;

    /**
     * id:
     * <p>标示</p>
     *
     * @since   v1.01
     */
    private int id;

    /**
     * user:
     * <p>用户</p>
     *
     * @since   v1.01
     */
    private User user;

    /**
     * role:
     * <p>角色</p>
     *
     * @since   v1.01
     */
    private Role role;

    /**
     * UserRole:
     * <p>默认的构造方法，构造一个新 {@link UserRole} 的实例</p>
     *
     * @since   v1.01
     */
    public UserRole() {
    }

    /**
     * getId:
     * <p>获取标示</p>
     *
     * @return  {@link Integer}
     *          - {@link Integer} 类型的标示
     * @since   v1.01
     */
    public int getId() {
        return id;
    }

    /**
     * setId:
     * <p>设置标示</p>
     *
     * @param   id
     *          - {@link Integer} 类型的标示
     * @since   v1.01
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getUser:
     * <p>获取对应的用户</>
     *
     * @return  {@link User}
     *          - {@link User} 类型的用户
     * @since   v1.01
     */
    public User getUser() {
        return user;
    }

    /**
     * setUser:
     * <p>设置对应的用户</>
     *
     * @param   user
     *          - {@link User} 类型的用户
     * @since   v1.01
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * getRole:
     * <p>获取对应的角色</>
     *
     * @return  {@link Role}
     *          - {@link Role} 类型的角色
     * @since   v1.01
     */
    public Role getRole() {
        return role;
    }

    /**
     * setRole:
     * <p>设置对应的角色</>
     *
     * @param   role
     *          - {@link Role} 类型的角色
     * @since   v1.01
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * toString:
     * <p>{@link UserRole} 实例的 {@link String} 表现形式。</p>
     *
     * @return  {@link String}
     *          - 返回 {@link UserRole} 实例的 {@link String} 表现形式。
     *
     * @since   v1.01
     * @see     com.mynms.core.base.BasePOJO#toString()
     */
    @Override
    public String toString() {
        return this.user.toString() + "\t" + role.toString();
    }
}

