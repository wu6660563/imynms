/*
 * @(#)AlarmInfo.java     v1.01, 2012-6-12
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.alarm.model;

import java.sql.Timestamp;

import com.mynms.core.base.BasePOJO;

/**
 * ClassName:   AlarmInfo.java
 * <p>告警信息
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-6-12 下午04:16:08
 */
public class AlarmInfo extends BasePOJO {

    /**
     * serialVersionUID:
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = 4531100434153966222L;

    // Fields

    /**
     * id:
     * <p>告警信息标示
     *
     * @since   v1.01
     */
    private int id;

    /**
     * nodeId:
     * <p>设备标示
     *
     * @since   v1.01
     */
    private int nodeId;

    /**
     * nodeType:
     * <p>设备类型
     *
     * @since   v1.01
     */
    private String nodeType;

    /**
     * nodeSubtype:
     * <p>设备子类型
     *
     * @since   v1.01
     */
    private String nodeSubtype;

    /**
     * eventLocation:
     * <p>告警信息来源
     *
     * @since   v1.01
     */
    private String eventLocation;

    /**
     * content:
     * <p>告警信息内容
     *
     * @since   v1.01
     */
    private String content;

    /**
     * level:
     * <p>告警信息等级
     *
     * @since   v1.01
     */
    private int level;

    /**
     * recordTime:
     * <p>告警信息记录时间
     *
     * @since   v1.01
     */
    private Timestamp recordTime;

    /**
     * getId:
     * <p>获取告警标示。
     *
     * @return  {@link Integer}
     *          - {@link Integer} 的告警标示
     * @since   v1.01
     */
    public int getId() {
        return id;
    }

    /**
     * setId:
     * <p>设置告警标示
     *
     * @param   id
     *          - {@link Integer} 的告警标示
     * @since   v1.01
     */
    public void setId(int id) {
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
    public int getNodeId() {
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
    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * getNodeType:
     * <p>获取设备类型
     *
     * @return  {@link String}
     *          - {@link String} 类型的设备类型
     * @since   v1.01
     */
    public String getNodeType() {
        return nodeType;
    }

    /**
     * setNodeType:
     * <p>设置设备类型
     *
     * @param   nodeType
     *          - {@link String} 类型的设备类型
     * @since   v1.01
     */
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    /**
     * getNodeSubtype:
     * <p>获取设备子类型
     *
     * @return  {@link String}
     *          - {@link String} 类型的设备子类型
     * @since   v1.01
     */
    public String getNodeSubtype() {
        return nodeSubtype;
    }

    /**
     * setNodeSubtype:
     * <p>设置设备子类型
     *
     * @param   nodeSubtype
     *          - {@link String} 类型的设备子类型
     * @since   v1.01
     */
    public void setNodeSubtype(String nodeSubtype) {
        this.nodeSubtype = nodeSubtype;
    }

    /**
     * getEventLocation:
     * <p>获取告警信息来源。
     *
     * @return  {@link String}
     *          - {@link String} 类型的告警信息来源
     * @since   v1.01
     */
    public String getEventLocation() {
        return eventLocation;
    }

    /**
     * setEventLocation:
     * <p>设置告警信息来源。
     *
     * @param   eventLocation
     *          - {@link String} 类型的告警信息来源
     * @since   v1.01
     */
    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    /**
     * getContent:
     * <p>获取告警信息内容。
     *
     * @return  {@link String}
     *          - {@link String} 类型的告警信息内容
     * @since   v1.01
     */
    public String getContent() {
        return content;
    }

    /**
     * setContent:
     * <p>设置告警信息内容。
     *
     * @param   content
     *          - {@link String} 类型的告警信息内容
     * @since   v1.01
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * getLevel:
     * <p>获取告警信息等级。
     *
     * @return  {@link Integer}
     *          - {@link Integer} 类型的告警信息等级
     * @since   v1.01
     */
    public int getLevel() {
        return level;
    }

    /**
     * setLevel:
     * <p>设置告警信息等级。
     *
     * @param   level
     *          - {@link Integer} 类型的告警信息等级
     * @since   v1.01
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * getRecordTime:
     * <p>获取告警信息记录时间。
     *
     * @return  {@link Timestamp}
     *          - {@link Timestamp} 类型的告警信息记录时间
     * @since   v1.01
     */
    public Timestamp getRecordTime() {
        return recordTime;
    }

    /**
     * setRecordTime:
     * <p>设置告警信息记录时间。
     *
     * @param   recordTime
     *          - {@link Timestamp} 类型的告警信息记录时间
     * @since   v1.01
     */
    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * toString:
     * <p>重写 toString 方法，便于以后调试。
     *
     * @return {@link String}
     *          - 返回 {@link CopyOfAlarmInfo} 实例的 {@link String} 表现形式。
     *
     * @since   v1.01
     * @see com.mynms.core.base.BasePOJO#toString()
     */
    @Override
    public String toString() {
        return getId() + "\t" + getEventLocation() + "\t" + getContent()
                    + "\t" + getLevel() + "\t" + getRecordTime() + "";
    }
}

