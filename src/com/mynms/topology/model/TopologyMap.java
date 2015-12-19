/*
 * @(#)TopologyMap.java     v1.01, 2012-6-21
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.topology.model;

import com.mynms.core.base.BasePOJO;

/**
 * ClassName:   TopologyMap.java
 * <p>拓扑图
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-6-21 下午05:14:03
 */
public class TopologyMap extends BasePOJO {

    /**
     * serialVersionUID:
     * <p>序列化Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = 3492221049340193533L;

    /**
     * id:
     * <p>拓扑图标识
     *
     * @since   v1.01
     */
    private int id;

    /**
     * name:
     * <p>拓扑图名称
     *
     * @since   v1.01
     */
    private String name;

    /**
     * xmlName:
     * <p>拓扑图 XML 名称
     *
     * @since   v1.01
     */
    private String xmlName;

    /**
     * type:
     * <p>拓扑图类型
     *
     * @since   v1.01
     */
    private int type;

    /**
     * topologyBg:
     * <p>拓扑图背景
     *
     * @since   v1.01
     */
    private String topologyBg;

    /**
     * getId:
     * <p>获取拓扑图标识
     *
     * @return  {@link Integer}
     *          - 拓扑图标识
     * @since   v1.01
     */
    public int getId() {
        return id;
    }


    /**
     * setId:
     * <p>设置拓扑图标识
     *
     * @param   id
     *          - 拓扑图标识
     * @since   v1.01
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * getName:
     * <p>获取拓扑图名称
     *
     * @return  {@link String}
     *          - 拓扑图名称
     * @since   v1.01
     */
    public String getName() {
        return name;
    }


    /**
     * setName:
     * <p>设置拓扑图名称
     *
     * @param   name
     *          - 拓扑图名称
     * @since   v1.01
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * getXmlName:
     * <p>获取拓扑图 XML 名称
     *
     * @return  {@link String}
     *          - 拓扑图 XML 名称
     * @since   v1.01
     */
    public String getXmlName() {
        return xmlName;
    }


    /**
     * setXmlName:
     * <p>设置拓扑图 XML 名称
     *
     * @param   xmlName
     *          - 拓扑图 XML 名称
     * @since   v1.01
     */
    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }


    /**
     * getType:
     * <p>获取拓扑图类型
     *
     * @return  {@link Integer}
     *          - 拓扑图类型
     * @since   v1.01
     */
    public int getType() {
        return type;
    }


    /**
     * setType:
     * <p>设置拓扑图类型
     *
     * @param   type
     *          - 拓扑图类型
     * @since   v1.01
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * getTopologyBg:
     * <p>获取拓扑图背景
     *
     * @return  {@link String}
     *          - 拓扑图背景
     * @since   v1.01
     */
    public String getTopologyBg() {
        return topologyBg;
    }


    /**
     * setTopologyBg:
     * <p>设置拓扑图背景
     *
     * @param   topologyBg
     *          - 拓扑图背景
     * @since   v1.01
     */
    public void setTopologyBg(String topologyBg) {
        this.topologyBg = topologyBg;
    }


    /**
     * toString:
     * <p>返回 {@link TopologyMap} 实例的 {@link String} 表现形式。
     *
     * @return  {@link String}
     *          - {@link TopologyMap} 实例的 {@link String} 表现形式。
     * @since   v1.01
     * @see com.mynms.core.base.BasePOJO#toString()
     */
    @Override
    public String toString() {
        return this.getId() + "\t" + this.getName()
                + "\t" + this.getXmlName() + "\t" + this.getType();
    }

}

