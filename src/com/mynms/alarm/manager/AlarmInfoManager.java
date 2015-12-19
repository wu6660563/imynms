/*
 * @(#)AlarmInfoManager.java     v1.01, 2012-6-14
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.alarm.manager;

import java.util.List;

import com.mynms.alarm.model.AlarmInfo;
import com.mynms.alarm.service.AlarmInfoService;
import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;
import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.Result;
import com.mynms.core.base.BaseManager;

/**
 * ClassName:   AlarmInfoManager.java
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-6-14 下午12:09:36
 */
public class AlarmInfoManager extends BaseManager {

    /**
     * serialVersionUID:
     * <p>序列化Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = 870520375111723715L;

    /**
     * log:
     * <p>日志
     *
     * @since   v1.01
     */
    private static Log log = LogFactory.getLog(AlarmInfoManager.class);

    /**
     * alarmInfoService:
     * <p>{@link AlarmInfo} 的业务逻辑类
     *
     * @since   v1.01
     */
    private AlarmInfoService alarmInfoService;

    /**
     * list:
     * <p>处理告警信息的列表
     *
     * @since   v1.01
     */
    public void list() {
        Integer nodeId = getParameterAsInt("nodeId");
        String nodeType = getParameterAsString("nodeType");
        String[] propertyNames = null;
        Object[] values = null;
        if (nodeId != null && nodeType != null) {
            propertyNames = new String[] {"nodeId", "nodeType"};
            values = new Object[] {nodeId, nodeType};
        }
        AlarmInfoService alarmInfoService = getAlarmInfoService();
        Result<AlarmInfo> result = alarmInfoService.findByPage(propertyNames, values, createPageByParameter());
        List<AlarmInfo> list = result.getResultList();
        Page page = result.getPage();
        if (log.isDebugEnabled()) {
            log.debug("查询告警信息的列表数量为：" + list.size());
        }
        setAttribute("list", list);
        setAttribute("nodeId", nodeId);
        setAttribute("nodeType", nodeType);
        setAttribute("page", page);
    }

    /**
     * getAlarmInfoService:
     * <p>获取 {@link AlarmInfo} 的业务逻辑类
     *
     * @return  AlarmInfoService
     *          - {@link AlarmInfo} 的业务逻辑类
     * @since   v1.01
     */
    public AlarmInfoService getAlarmInfoService() {
        return alarmInfoService;
    }


    /**
     * setAlarmInfoService:
     * <p>设置 {@link AlarmInfo} 的业务逻辑类
     *
     * @param   alarmInfoService
     *          - {@link AlarmInfo} 的业务逻辑类
     * @since   v1.01
     */
    public void setAlarmInfoService(AlarmInfoService alarmInfoService) {
        this.alarmInfoService = alarmInfoService;
    }
}

