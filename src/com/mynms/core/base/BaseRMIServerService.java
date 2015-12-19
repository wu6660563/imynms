/*
 * @(#)BaseRMIServerService.java     v1.01, 2012-8-1
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.mynms.core.RMIServerService;
import com.mynms.core.resource.SpringContextUtil;

/**
 * ClassName:   BaseRMIServerService.java
 * <p> {@link BaseRMIServerService} 基础的远程调用服务处理类，
 * 用于完成获取<code>Spring</code>容器中的 {@link Service} 实例
 *
 * @param       <T>
 *              - 必须使用需要处理的 {@link BasePOJO} 的子类作为参数传入。
 * @param       <K>
 *              - 必须使用需要处理的 {@link Serializable} 的子类的主键作为参数传入，
 *                该参数已经实现序列化，为实例的主键类型，保留字段，暂未使用。
 * @param       <D>
 *              - 必须使用需要处理的 {@link BaseDAO} 的实例作为参数传入。
 * @param       <S>
 *              - 必须使用需要处理的 {@link BaseService} 的实例作为参数传入。
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-8-1 下午03:44:01
 */
public abstract class BaseRMIServerService<T extends BasePOJO,
                                    K extends Serializable,
                                    D extends BaseDAO<T, K>,
                                    S extends BaseService<T, K, D>>
                            implements RMIServerService<T, K, D, S> {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = 6453598547851995229L;

    /**
     * service:
     * <p> {@link S} 业务逻辑服务实例
     *
     * @since   v1.01
     */
    protected S service;

    /**
     * BaseRMIServerService:
     * <p>默认的构造方法，构造一个新的 BaseRMIServerService 的实例
     *
     * @since   v1.01
     */
    @SuppressWarnings("unchecked")
    public BaseRMIServerService() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments(); 
        if (params != null) {
            for (Type type : params) {
                System.out.println((Class<T>)type);
            }
            Class<T> clazz = (Class<T>) params[3];
            System.out.println(clazz.getCanonicalName());
            S service = (S) SpringContextUtil.getBean(clazz);
            setService(service);
        }
    }

    // Getter And Setter

    /**
     * getService:
     * <p>获取 {@link S} 业务逻辑服务实例
     *
     * @return  {@link S}
     *          - {@link S} 业务逻辑服务实例
     *
     * @since   v1.01
     * @see com.mynms.core.Manager#getService()
     */
    public S getService() {
        return service;
    }

    /**
     * setService:
     * <p>设置 {@link S} 业务逻辑服务实例
     *
     * @param   service
     *          - {@link S} 业务逻辑服务实例
     *
     * @since   v1.01
     * @see com.mynms.core.Manager#setService(com.mynms.core.Service)
     */
    public void setService(S service) {
        this.service = service;
    }
}

