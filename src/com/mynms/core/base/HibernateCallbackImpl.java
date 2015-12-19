/*
 * @(#)HibernateCallbackImpl.java     v1.01, 2012-6-27
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.PaginationSupport;
import com.mynms.common.util.page.Result;
import com.mynms.core.exception.DAOException;

/**
 * ClassName:   HibernateCallbackImpl.java
 * <p>{@link HibernateCallbackImpl} 实现<code>Spring</code>
 * 的 {@link HibernateCallback} ， 用于直接使用<code>Hibernate</code>
 * 中的<code>Session</code>。
 * 其中包含主要是分页查询方法。
 *
 * @author      聂林
 * @param       <T>
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-6-27 上午11:11:04
 */
public class HibernateCallbackImpl<T> implements
                HibernateCallback<Result<T>>,
                Serializable{

    /**
     * serialVersionUID:
     * <p>序列化Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -5609118255533661300L;

    /**
     * parameters:
     * <p>用于存放传入的参数
     *
     * @since   v1.01
     */
    private HashMap<String, Object> parameters;

    /**
     * 构造一个新的 {@link HibernateCallbackImpl} 实例。
     *
     * @since   v1.01
     */
    public HibernateCallbackImpl() {
        super();
        parameters = new HashMap<String, Object>();
    }

    /**
     * doInHibernate:
     *
     * @param arg0
     * @return
     * @throws HibernateException
     * @throws SQLException
     *
     * @since   v1.01
     * @see org.springframework.orm.hibernate3.HibernateCallback#doInHibernate(org.hibernate.Session)
     */
    public Result<T> doInHibernate(Session session) throws HibernateException,
                    SQLException {
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public Result<T> findByPage(Session session, Class<T> clazz, Page page) throws
                    DAOException {
        try {
            int firstIndex = (page.getCurrentPage() - 1) * page.getPageSize();
            Criteria criteria = session.createCriteria(clazz);
            int totalCount = ((Long) criteria.setProjection(
                            Projections.rowCount()).uniqueResult()).intValue();
            List<T> list = criteria.setProjection(null)
                                .setFirstResult(firstIndex)
                                .setMaxResults(page.getPageSize()).list();
            Page newPage = PaginationSupport.createPage(page, totalCount);
            return new Result<T>(newPage, list);
        } catch (DataAccessResourceFailureException e) {
            throw new DAOException("", e, DAOException.FIND_BY_PAGE);
        } catch (IllegalStateException e) {
            throw new DAOException("", e, DAOException.FIND_BY_PAGE);
        } catch (HibernateException e) {
            throw new DAOException("", e, DAOException.FIND_BY_PAGE);
        }
    }

    /**
     * getParameter:
     * <p>获取指定名称的参数
     *
     * @param   name
     *          - {@link String} 类型的参数名称
     * @return  {@link Object}
     *          - {@link Object} 类型的参数
     *
     * @since   v1.01
     */
    public Object getParameter(String name) {
        return parameters.get(name);
    }

    /**
     * setParameter:
     * <p>设置指定名称的参数
     *
     * @param   name
     *          -{@link String} 类型的参数名称
     * @param   parameter
     *          - {@link Object} 类型的参数
     *
     * @since   v1.01
     */
    public void setParameter(String name, Object parameter) {
        this.parameters.put(name, parameter);
    }
    
}

