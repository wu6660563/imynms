/*
 * @(#)UserService.java     v1.01, 2011-9-20
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.system.service;

import java.util.List;

import com.mynms.core.base.BaseService;
import com.mynms.system.dao.UserDAO;
import com.mynms.system.model.User;

/**
 * ClassName:UserService {@link User} 逻辑服务类
 * <p>用于提供 {@link User} 的逻辑服务。</p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-20 下午03:22:54
 */
public class UserService extends BaseService<User, Integer, UserDAO> {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -7154625126749710070L;

    /**
     * getUser:
     * <p>通过用户名获取用户
     *
     * @param userName
     *          - 用户名
     * @return {@link User}
     *          - 用户
     * @since  v1.01
     */
    public User getUser(String userName) {
        UserDAO userDAO = getDAO();
        User user = userDAO.findByUserName(userName);
        return user;
    }

    /**
     * deleteAll:
     * <p>删除所有的 {@link User} 告警信息
     *
     * @since   v1.01
     */
    public void deleteAll() {
        UserDAO userDAO = getDAO();
        userDAO.deleteAll(User.class);
    }
    
    /**
     * saveBatch:
     * <p>批量保存 {@link User} 告警信息
     *
     * @param   entities
     *          - {@link User} 的集合
     *
     * @since   v1.01
     */
    public void saveBatch(List<User> entities) {
        UserDAO userDAO = getDAO();
        userDAO.saveBatch(entities);
    }
}

