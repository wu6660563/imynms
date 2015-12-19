/*
 * @(#)PerformanceEnvInfo.java     v1.01, 2012-7-19
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.model;

import com.mynms.core.base.BasePOJO;

/**
 * ClassName:   PerformanceEnvInfo.java
 * <p> {@link PerformanceEnvInfo} 动力环境性能信息
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-7-19 上午11:12:52
 */
public class PerformanceEnvInfo extends BasePOJO {

    // Fields

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -924449408010806774L;

    /**
     * id:
     * <p>标示
     *
     * @since   v1.01
     */
    private Integer id;

    /**
     * name:
     * <p>名称
     *
     * @since   v1.01
     */
    private String name;

    /**
     * alias:
     * <p>别名
     *
     * @since   v1.01
     */
    private String alias;

    /**
     * indicatorName:
     * <p>指标名称
     *
     * @since   v1.01
     */
    private String indicatorName;

    /**
     * indicatorValue:
     * <p>指标值
     *
     * @since   v1.01
     */
    private Double indicatorValue;

    /**
     * alarmLevel:
     * <p>告警等级
     *
     * @since   v1.01
     */
    private Integer alarmLevel; 

    /**
     * PerformanceEnvInfo:
     * <p>默认的构造方法，构造一个新的 {@link PerformanceEnvInfo} 的实例。
     *
     * @since   v1.01
     */
    public PerformanceEnvInfo() {
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
     * getAlias:
     * <p>获取别名
     *
     * @return  {@link String}
     *          - {@link String} 类型的别名
     * @since   v1.01
     */
    public String getAlias() {
        return alias;
    }


    /**
     * setAlias:
     * <p>设置别名
     *
     * @param   alias
     *          - {@link String} 类型的别名
     * @since   v1.01
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }


    /**
     * getIndicatorName:
     * <p>获取指标名称
     *
     * @return  {@link String}
     *          - {@link String} 类型的指标名称
     * @since   v1.01
     */
    public String getIndicatorName() {
        return indicatorName;
    }


    /**
     * setIndicatorName:
     * <p>设置指标名称
     *
     * @param   indicatorName
     *          - {@link String} 类型的指标名称
     * @since   v1.01
     */
    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }


    /**
     * getIndicatorValue:
     * <p>获取指标值
     *
     * @return  {@link Double}
     *          - {@link Double} 类型的指标值
     * @since   v1.01
     */
    public Double getIndicatorValue() {
        return indicatorValue;
    }


    /**
     * setIndicatorValue:
     * <p>设置指标值
     *
     * @param   indicatorValue
     *          - {@link Integer} 类型的指标值
     * @since   v1.01
     */
    public void setIndicatorValue(Double indicatorValue) {
        this.indicatorValue = indicatorValue;
    }


    /**
     * getAlarmLevel:
     * <p>获取告警等级
     *
     * @return  {@link Integer}
     *          - {@link Integer} 类型的告警等级
     * @since   v1.01
     */
    public Integer getAlarmLevel() {
        return alarmLevel;
    }


    /**
     * setAlarmLevel:
     * <p>设置告警等级
     *
     * @param   alarmLevel
     *          - {@link Integer} 类型的告警等级
     * @since   v1.01
     */
    public void setAlarmLevel(Integer alarmLevel) {
        this.alarmLevel = alarmLevel;
    }


    /**
     * toString:
     * <p>返回 {@link PerformanceEnvInfo} 实例的 {@link String} 表现形式。
     *
     * @return  {@link String}
     *          - {@link PerformanceEnvInfo} 实例的 {@link String} 表现形式。
     *
     * @since   v1.01
     * @see com.mynms.core.base.BasePOJO#toString()
     */
    @Override
    public String toString() {
        return this.getId() + "\t" + this.getName() + "\t"
                + this.getAlias() + "\t" + this.getIndicatorName() + "\t"
                + this.getIndicatorValue() + "\t" + this.getAlarmLevel();
    }

}

