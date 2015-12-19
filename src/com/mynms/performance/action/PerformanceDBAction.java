/*
 * @(#)PerformanceDBAction.java     v1.01, 2012-7-18
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.action;

import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;

/**
 * ClassName:   PerformanceDBAction.java
 * <p> {@link PerformanceDBAction} 数据库性能信息的 {@link Action} ，
 * 用于处理数据库性能信息页面展示的跳转。
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-7-18 下午09:21:50
 */
public class PerformanceDBAction extends PerformanceNodeAction {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since v1.01
     */
    private static final long serialVersionUID = -122852539933433920L;

    /**
     * log:
     * <p>日志
     *
     * @since v1.01
     */
    private static Log log = LogFactory.getLog(PerformanceDBAction.class);

    /**
     * list:
     * <p>获取数据库性能信息
     *
     * @return  {@link String}
     *          - 数据库性能信息列表页面
     * @since   v1.01
     */
    public String list() {
        if (log.isDebugEnabled()) {
            log.debug("获取数据库性能信息");
        }
        executeAction("list");
        return "list";
    }
}

