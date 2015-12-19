/*
 * @(#)Result.java     v1.01, 2012-6-22
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.common.util.page;

import java.util.List;

/**
 * ClassName:   Result.java
 * <p>{@link Result} 分页查询的结果类，
 * 其中包含一个页对象 {@link Page} ，以及一个结果集对象 {@link List} 。
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-6-22 下午05:35:29
 */
public class Result<T> {

    /**
     * page:
     * <p>页
     *
     * @since   v1.01
     */
    private Page page;

    /**
     * resultList:
     * <p>分页查询中的结果集
     *
     * @since   v1.01
     */
    private List<T> resultList;

    /**
     * 通过 {@link Page} 实例以及结果集创建一个 {@link Result<T>} 实例。
     * @param   page
     *          - {@link Page} 分页对象
     * @param   resultList
     *          - {@link List} 类型的结果集
     *
     * @since   v1.01
     */
    public Result(Page page, List<T> resultList) {
        super();
        this.page = page;
        this.resultList = resultList;
    }

    /**
     * getPage:
     * <p>获取分页查询中页对象。
     *
     * @return  {@link Page}
     *          - 页对象
     * @since   v1.01
     */
    public Page getPage() {
        return page;
    }

    /**
     * setPage:
     * <p>设置分页查询中页对象。
     *
     * @param   page
     *          - 页对象
     * @since   v1.01
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * getResultList:
     * <p>获取分页查询中的结果集。
     *
     * @return  {@link List<T>}
     *          - 分页查询中的结果集
     * @since   v1.01
     */
    public List<T> getResultList() {
        return resultList;
    }

    /**
     * setResultList:
     * <p>设置分页查询中的结果集。
     *
     * @param   resultList
     *          - 分页查询中的结果集
     * @since   v1.01
     */
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    
}

