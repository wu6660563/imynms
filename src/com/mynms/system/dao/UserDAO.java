/*
 * @(#)UserDAO.java     v1.01, 2011-9-17
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.system.dao;

import java.util.List;

import com.mynms.core.base.BaseDAO;
import com.mynms.system.model.User;

/**
 * ClassName:   RoleDAO.java
 * <p>{@link User} 的 {@link DAO} 类，用于提供 {@link User} 实例的对数据库的访问操作。</p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-17 下午04:09:35
 */
public class UserDAO extends BaseDAO<User, Integer> {

    /**
     * findByUserName:
     * <p>通过用户名查找用户</p>
     *
     * @param userName
     *          - 用户名
     * @return {@link User}
     *          - 用户
     * @throws DBException
     * @since  v1.01
     */
    public User findByUserName(String userName) {
        List<User> list = this.find(User.class,
                                      "userName",
                                      userName);
        User loginPOJO = null;
        if (list != null && list.size() > 0) {
            loginPOJO = list.get(0);
        }
        return loginPOJO;
    }
}

