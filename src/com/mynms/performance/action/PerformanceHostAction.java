/*
 * @(#)PerformanceHostAction.java     v1.01, 2012-7-18
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.action;

import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;

/**
 * ClassName:   PerformanceHostAction.java
 * <p> {@link PerformanceHostAction} 主机性能信息的 {@link Action} ，
 * 用于处理主机性能信息页面展示的跳转。
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-7-18 下午09:16:41
 */
public class PerformanceHostAction extends PerformanceNodeAction {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since v1.01
     */
    private static final long serialVersionUID = 5074726321837831302L;

    /**
     * log:
     * <p>日志
     *
     * @since v1.01
     */
    private static Log log = LogFactory.getLog(PerformanceHostAction.class);

    /**
     * list:
     * <p>获取主机性能信息
     *
     * @return  {@link String}
     *          - 主机性能信息列表页面
     * @since   v1.01
     */
    public String list() {
        if (log.isDebugEnabled()) {
            log.debug("获取主机性能信息");
        }
        executeAction("list");
        return "list";
    }
}

