/*
 * @(#)PerformanceDBInfoRMIServerService.java     v1.01, 2012-8-1
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.rmi.server;

import java.util.List;

import com.afunms.rmi.service.RMIAttribute;
import com.afunms.rmi.service.RMIParameter;
import com.mynms.core.base.BaseRMIServerService;
import com.mynms.performance.dao.PerformanceDBDAO;
import com.mynms.performance.model.PerformanceDBInfo;
import com.mynms.performance.service.PerformanceDBService;

/**
 * ClassName:   PerformanceDBInfoRMIServerService.java
 * <p> {@link PerformanceNetInfoRMIServerService} 数据库性能信息的远程调用服务类
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-8-1 下午06:54:38
 */
public class PerformanceDBInfoRMIServerService extends
                BaseRMIServerService<PerformanceDBInfo,
                                    Integer,
                                    PerformanceDBDAO,
                                    PerformanceDBService> {

    /**
     * serialVersionUID:
     * <p>
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = 1063819272475336733L;

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
            List<PerformanceDBInfo> list = (List<PerformanceDBInfo>)
                                parameter.getParameter("list");
            PerformanceDBService service = getService();
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

