/*
 * @(#)SystemInitialize.java     v1.01, 2011-9-23
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.core.initialize;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import com.afunms.rmi.service.RMIServerHandleActionConfig;
import com.afunms.rmi.service.RMIServerHandleActionService;
import com.afunms.rmi.service.RMIServerService;
import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;
import com.mynms.common.util.xml.XMLPrasingUtil;
import com.mynms.core.resource.SysResourceCenter;

/**
 * ClassName:SystemInitialize
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-23 下午08:10:34
 */
public class SystemInitialize {

    /**
     * sysPath:
     * <p>系统路径
     *
     * @since   v1.01
     */
    private static final String SYS_PATH =
                        SysResourceCenter.getInstance().getSysPath();

    /**
     * log:
     * <p>远程调用配置文件
     *
     * @since v1.01
     */
    private static final String RMI_XML = SYS_PATH + "/WEB-INF/config/system/rmi.xml";

    /**
     * log:
     * <p>日志</p>
     *
     * @since v1.01
     */
    private static Log log = LogFactory.getLog(SystemInitialize.class);

    /**
     * init:
     * <p>进行系统初始化配置。</p>
     *
     * @return {@link Boolean}
     *          - 系统初始化是否成功
     * @since  v1.01
     */
    public boolean init() {
        log.debug("开始系统初始化配置！！！");
        initRMI();
        return false;
    }

    /**
     * initRMI:
     * <p>初始化远程调用
     *
     * @since   v1.01
     */
    private void initRMI() {
        try {
            List<RMIServerHandleActionConfig> serverHandleActionConfigList =
                            new ArrayList<RMIServerHandleActionConfig>();
            XMLPrasingUtil xmlPrasingUtil =
                            new XMLPrasingUtil(RMI_XML);
            String host = null;
            String port = null;
            String name = null;
            String serviceClass = null;
            // 主机IP
            host = xmlPrasingUtil.getElementText("host");
            // 端口
            port = xmlPrasingUtil.getElementText("port");
            // 名称
            name = xmlPrasingUtil.getElementText("name");
            // 名称
            serviceClass = xmlPrasingUtil.getElementText("serviceClass");
            @SuppressWarnings("unchecked")
            List<Element> list = xmlPrasingUtil.getElement("actions").elements("action");
            for (Element element : list) {
                String action = element.elementTextTrim("name");
                String actionClassName = element.elementTextTrim("class");
                RMIServerHandleActionConfig serverHandleActionConfig =
                                new RMIServerHandleActionConfig();
                serverHandleActionConfig.setName(action);
                serverHandleActionConfig.setRMIServerHandleActionClassName(
                                actionClassName);
                serverHandleActionConfigList.add(serverHandleActionConfig);
            }
            RMIServerHandleActionService.getInstance()
                        .addRMIServerHandleAction(serverHandleActionConfigList);
            RMIServerService service = RMIServerService.getInstance();
            if (host == null || "".equals(host)) {
                InetAddress addr = InetAddress.getLocalHost();
                host = addr.getHostAddress().toString();
            }
            System.setProperty("java.rmi.server.hostname", host);
            service.init(host, Integer.valueOf(port), name, serviceClass);
            service.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

