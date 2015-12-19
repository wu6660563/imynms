/*
 * @(#)TopologyMapService.java     v1.01, 2012-6-21
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.topology.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.Result;
import com.mynms.core.base.BaseService;
import com.mynms.core.resource.SysResourceCenter;
import com.mynms.topology.dao.TopologyMapDAO;
import com.mynms.topology.model.TopologyMap;

/**
 * ClassName:   TopologyMapService.java
 * <p>拓扑图 {@link TopologyMap} 的业务逻辑类。
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-6-21 上午11:30:40
 */
public class TopologyMapService extends
                BaseService<TopologyMap, Integer, TopologyMapDAO> {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -1177090765416230320L;

    /**
     * TOPOLOGY_MAP_XML_PATH:
     * <p>拓扑图文件的路径
     *
     * @since   v1.01
     */
    private static final String TOPOLOGY_MAP_XML_PATH =
        SysResourceCenter.getInstance().getSysPath() + "/resource/xml/";

    /**
     * findByPage:
     * <p>通过 {@link Page} 对象，分页查询拓扑图 {@link TopologyMap} 的列表
     *
     * @param   page
     *          - {@link Page} 对象
     * @return  {@link Result<TopologyMap>}
     *          - 返回查询后的结果
     *
     * @since   v1.01
     */
    public Result<TopologyMap> findByPage(Page page) {
        TopologyMapDAO dao = getDAO();
        return dao.findByPage(TopologyMap.class, page);
    }

    /**
     * findById:
     * <p>根据 <code>id</code> 获取拓扑图对象。
     *
     * @param   id
     *          - {@link Integer} 类型的Id
     * @return  {@link TopologyMap}
     *          - 拓扑图对象
     *
     * @since   v1.01
     */
    public TopologyMap findById(Integer id) {
        TopologyMapDAO dao = getDAO();
        return dao.get(TopologyMap.class, id);
    }

    /**
     * findByXmlName:
     * <p>根据 <code>xmlName</code> 获取拓扑图对象。
     *
     * @param   xmlName
     *          - {@link String} 类型的xmlName
     * @return  {@link TopologyMap}
     *          - 拓扑图对象
     *
     * @since   v1.01
     */
    public TopologyMap findByXmlName(String xmlName) {
        TopologyMapDAO dao = getDAO();
        List<TopologyMap> list = dao.find(TopologyMap.class, "xmlName", xmlName);
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
        
    }

    /**
     * deleteAll:
     * <p>删除所有的 {@link TopologyMap} 告警信息
     *
     * @since   v1.01
     */
    public void deleteAll() {
        TopologyMapDAO dao = getDAO();
        dao.deleteAll(TopologyMap.class);
    }
    
    /**
     * saveBatch:
     * <p>批量保存 {@link TopologyMap} 告警信息
     *
     * @param   entities
     *          - {@link TopologyMap} 的集合
     *
     * @since   v1.01
     */
    public void saveBatch(List<TopologyMap> entities) {
        TopologyMapDAO dao = getDAO();
        dao.saveBatch(entities);
    }

    /**
     * saveTopologyMapXMLFile:
     * <p>保存拓扑图文件
     *
     * @param   list
     *          - 拓扑图文件列表
     * @return  {@link Boolean}
     *          - 如果执行成功则返回 true, 否者返回 false
     *
     * @since   v1.01
     */
    public boolean saveTopologyMapXMLFile(List<String[]> list) {
        boolean result = false;
        try {
            for (String[] topologyMap : list) {
                String fileName = topologyMap[0];
                String fileContent = topologyMap[1];
                System.out.println(TOPOLOGY_MAP_XML_PATH + fileName);
                File file = new File(TOPOLOGY_MAP_XML_PATH + fileName);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                BufferedWriter bufferedWriter = new BufferedWriter(
                                new PrintWriter(file));
                bufferedWriter.write(fileContent);
                bufferedWriter.flush();
                bufferedWriter.close();
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

