/*
 * @(#)Manager.java     v1.01, 2011-8-31
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.core;

import java.io.Serializable;
import java.util.Enumeration;

/**
 * ClassName:Manager
 * <p>{@link Manager} 业务逻辑控制接口，通过控制和调用下层
 * 的业务服务 {@link Service} 的具体类来处理上层的业务请求。</p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-8-31 下午05:26:46
 */
public interface Manager extends Serializable {

    /**
     * getAttribute:
     * <p>获取名称为 <code>name</code> 的属性值，
     * 如果不存在以 <code>name</code> 为名称的属性，则返回 <code>null</code> 。
     *
     * @param   name
     *          - {@link String} 类型的属性名称
     * @return  {@link Object}
     *          - {@link Object} 类型的属性对象
     *
     * @since   v1.01
     * @see     #setAttribute(String, Object)
     * @see     #removeAttribute(String)
     */
    Object getAttribute(String name);

    /**
     * getAttributeNames:
     * <p>获取属性名称的枚举 {@link Enumeration<String>}</p>
     *
     * @return  {@link Enumeration<String>}
     *          - 属性名称的枚举 {@link Enumeration<String>}
     * @since   v1.01
     */
    Enumeration<String> getAttributeNames();

    /**
     * getParameter:
     * * <p>获取名称为 <code>name</code> 的参数，
     * 如果不存在以 <code>name</code> 为名称的参数，则返回 <code>null</code> 。
     *
     * @param   name
     *          - {@link String} 类型的参数名称
     * @return  {@link Object}
     *          - {@link Object} 类型的参数对象
     * @since  v1.01
     */
    Object getParameter(String name);

    /**
     * getParameterNames:
     * <p>获取参数名称的枚举 {@link Enumeration<String>}</p>
     *
     * @return {@link Enumeration}
     *          - 参数名称的枚举 {@link Enumeration}
     * @since  v1.01
     */
    Enumeration<String> getParameterNames();

    /**
     * setAttribute:
     * <p>设置名称为 <code>name</code> 的属性 <code>attribute</code> 。
     *
     * @param   name
     *          - {@link String} 类型的参数名称
     * @param   attribute
     *          - {@link Object} 类型的属性对象
     *
     * @since   v1.01
     */
    void setAttribute(String name, Object attribute);

    /**
     * setParameter:
     * <p>设置名称为 <code>name</code> 的参数 <code>parameter</code> 。
     *
     * @param   name
     *          - {@link String} 类型的参数名称
     * @param  parameter
     *          - {@link Object} 类型的参数对象
     *
     * @since   v1.01
     */
    void setParameter(String name, Object parameter);
}

