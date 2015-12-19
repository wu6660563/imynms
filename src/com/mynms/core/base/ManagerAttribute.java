/*
 * @(#)ManagerAttribute.java     v1.01, 2012-5-8
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core.base;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * ClassName:   ManagerAttribute.java
 * <p> {@link ManagerAttribute} 用于保存 {@link com.mynms.core.Manager} 中的属性。
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-5-8 下午11:15:28
 */
public class ManagerAttribute implements Serializable {


    // Fields

    /**
     * serialVersionUID:
     * <p>序列化ID
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -2464006410062465725L;

    /**
     * attributeHashtable:
     * <p> {@link Hashtable} 类型的 <code>attributeHashtable</code>
     * 对象，用于保存  {@link Manager} 中的属性
     *
     * @since   v1.01
     */
    private Hashtable<String, Object> attributeHashtable;


    // Constructs

    /**
     * ManagerAttribute:
     * <p>默认的构造方法，创建一个 {@link ManagerAttribute} 实例。
     *
     * @since   v1.01
     */
    public ManagerAttribute() {
        this.setAttributeHashtable(new Hashtable<String, Object>());
    }


    // Getter And Setter

    /**
     * getAttributeHashtable:
     * <p>获取 {@link #attributeHashtable} ，该方法为私有的只用于本类。
     *
     * @return  Hashtable<String, Object>
     *          - {@link Hashtable<String, Object>} 类型的
     *            {@link #attributeHashtable} 对象
     * @since   v1.01
     */
    public Hashtable<String, Object> getAttributeHashtable() {
        return attributeHashtable;
    }


    /**
     * setAttributeHashtable:
     * <p>设置 {@link #attributeHashtable} ，该方法为私有的只用于本类。
     *
     * @param   attributeHashtable
     *          - {@link Hashtable<String, Object>} 类型的
     *            {@link #attributeHashtable} 对象
     * @since   v1.01
     */
    public void setAttributeHashtable(
                    Hashtable<String, Object> attributeHashtable) {
        this.attributeHashtable = attributeHashtable;
    }


    // Method

    /**
     * getAttribute:
     * <p>获取指定名称为 <code>name</code> 的属性。
     *
     * @param   name
     *          - 指定的属性名称
     * @return  {@link Object}
     *          -   {@link Object} 类型的属性。
     * @since   v1.01
     */
    public Object getAttribute(String name) {
        return getAttributeHashtable().get(name);
    }

    /**
     * getParameterNames:
     * <p>获取属性名称的枚举 {@link Enumeration<String>}</p>
     *
     * @return  {@link Enumeration<String>}
     *          - 属性名称的枚举 {@link Enumeration<String>}
     * @since   v1.01
     */
    public Enumeration<String> getAttributeNames() {
        return getAttributeHashtable().keys();
    }

    /**
     * setAttribute:
     * <p>设置名称为 <code>name</code> 的属性 <code>attribute</code> 。
     *
     * @param   name
     *          - {@link String} 类型的参数名称
     * @param  attribute
     *          - {@link Object} 类型的属性对象
     *
     * @since   v1.01
     */
    public void setAttribute(String name, Object attribute) {
        if (attribute != null) {
            getAttributeHashtable().put(name, attribute);
        }
    }
}

