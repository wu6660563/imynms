/*
 * @(#)AlarmInfoService.java     v1.01, 2012-6-13
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.alarm.service;

import java.util.List;

import com.mynms.alarm.dao.AlarmInfoDAO;
import com.mynms.alarm.model.AlarmInfo;
import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.Result;
import com.mynms.core.base.BaseService;

/**
 * ClassName:   AlarmInfoService.java
 * <p>{@link AlarmInfo} 的业务逻辑类。
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-6-13 上午09:25:41
 */
public class AlarmInfoService extends
                BaseService<AlarmInfo, Integer, AlarmInfoDAO> {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = 3307594142506278920L;

    /**
    * findByPage:
    * <p>通过 {@link Page} 对象，分页查询告警信息 {@link AlarmInfo} 的列表。
    *
    * @param   page
    *          - {@link Page} 类型的分页对象
    * @return  {@link Result<T>}
    *          - 返回查询后的结果
    *
    * @since   v1.01
    */
    public Result<AlarmInfo> findByPage(Page page) {
        AlarmInfoDAO alarmInfoDao = getDAO();
        Result<AlarmInfo> result =
            alarmInfoDao.findByPage(AlarmInfo.class, page);
        return result;
    }

    /**
     * findByPage:
     * <p>通过参数 和 {@link Page} 对象，分页查询告警信息 {@link AlarmInfo} 的列表
     *
     * @param   propertyNames
     *          - 参数名称数组
     * @param   values
     *          - 参数名称对应的参数值数组
     * @param   page
     *          - {@link Page} 类型的分页对象
     * @return  {@link Result<T>}
     *          - 返回查询后的结果
     *
     * @since   v1.01
     */
    public Result<AlarmInfo> findByPage(String[] propertyNames,
                                        Object[] values,
                                        Page page) {
        AlarmInfoDAO alarmInfoDao = getDAO();
        Result<AlarmInfo> result =
            alarmInfoDao.findByPage(AlarmInfo.class,
                                    propertyNames,
                                    values,
                                    page);
        return result;
    }

    /**
     * deleteAll:
     * <p>删除所有的 {@link AlarmInfo} 告警信息
     *
     * @since   v1.01
     */
    public void deleteAll() {
        AlarmInfoDAO alarmInfoDAO = getDAO();
        alarmInfoDAO.deleteAll(AlarmInfo.class);
    }
    
    /**
     * saveBatch:
     * <p>批量保存 {@link AlarmInfo} 告警信息
     *
     * @param   entities
     *          - {@link AlarmInfo} 的集合
     *
     * @since   v1.01
     */
    public void saveBatch(List<AlarmInfo> entities) {
        AlarmInfoDAO alarmInfoDAO = getDAO();
        alarmInfoDAO.saveBatch(entities);
    }
}

