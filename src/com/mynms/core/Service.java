/*
 * @(#)Service.java     v1.01, 2011-9-2
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.core;

import java.io.Serializable;


/**
 * ClassName:Service
 * <p>{@link Service} 业务逻辑服务接口，
 * 为上层业务逻辑控制 {@link Manager} 提供服务。</p>
 * <p>由于 {@link Service} 为最小业务逻辑单元，
 * 事务隔离级别定为 {@link Service} 层的方法级别，该类的每个方法都为一个事务处理单元，
 * 所以该类在运行过程中在事务处理失败时可能会向上层抛出异常。
 * 注：所有对于调用 {@link Service} 中的方法都应该捕获异常，当处理事务失败的情形。</p>
 *
 * @param       <T>
 *              - 必须使用需要处理的 {@link POJO} 的实例作为参数传入。
 * @param       <K>
 *              - 必须使用需要处理的 {@link POJO} 的实例的主键作为参数传入，
 *                该参数已经实现序列化，为实例的主键类型，保留字段，暂未使用。
 * @param       <D>
 *              - 必须使用需要处理的 {@link DAO} 的实例的主键作为参数传入。
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-2 下午02:31:28
 *
 */
public interface Service<T extends POJO,
                    K extends Serializable, D extends DAO<T, K>> 
                    extends Serializable {

    /**
     * getDAO:
     * <p>获取数据访问类
     *
     * @return  {@link D}
     *          - {@link D} 类型的数据访问类
     *
     * @since   v1.01
     * @see     com.mynms.core.Service#getDAO()
     */
    D getDAO();

    /**
     * setDAO:
     * <p>设置数据访问类
     *
     * @param   DAO
     *          - {@link D} 类型的数据访问类
     *
     * @since   v1.01
     */
    void setDAO(D DAO);
}

