/*
 * @(#)PerformanceEnvAction.java     v1.01, 2012-7-23
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.action;

import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;

/**
 * ClassName:   PerformanceEnvAction.java
 * <p> {@link PerformanceEnvAction} 主机性能信息的 {@link Action} ，
 * 用于处理主机性能信息页面展示的跳转。
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-7-23 下午02:54:28
 */
public class PerformanceEnvAction extends PerformanceNodeAction {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -8220692661664307034L;

    /**
     * log:
     * <p>日志
     *
     * @since v1.01
     */
    private static Log log = LogFactory.getLog(PerformanceEnvAction.class);

    /**
     * list:
     * <p>获取机房环境信息
     *
     * @return  {@link String}
     *          - 机房环境信息列表页面
     * @since   v1.01
     */
    public String list() {
        if (log.isDebugEnabled()) {
            log.debug("获取机房环境信息");
        }
        executeAction("list");
        return "list";
    }
}

