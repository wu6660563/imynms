/*
 * @(#)LoginManager.java     v1.01, 2011-9-2
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.login.manager;

import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;
import com.mynms.core.base.BaseManager;
import com.mynms.system.model.User;
import com.mynms.system.service.UserService;

/**
 * ClassName:LoginManager 登录逻辑控制类
 * <p>
 * 用于提供登录的服务的逻辑控制。
 * </p>
 *
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2011-9-2 下午05:18:21
 *
 */
public class LoginManager extends BaseManager {

    /**
     * serialVersionUID:
     * 序列化ID
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = 7298717245653456015L;

    /**
     * 日志
     *
     * @since v1.01
     */
    private static Log log = LogFactory.getLog(LoginManager.class);

    /**
     * userService:用户服务
     *
     * @since v1.01
     */
    private UserService userService;

    /**
     * getUserService:
     * <p>
     * 获取 {@link UserService}
     * </p>
     *
     * @return {@link UserService} - 用户服务
     * @since v1.01
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * setUserService
     * <p>
     * 设置 {@link UserService}
     * </p>
     *
     * @param userService
     *            - 用户服务
     * @since v1.01
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * login:
     * <p>登录
     *
     * @since v1.01
     */
    public void login() {
        String userName = getParameterAsString("userName");
        String password = getParameterAsString("password");
        if (log.isDebugEnabled()) {
            log.debug("用户：" + userName + "登录，输入的密码为：" + password);
        }
        UserService userService = getUserService();
        User user = userService.getUser(userName);
        if (user == null) {
            log.debug("用户：" + userName + "不存在");
        } else if (!user.getPassword().equals(password)) {
            log.debug("输入的用户名密码不对，用户：" + user.getUserName() + "，正确密码为："
                            + user.getPassword());
        }
    }

    /**
     * home:
     * <p>首页显示的信息
     *
     *
     * @since   v1.01
     */
    public void home() {
        
    }
}
