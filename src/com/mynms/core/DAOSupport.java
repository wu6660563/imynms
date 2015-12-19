/*
 * @(#)DAOSupport.java     v1.01, 2012-5-3
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core;

import java.io.Serializable;

/**
 * ClassName:   DAOSupport.java
 * <p>{@link DAOSupport} 数据访问接口(Data Access Object) 支持接口，
 * 用于提供对 {@link DAO} 实例对数据库访问的支持，通过
 * {@link com.mynms.core.base.DAOSupportFactory} 类的工厂模式获取
 * {@link DAOSupport} 的实例。每个 {@link DAOSupport} 实例必须对
 * 数据库的操作负责，包括数据连接的获取和关闭。</p>
 * @param       <T>
 *              - 必须使用需要处理的 {@link POJO} 的实例作为参数传入。
 * @param       <K>
 *              - 必须使用需要处理的 {@link POJO} 的实例的主键作为参数传入，
 *                该参数类型必须实现序列化，为实例的主键类型。
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-5-3 下午04:10:24
 */
public interface DAOSupport<T extends POJO, K extends Serializable>
                    extends DAO<T, K> {

}

