/*
 * @(#)AlarmInfoRMIServerService.java     v1.01, 2012-7-30
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.rmi.server;

import java.util.List;

import com.afunms.rmi.service.RMIAttribute;
import com.afunms.rmi.service.RMIParameter;
import com.mynms.alarm.dao.AlarmInfoDAO;
import com.mynms.alarm.model.AlarmInfo;
import com.mynms.alarm.service.AlarmInfoService;
import com.mynms.core.base.BaseRMIServerService;

/**
 * ClassName:   AlarmInfoRMIServerService.java
 * <p> {@link AlarmInfoRMIServerService} 告警信息的远程调用服务类
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-7-30 下午06:20:19
 */
public class AlarmInfoRMIServerService extends
                            BaseRMIServerService<AlarmInfo,
                                                Integer,
                                                AlarmInfoDAO,
                                                AlarmInfoService> {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -2097860104521297729L;

    /**
     * execute:
     * <p>执行远程调用服务
     *
     * @param   parameter
     *          - {@link RMIParameter} 远程调用传过来的参数
     * @return  {@link RMIAttribute}
     *          - {@link RMIAttribute} 远程调用完成后返回的参数
     *
     * @since   v1.01
     * @see com.afunms.rmi.service.RMIServerHandleAction#
     *                  execute(com.afunms.rmi.service.RMIParameter)
     */
    @SuppressWarnings("unchecked")
    public RMIAttribute execute(RMIParameter parameter) {
        boolean result = false;
        RMIAttribute rmiAttribute = new RMIAttribute();
        try {
            List<AlarmInfo> list = (List<AlarmInfo>)
                                parameter.getParameter("list");
            AlarmInfoService service = getService();
            service.deleteAll();
            service.saveBatch(list);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        rmiAttribute.setAttribute("result", result);
        return rmiAttribute;
    }

}

