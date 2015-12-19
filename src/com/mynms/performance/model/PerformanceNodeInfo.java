/*
 * @(#)PerformanceNodeInfo.java     v1.01, 2012-7-18
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.model;

import com.mynms.core.base.BasePOJO;

/**
 * ClassName:   PerformanceNodeInfo.java
 * <p> {@link PerformanceNodeInfo} 节点性能信息
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-7-18 下午01:17:24
 */
public class PerformanceNodeInfo extends BasePOJO {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -8515980291625731219L;

    // Fields

    /**
     * id:
     * <p>标示
     *
     * @since   v1.01
     */
    protected Integer id;

    /**
     * id:
     * <p>设备标示
     *
     * @since   v1.01
     */
    protected Integer nodeId;

    /**
     * name:
     * <p>名称
     *
     * @since   v1.01
     */
    protected String name;

    /**
     * ipAddress:
     * <p>IP地址
     *
     * @since   v1.01
     */
    protected String ipAddress;

    /**
     * type:
     * <p>类型
     *
     * @since   v1.01
     */
    protected String type;

    /**
     * subtype:
     * <p>子类型
     *
     * @since   v1.01
     */
    protected String subtype;

    /**
     * PerformanceNodeInfo:
     * <p>默认的构造方法，构造一个新的 {@link PerformanceNodeInfo} 实例。
     *
     * @since   v1.01
     */
    public PerformanceNodeInfo() {
    }

    /**
     * getId:
     * <p>获取标示
     *
     * @return  {@link Integer}
     *          - {@link Integer} 类型的标示
     * @since   v1.01
     */
    public Integer getId() {
        return id;
    }

    /**
     * setId:
     * <p>设置标示
     *
     * @param   id
     *          - {@link Integer} 类型的标示
     * @since   v1.01
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getNodeId:
     * <p>获取设备标示
     *
     * @return  {@link Integer}
     *          - {@link Integer} 类型的设备标示
     * @since   v1.01
     */
    public Integer getNodeId() {
        return nodeId;
    }

    /**
     * setNodeId:
     * <p>设置设备标示
     *
     * @param   nodeId
     *          - {@link Integer} 类型的设备标示
     * @since   v1.01
     */
    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * getName:
     * <p>获取名称
     *
     * @return  {@link String}
     *          - {@link String} 类型的名称
     * @since   v1.01
     */
    public String getName() {
        return name;
    }

    /**
     * setName:
     * <p>设置名称
     *
     * @param   name
     *          - {@link String} 类型的名称
     * @since   v1.01
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getIpAddress:
     * <p>获取 <code>IP</code> 地址
     *
     * @return  {@link String}
     *          - {@link String} 类型的 <code>IP</code> 地址
     * @since   v1.01
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * setIpAddress:
     * <p>设置 <code>IP</code> 地址
     *
     * @param   ipAddress
     *          - {@link String} 类型的 <code>IP</code> 地址
     * @since   v1.01
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * getType:
     * <p>获取类型
     *
     * @return  {@link String}
     *          - @link String} 类型的类型
     * @since   v1.01
     */
    public String getType() {
        return type;
    }

    /**
     * setType:
     * <p>设置类型
     *
     * @param   type
     *          - @link String} 类型的类型
     * @since   v1.01
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * getSubtype:
     * <p>获取子类型
     *
     * @return  String
     *          - {@link String} 类型的子类型
     * @since   v1.01
     */
    public String getSubtype() {
        return subtype;
    }

    /**
     * setSubtype:
     * <p>设置子类型
     *
     * @param   subtype
     *          - @link String} 类型的子类型
     * @since   v1.01
     */
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    /**
     * toString:
     * <p>返回 {@link PerformanceNodeInfo} 实例的 {@link String} 表现形式。
     *
     * @return  {@link String}
     *          - {@link PerformanceNodeInfo} 实例的 {@link String} 表现形式。
     *
     * @since   v1.01
     * @see com.mynms.core.base.BasePOJO#toString()
     */
    public String toString() {
        return this.getId() + "\t" + this.getName() + "\t"
                + this.getIpAddress() + "\t" + this.getType()
                + "\t" + this.getSubtype();
    }

    
}

