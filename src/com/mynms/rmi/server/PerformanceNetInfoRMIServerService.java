/*
 * @(#)PerformanceNetInfoRMIServerService.java     v1.01, 2012-8-1
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.rmi.server;

import java.util.List;

import com.afunms.rmi.service.RMIAttribute;
import com.afunms.rmi.service.RMIParameter;
import com.mynms.core.base.BaseRMIServerService;
import com.mynms.performance.dao.PerformanceNetDAO;
import com.mynms.performance.model.PerformanceNetInfo;
import com.mynms.performance.service.PerformanceNetService;

/**
 * ClassName:   PerformanceNetInfoRMIServerService.java
 * <p> {@link PerformanceNetInfoRMIServerService} 网络设备性能信息的远程调用服务类
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-8-1 下午06:22:24
 */
public class PerformanceNetInfoRMIServerService extends
                BaseRMIServerService<PerformanceNetInfo,
                                    Integer,
                                    PerformanceNetDAO,
                                    PerformanceNetService> {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = 4888502145972946129L;

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
            List<PerformanceNetInfo> list = (List<PerformanceNetInfo>)
                                parameter.getParameter("list");
            PerformanceNetService service = getService();
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

