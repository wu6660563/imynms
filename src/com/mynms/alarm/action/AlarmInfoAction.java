/*
 * @(#)AlarmInfoAction.java     v1.01, 2012-6-14
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.alarm.action;

import com.mynms.core.base.BaseAction;

/**
 * ClassName:   AlarmInfoAction.java
 * <p> {@link AlarmInfoAction} 告警信息的 {@link Action},
 * 用于处理告警信息页面展示的跳转。
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-6-14 下午12:12:23
 */
public class AlarmInfoAction extends BaseAction {

    /**
     * serialVersionUID:
     * <p>序列化Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -7758813397876060705L;

    /**
     * list:
     * <p>获取告警信息
     *
     * @return  {@link String}
     *          - 告警信息列表页面
     *
     * @since   v1.01
     */
    public String list() {
        executeAction("list");
        return "list";
    }
}

