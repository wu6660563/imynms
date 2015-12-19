/*
 * @(#)DAOSupportFactory.java     v1.01, 2012-5-3
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core.base;

import java.io.Serializable;

import com.mynms.core.DAOSupport;

/**
 * ClassName:   DAOSupportFactory.java
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-5-3 下午04:10:24
 */
public final class DAOSupportFactory {

    /**
     * instance:
     * <p>静态的 {@link DAOSupportFactory} 实例</p>
     *
     * @since   v1.01
     */
    private static DAOSupportFactory instance;

    /**
     * defaultDAOSupport:
     *
     * @since   v1.01
     */
    private Class<DAOSupport<BasePOJO, Serializable>> defaultDAOSupport;

    /**
     * <p>创建一个新的 {@link DAOSupportFactory} 实例。
     * 由于该类使用单例模式，所以该方法为私有的。</p>
     *
     * @since   v1.01
     */
    private DAOSupportFactory() {
    }

    /**
     * getInstance:
     * <p>获取 {@link DAOSupportFactory} 的实例。</p>
     *
     * @return  {@link DAOSupportFactory}
     *          - {@link DAOSupportFactory} 实例
     * @since   v1.01
     */
    public static DAOSupportFactory getInstance() {
        if (instance == null) {
            instance = new DAOSupportFactory();
        }
        return instance;
    }

    /**
     * createDAOSupport:
     * <p>创建一个 {@link DAOSupport} 实例，如果没有设置
     * 默认的 {@link DAOSupport} 实现，则使用 {@link HibernateDAOSupportImpl}
     * 实现。</p>
     *
    * @return  {@link DAOSupport}
     *          - 创建的 {@link DAOSupport} 实例
     * @since   v1.01
     */
    public DAOSupport<BasePOJO, Serializable> createDAOSupport() {
        if (defaultDAOSupport != null) {
            return this.createDAOSupport(defaultDAOSupport);
        }
        return this.createHibernateDAOSupport();
    }

    /**
     * createDAOSupport:
     * <p>通过传入的 {@link Class<DAOSupport>} 对象，创建一个 {@link DAOSupport} 实例。</p>
     *
     * @param   clazz
     *          - {@link Class<DAOSupport>} 对象
     * @return  {@link DAOSupport}
     *          - 创建的 {@link DAOSupport} 实例
     * @since   v1.01
     */
    public DAOSupport<BasePOJO, Serializable> createDAOSupport(
                    Class<DAOSupport<BasePOJO, Serializable>> clazz) {
        DAOSupport<BasePOJO, Serializable> daoSupport = null;
        try {
            daoSupport = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return daoSupport;
    }

    /**
     * createHibernateDAOSupport:
     * <p>创建一个由  {@link HibernateDAOSupportImpl} 实现的
     * {@link DAOSupport} 实例。</p>
     *
     * @return  {@link DAOSupport}
     *          - 由  {@link HibernateDAOSupportImpl} 实现的 {@link DAOSupport} 实例。
     * @since   v1.01
     */
    public DAOSupport<BasePOJO, Serializable> createHibernateDAOSupport() {
        return new HibernateDAOSupportImpl<BasePOJO, Serializable>();
    }
}

