/*
 * @(#)Page.java     v1.01, 2012-6-22
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.common.util.page;

import java.io.Serializable;

/**
 * ClassName:   Page.java
 * <p>{@link Page} 分页查询中页的封装类。
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-6-22 下午05:09:41
 */
public class Page implements Serializable {

    /**
     * PAGE_SIZE:
     * <p>默认的分页大小
     *
     * @since   v1.01
     */
    public static final int PAGE_SIZE = 20;

    /**
     * serialVersionUID:
     * <p>序列化Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -2149893795347770933L;

    /**
     * pageSize:
     * <p>分页记录数
     *
     * @since   v1.01
     */
    private int pageSize = PAGE_SIZE;

    /**
     * totalCount:
     * <p>总记录数
     *
     * @since   v1.01
     */
    private int totalCount;

    /**
     * totalPage:
     * <p>总页数
     *
     * @since   v1.01
     */
    private int totalPage;
    /**
     * firstIndex:
     * <p>第一个索引
     *
     * @since   v1.01
     */
    private int firstIndex;

    /**
     * currentPage:
     * <p>当前页
     *
     * @since   v1.01
     */
    private int currentPage;
    
    /**
     * hasPrePage:
     * <p><p>是否有上一页
     *
     * @since   v1.01
     */
    private boolean hasPrePage;

    /**
     * hasNextPage:
     * <p>是否有下一页
     *
     * @since   v1.01
     */
    private boolean hasNextPage;

    /**
     * Page:
     * <p>使用默认的方法构造一个新的 {@link Page} 对象。
     *
     * @since   v1.01
     */
    public Page() {
        super();
    }

    /**
     * Page:
     * <p>使用所有的字段构造一个新的 {@link Page} 对象。
     * 
     * @param   pageSize
     *          - 分页大小
     * @param   totalCount
     *          - 总数
     * @param   totalPage
     *          - 总页数
     * @param   firstIndex
     *          - 第一个索引
     * @param   currentPage
     *          - 当前页
     * @param   hasPrePage
     *          - 是否有上一页
     * @param   hasNextPage
     *          - 是否有下一页
     *
     * @since   v1.01
     */
    public Page(int pageSize, int totalCount, int totalPage, int firstIndex,
                    int currentPage, boolean hasPrePage, boolean hasNextPage) {
        super();
        this.setPageSize(pageSize);
        this.setTotalCount(totalCount);
        this.setTotalPage(totalPage);
        this.setFirstIndex(firstIndex);
        this.setCurrentPage(currentPage);
        this.setHasPrePage(hasPrePage);
        this.setHasNextPage(hasNextPage);
    }

    /**
     * getPageSize:
     * <p>获取分页记录数。
     *
     * @return  {@link Integer}
     *          - 分页记录数
     * @since   v1.01
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * setPageSize:
     * <p>设置分页记录数。
     *
     * @param   pageSize
     *          - 分页记录数
     * @since   v1.01
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * getTotalCount:
     * <p>获取总记录数。
     *
     * @return  {@link Integer}
     *          - 总记录数
     * @since   v1.01
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * setTotalCount:
     * <p>设置总记录数。
     *
     * @param   totalCount
     *          - 总记录数
     * @since   v1.01
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * getTotalPage:
     * <p>获取总页数
     *
     * @return  {@link Integer}
     *          - 总页数
     * @since   v1.01
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * setTotalPage:
     * <p>设置总页数
     *
     * @param   totalPage
     *          - 总页数
     * @since   v1.01
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * getFirstIndex:
     * <p>获取第一个索引
     *
     * @return  {@link Integer}
     *          - 第一个索引
     * @since   v1.01
     */
    public int getFirstIndex() {
        return firstIndex;
    }

    /**
     * setFirstIndex:
     * <p>设置第一个索引
     *
     * @param   firstIndex
     *          - 第一个索引
     * @since   v1.01
     */
    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    /**
     * getCurrentPage:
     * <p>获取当前页
     *
     * @return  {@link Integer}
     *          - 当前页
     * @since   v1.01
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * setCurrentPage:
     * <p>设置当前页
     *
     * @param   currentPage
     *          - 当前页
     * @since   v1.01
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * isHasPrePage:
     * <p>是否有上一页
     *
     * @return  {@link Boolean}
     *          - 如果有上一页，则返回 true
     * @since   v1.01
     */
    public boolean isHasPrePage() {
        return hasPrePage;
    }

    /**
     * setHasPrePage:
     * <p>设置是否有上一页
     *
     * @param   hasPrePage
     *          - 是否有上一页
     * @since   v1.01
     */
    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    /**
     * isHasNextPage:
     * <p>是否有下一页
     *
     * @return  {@link Boolean}
     *          - 如果有下一页，则返回 true
     * @since   v1.01
     */
    public boolean isHasNextPage() {
        return hasNextPage;
    }

    /**
     * setHasNextPage:
     * <p>设置是否有下一页
     *
     * @param   hasNextPage
     *          - 是否有下一页
     * @since   v1.01
     */
    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    
}

