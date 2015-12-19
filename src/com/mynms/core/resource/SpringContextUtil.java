/*
 * @(#)SpringContextUtil.java     v1.01, 2012-8-1
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core.resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.mynms.core.Service;

/**
 * ClassName:   SpringContextUtil.java
 * <p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-8-1 下午04:42:43
 */
public class SpringContextUtil implements ApplicationContextAware {

    public static ApplicationContext applicationContext;     //Spring应用上下文环境

    /**
     * setApplicationContext:
     *
     * @param arg0
     * @throws BeansException
     *
     * @since   v1.01
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    public void setApplicationContext(ApplicationContext applicationContext)
                    throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * getContext:
     * <p>获取<code>Spring</code>的上下文环境
     *
     * @return
     *
     * @since   v1.01
     */
    public static ApplicationContext setApplicationContext() {
        return applicationContext;
    }

    public synchronized static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    public synchronized static Object getBean(Class clazz) {
        return applicationContext.getBean(clazz);
    }
}

