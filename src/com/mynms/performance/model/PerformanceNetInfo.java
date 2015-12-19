/*
 * @(#)PerformanceNetInfo.java     v1.01, 2012-7-18
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.model;

/**
 * ClassName:   PerformanceNetInfo.java
 * <p> {@link PerformanceNetInfo} 网络设备的性能信息
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-7-18 下午04:06:33
 */
public class PerformanceNetInfo extends PerformanceNodeInfo {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = 818842786234421977L;

    /**
     * ping:
     * <p>连通性利用率
     *
     * @since   v1.01
     */
    protected Double ping;

    /**
     * cpu:
     * <p>CPU 利用率
     *
     * @since   v1.01
     */
    protected Double cpu;

    /**
     * memory:
     * <p>内存利用率
     *
     * @since   v1.01
     */
    protected Double memory;

    /**
     * PerformanceNetInfo:
     * <p>默认的构造方法，构造一个新的 {@link PerformanceNetInfo} 实例。
     *
     * @since   v1.01
     */
    public PerformanceNetInfo() {
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
     * getCpu:
     * <p>获取 <code>CPU</code> 利用率
     *
     * @return  {@link Double}
     *          - {@link Double} 类型的 <code>CPU</code> 利用率
     * @since   v1.01
     */
    public Double getCpu() {
        return cpu;
    }

    /**
     * setCpu:
     * <p>设置 <code>CPU</code> 利用率
     *
     * @param   cpu
     *          - {@link Double} 类型的 <code>CPU</code> 利用率
     * @since   v1.01
     */
    public void setCpu(Double cpu) {
        this.cpu = cpu;
    }

    /**
     * getMemory:
     * <p>获取内存利用率
     *
     * @return  {@link Double}
     *          - {@link Double} 类型的内存利用率
     * @since   v1.01
     */
    public Double getMemory() {
        return memory;
    }

    /**
     * setMemory:
     * <p>设置内存利用率
     *
     * @param   memory
     *          - {@link Double} 类型的内存利用率
     * @since   v1.01
     */
    public void setMemory(Double memory) {
        this.memory = memory;
    }

}

