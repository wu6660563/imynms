/*
 * @(#)RMIServerService.java     v1.01, 2012-8-1
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core;

import java.io.Serializable;

import com.afunms.rmi.service.RMIServerHandleAction;
import com.mynms.core.base.BasePOJO;

/**
 * ClassName:   RMIServerService.java
 * <p> {@link RMIServerService} 远程调用服务处理接口
 *
 * @param       <T>
 *              - 必须使用需要处理的 {@link POJO} 的实例作为参数传入。
 * @param       <K>
 *              - 必须使用需要处理的 {@link Serializable} 的子类的主键作为参数传入，
 *                该参数已经实现序列化，为实例的主键类型，保留字段，暂未使用。
 * @param       <D>
 *              - 必须使用需要处理的 {@link DAO} 的实例作为参数传入。
 * @param       <S>
 *              - 必须使用需要处理的 {@link Service} 的实例作为参数传入。
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-8-1 下午03:41:58
 */
public interface RMIServerService<T extends BasePOJO,
                            K extends Serializable,
                            D extends DAO<T, K>,
                            S extends Service<T, K, D>>
                    extends RMIServerHandleAction, Serializable {

    /**
     * getService:
     * <p>获取 {@link S} 业务逻辑服务实例
     *
     * @return  {@link S}
     *          - {@link S} 业务逻辑服务实例
     *
     * @since   v1.01
     */
    S getService();

    /**
     * setService:
     * <p>设置 {@link S} 业务逻辑服务实例
     *
     * @param   service
     *          - {@link S} 业务逻辑服务实例
     *
     * @since   v1.01
     */
    void setService(S service);

}

