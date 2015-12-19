/*
 * @(#)TopologyMapRMIServerService.java     v1.01, 2012-8-1
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.rmi.server;

import java.util.List;

import com.afunms.rmi.service.RMIAttribute;
import com.afunms.rmi.service.RMIParameter;
import com.mynms.core.base.BaseRMIServerService;
import com.mynms.topology.dao.TopologyMapDAO;
import com.mynms.topology.model.TopologyMap;
import com.mynms.topology.service.TopologyMapService;

/**
 * ClassName:   TopologyMapRMIServerService.java
 * <p> {@link TopologyMapRMIServerService} 用户的远程调用服务类
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-8-1 下午06:06:37
 */
public class TopologyMapRMIServerService extends
                        BaseRMIServerService<TopologyMap,
                                            Integer,
                                            TopologyMapDAO,
                                            TopologyMapService> {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -7860337989353909465L;

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
        List<TopologyMap> list = (List<TopologyMap>)
                            parameter.getParameter("list");
        List<String[]> fileList = (List<String[]>)
                            parameter.getParameter("fileList");
        result = saveTopologyMapList(list);
        if (result) {
            result = saveTopologyMapFileList(fileList);
        }
        rmiAttribute.setAttribute("result", result);
        return rmiAttribute;
    }

    /**
     * saveTopologyMapList:
     * <p>保存拓扑图列表至数据库中
     *
     * @param   list
     *          - 拓扑图列表
     * @return  {@link Boolean}
     *          - 如果执行成功则返回 true, 否者返回 false
     *
     * @since   v1.01
     */
    private boolean saveTopologyMapList(List<TopologyMap> list) {
        boolean result = false;
        try {
            TopologyMapService service = getService();
            service.deleteAll();
            service.saveBatch(list);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * saveTopologyMapFileList:
     * <p>保存拓扑图文件
     *
     * @param   fileList
     *          - 拓扑图文件列表
     * @return  {@link Boolean}
     *          - 如果执行成功则返回 true, 否者返回 false
     *
     * @since   v1.01
     */
    private boolean saveTopologyMapFileList(List<String[]> fileList) {
        return getService().saveTopologyMapXMLFile(fileList);
    }
}

