/*
 * @(#)InitializeListener.java     v1.01, 2011-9-23
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core.initialize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mynms.common.util.log.LogConfigurator;
import com.mynms.core.resource.SysResourceCenter;

/**
 * ClassName:InitializeListener 系统监听
 * <p>
 * 监听系统的初始化和销毁，当系统初始化时进行初始化配置。
 * </p>
 *
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2011-9-23 下午08:13:25
 */
public class InitializeListener implements ServletContextListener {

    /**
     * 日志配置文件
     *
     * @since v1.01
     */
    private static String logPropertiesFile =
        "WEB-INF/classes/log4j.properties";

    /**
     * 系统初始化类
     *
     * @since v1.01
     */
    private SystemInitialize systemInitialize;

    /**
     * contextDestroyed:
     * <p>
     * 系统销毁
     * </p>
     *
     * @param arg0
     *            - {@link ServletContextEvent}
     * @since v1.01
     * @see javax.servlet.ServletContextListener#
     *      contextDestroyed(javax.servlet.ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    /**
     * contextInitialized:
     * <p>
     * 系统启动，当系统启动时，调用系统初始化，进行初始化配置
     * </p>
     *
     * @param arg0
     *            - {@link ServletContextEvent}
     * @since v1.01
     * @see javax.servlet.ServletContextListener#contextInitialized
     *      (javax.servlet.ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        String sysPath = arg0.getServletContext().getRealPath("/");
        System.out.println("系统路径为：" + sysPath);
        System.out.println("日志路径为：" + sysPath + logPropertiesFile);
        // 为log4j设置系统路径
        System.setProperty("sysPath", sysPath);
        Properties logProperties = new Properties();
        try {
            logProperties.load(new FileReader(new File(sysPath
                            + logPropertiesFile)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogConfigurator.config("com.mynms.common.util.log.impl.Log4jLogger",
                        logProperties);
        // 给系统资源中心设置系统路径
        SysResourceCenter.getInstance().setSysPath(sysPath);
        systemInitialize = new SystemInitialize();
        systemInitialize.init();
    }

}
