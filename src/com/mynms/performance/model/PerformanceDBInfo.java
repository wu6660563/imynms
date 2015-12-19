/*
 * @(#)PerformanceDBInfo.java     v1.01, 2012-7-18
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.model;

/**
 * ClassName:   PerformanceDBInfo.java
 * <p> {@link PerformanceDBInfo} 数据库的性能信息
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-7-18 下午04:06:33
 */
public class PerformanceDBInfo extends PerformanceNodeInfo {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -17898910340133056L;

    /**
     * ping:
     * <p>连通性利用率
     *
     * @since   v1.01
     */
    protected Double ping;

    /**
     * PerformanceDBInfo:
     * <p>默认的构造方法，构造一个新的 {@link PerformanceDBInfo} 实例。
     *
     * @since   v1.01
     */
    public PerformanceDBInfo() {
        super();
    }

    /**
     * getPing:
     * <p>获取连通性利用率
     *
     * @return  {@link Double}
     *          - {@link Double} 类型的连通性利用率
     * @since   v1.01
     */
    public Double getPing() {
        return ping;
    }

    /**
     * setPing:
     * <p>设置连通性利用率
     *
     * @param   ping
     *          - {@link Double} 类型的连通性利用率
     * @since   v1.01
     */
    public void setPing(Double ping) {
        this.ping = ping;
    }

    /**
     * toString:
     * <p>返回 {@link PerformanceDBInfo} 实例的 {@link String} 表现形式。
     *
     * @return  {@link String}
     *          - {@link PerformanceDBInfo} 实例的 {@link String} 表现形式。
     *
     * @since   v1.01
     * @see PerformanceNodeInfo#toString()
     * @see com.mynms.core.base.BasePOJO#toString()
     */
    public String toString() {
        return super.toString() + "\t" + this.getPing();
    }
}

