/*
 * @(#)LoginAction.java     v1.01, 2011-9-2
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.login.action;

import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;
import com.mynms.core.base.BaseAction;

/**
 * ClassName:LoginAction
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-2 下午04:31:53
 *
 */
public class LoginAction extends BaseAction {

    /**
     * serialVersionUID:
     * <p>序列化 id</p>
     *
     * @since v1.01
     */
    private static final long serialVersionUID = -2004677867193500738L;

    /**
     * log:
     * <p>日志</p>
     *
     * @since v1.01
     */
    private static Log log = LogFactory.getLog(LoginAction.class);

    /**
     * login:
     * <p>处理登录请求。</p>
     *
     * @return {@link String}
     *          - 返回登录后的 index 页面
     * @since  v1.01
     */
    public String login() {
        // 调用 LoginManager 的 login 方法处理登录请求
        if (log.isDebugEnabled()) {
            log.debug("执行登录请求");
        }
        executeAction("login");
        return "home";
    }

    /**
     * home:
     * <p>处理返回首页。</p>
     *
     * @return {@link String}
     *          - 返回登录后的主页页面
     * @since  v1.01
     */
    public String home() {
        return "home";
    }

    /**
     * top:
     * <p>处理顶层页面。
     *
     * @return  {@link String}
     *          - 返回登录后的顶层页面
     *
     * @since   v1.01
     */
    public String top() {
        return "top";
    }

}

