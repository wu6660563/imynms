/*
 * @(#)PerformanceNetService.java     v1.01, 2012-7-18
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.service;

import java.util.List;

import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.Result;
import com.mynms.core.base.BaseService;
import com.mynms.performance.dao.PerformanceNetDAO;
import com.mynms.performance.model.PerformanceNetInfo;

/**
 * ClassName:   PerformanceNetService.java
 * <p> {@link PerformanceNetInfo} 的业务逻辑类。
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-7-18 下午05:38:29
 */
public class PerformanceNetService
                extends BaseService<PerformanceNetInfo,
                                    Integer,
                                    PerformanceNetDAO> {

    /**
     * serialVersionUID:
     * <p>序列化 Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -5619513901070706560L;

    /**
     * findByPage:
     * <p>通过 {@link Page} 对象，分页查询网络设备性能信息 {@link PerformanceNetInfo} 的列表。
     *
     * @param   page
     *          - {@link Page} 类型的分页对象
     * @return  {@link Result<T>}
     *          - 返回查询后的结果
     *
     * @since   v1.01
     */
    public Result<PerformanceNetInfo> findByPage(Page page) {
        PerformanceNetDAO dao = this.getDAO();
        return dao.findByPage(PerformanceNetInfo.class, page);
    }

    /**
     * findByPage:
     * <p>通过参数 和 {@link Page} 对象，分页查询告警信息 {@link PerformanceNetInfo} 的列表
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
    public Result<PerformanceNetInfo> findByPage(String[] propertyNames,
                                                Object[] values,
                                                Page page) {
        PerformanceNetDAO dao = getDAO();
        Result<PerformanceNetInfo> result =
            dao.findByPage(PerformanceNetInfo.class,
                        propertyNames,
                        values,
                        page);
        return result;
    }

    /**
     * findById:
     * <p>通过标示<code>id</code>，查询网络设备性能信息 {@link PerformanceNetInfo} 对象。
     *
     * @param   id
     *          - {@link PerformanceNetInfo} 对象 <code>id</code>
     * @return  {@link PerformanceNetInfo}
     *          - 返回查询后 {@link PerformanceNetInfo} 对象 
     *
     * @since   v1.01
     */
    public PerformanceNetInfo findById(int id) {
        PerformanceNetDAO dao = this.getDAO();
        return dao.get(PerformanceNetInfo.class, id);
    }

    /**
     * deleteAll:
     * <p>删除所有的 {@link PerformanceNetInfo} 告警信息
     *
     * @since   v1.01
     */
    public void deleteAll() {
        PerformanceNetDAO dao = getDAO();
        dao.deleteAll(PerformanceNetInfo.class);
    }
    
    /**
     * saveBatch:
     * <p>批量保存 {@link PerformanceNetInfo} 告警信息
     *
     * @param   entities
     *          - {@link PerformanceNetInfo} 的集合
     *
     * @since   v1.01
     */
    public void saveBatch(List<PerformanceNetInfo> entities) {
        PerformanceNetDAO dao = getDAO();
        dao.saveBatch(entities);
    }
}

