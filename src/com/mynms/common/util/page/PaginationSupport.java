/*
 * @(#)PaginationSupport.java     v1.01, 2012-6-22
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.common.util.page;

/**
 * ClassName: PaginationSupport.java
 * <p>{@link PaginationSupport} 分页支持，
 * 用于分页查询中对分页的操作
 * 
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-6-22 下午05:23:43
 */
public class PaginationSupport {

    /**
     * createPage:
     * <p>通过一个旧的 {@link Page} 实例以及总数创建一个新的
     * {@link Page} 。
     *
     * @param   page
     *          - {@link Page} 实例
     * @param   totalCount
     *          - 总数
     * @return  {@link Page}
     *          - {@link Page} 实例
     *
     * @since   v1.01
     */
    public static Page createPage(Page page, int totalCount) {
        return createPage(page.getPageSize(),
                            page.getCurrentPage(),
                            totalCount);
    }

    /**
     * createPage:
     * <p>通过分页大小，当前页和总数创建一个新的 {@link Page} 实例。
     *
     * @param   pageSize
     *          - 分页大小
     * @param   currentPage
     *          - 当前页
     * @param   totalCount
     *          - 总数
     * @return  {@link Page}
     *          - {@link Page} 实例
     *
     * @since   v1.01
     */
    public static Page createPage(int pageSize, int currentPage,
                    int totalCount) {
        int pageSizeTemp = getPageSize(pageSize);
        int currentPageTemp = getCurrentPage(currentPage);
        int firstIndex = getFirstIndex(pageSizeTemp, currentPageTemp);
        int totalPage = getTotalPage(pageSizeTemp, totalCount);
        boolean hasNextPage = hasNextPage(currentPageTemp, totalPage);
        boolean hasPrePage = hasPrePage(currentPageTemp);
        return new Page(pageSizeTemp, totalCount, totalPage,
                        firstIndex, currentPageTemp, hasPrePage, hasNextPage);
    }

    /**
     * getPageSize:
     * <p>校验并返回分页大小，如果传入的分页大小小于或等于0，
     * 则返回默认的大小 {@link Page#PAGE_SIZE} 。
     *
     * @param   pageSize
     *          - 分页大小
     * @return  {@link Integer}
     *          - 分页大小
     *
     * @since   v1.01
     */
    private static int getPageSize(int pageSize) {
        if (pageSize <= 0) {
            return Page.PAGE_SIZE;
        }
        return pageSize;
    }

    /**
     * getCurrentPage:
     * <p>校验并返回当前页，如果传入的当前页为小于或等于0，
     * 则返回1。
     *
     * @param   currentPage
     *          - 当前页
     * @return  {@link Integer}
     *          - 当前页
     *
     * @since   v1.01
     */
    private static int getCurrentPage(int currentPage) {
        if (currentPage <= 0) {
            return 1;
        }
        return currentPage;
    }

    /**
     * getFirstIndex:
     * <p>通过分页大小和当前页获取第一个的索引。
     *
     * @param   pageSize
     *          - 分页大小
     * @param   currentPage
     *          - 当前页
     * @return  {@link Integer}
     *          - 返回当前页的第一个索引
     *
     * @since   v1.01
     */
    private static int getFirstIndex(int pageSize, int currentPage) {
        return (currentPage - 1) * pageSize; 
    }

    /**
     * getTotalPage:
     * <p>通过分页大小和总数获取总页数。
     *
     * @param   pageSize
     *          - 分页大小
     * @param   totalCount
     *          - 总记录数
     * @return  {@link Integer}
     *          - 总页数
     *
     * @since   v1.01
     */
    private static int getTotalPage(int pageSize, int totalCount) {
        int totalPage = 0;
        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize; 
        } else {
            totalPage = totalCount / pageSize + 1;
        }
        return totalPage;
    }

    /**
     * hasPrePage:
     * <p>通过当前页校验是否有上一页
     *
     * @param   currentPage
     *          - 当前页
     * @return  {@link Boolean}
     *          - 如果有上一页，则返回 <code>true</code> ，否则返回 <code>false</code>
     *
     * @since   v1.01
     */
    private static boolean hasPrePage(int currentPage) {
        boolean hasPrePage = true;
        if (currentPage <= 1) {
            hasPrePage = false;
        }
        return hasPrePage;
    }

    /**
     * hasNextPage:
     * <p>通过当前页和总页数获取是否有下一页。
     *
     * @param   currentPage
     *          - 当前页
     * @param   totalPage
     *          - 总页数
     * @return  {@link Boolean}
     *          - 如果有下一页，则返回<code>true</code> ，否则返回 <code>false</code>
     *
     * @since   v1.01
     */
    private static boolean hasNextPage(int currentPage, int totalPage) {
        boolean hasNextPage = true;
        if (currentPage >= totalPage || totalPage <= 0) {
            hasNextPage = false;
        }
        return hasNextPage;
    }

}
