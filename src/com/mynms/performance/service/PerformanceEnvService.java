/*
 * @(#)PerformanceEnvService.java     v1.01, 2012-7-23
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.service;

import java.util.List;

import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.Result;
import com.mynms.core.POJO;
import com.mynms.core.base.BaseService;
import com.mynms.core.exception.DAOException;
import com.mynms.performance.dao.PerformanceEnvDAO;
import com.mynms.performance.model.PerformanceEnvInfo;

/**
 * ClassName: PerformanceEnvService.java
 * <p>
 * {@link PerformanceEnvInfo} 的业务逻辑类。
 * 
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2012-7-23 上午11:30:43
 */
public class PerformanceEnvService extends
		BaseService<PerformanceEnvInfo, Integer, PerformanceEnvDAO> {

	/**
	 * serialVersionUID:
	 * <p>
	 * 序列化 Id
	 * 
	 * @since v1.01
	 */
	private static final long serialVersionUID = 2266153522488653493L;

	/**
	 * findByPage:
	 * <p>
	 * 通过 {@link Page} 对象，分页查询机房性能信息 {@link PerformanceEnvInfo} 的列表。
	 * 
	 * @param page -
	 *            {@link Page} 类型的分页对象
	 * @return {@link Result<T>} - 返回查询后的结果
	 * 
	 * @since v1.01
	 */
	public Result<PerformanceEnvInfo> findByPage(Page page) {
		PerformanceEnvDAO dao = this.getDAO();
		return dao.findByPage(PerformanceEnvInfo.class, page);
	}

	/**
	 * findByPage:
	 * <p>
	 * 通过参数 和 {@link Page} 对象，分页查询告警信息 {@link PerformanceEnvInfo} 的列表
	 * 
	 * @param propertyNames -
	 *            参数名称数组
	 * @param values -
	 *            参数名称对应的参数值数组
	 * @param page -
	 *            {@link Page} 类型的分页对象
	 * @return {@link Result<T>} - 返回查询后的结果
	 * 
	 * @since v1.01
	 */
	public Result<PerformanceEnvInfo> findByPage(String[] propertyNames,
			Object[] values, Page page) {
		PerformanceEnvDAO dao = getDAO();
		Result<PerformanceEnvInfo> result = dao.findByPage(
				PerformanceEnvInfo.class, propertyNames, values, page);
		return result;
	}

	/**
	 * findByPage:
	 * <p>
	 * <通过{@link POJO} 类实例的 {@link Class} 对象，查询条件的参数名称和对应参数值 以及 {@link Page}
	 * 对象，分页查询结果集。
	 * 
	 * @param clazz -
	 *            {@link POJO} 类实例的 {@link Class}
	 * @param propertyName -
	 *            查询条件的参数名称
	 * @param value -
	 *            查询条件对应的参数值
	 * @param isLike -
	 *            是否使用模糊查询
	 * @param page -
	 *            {@link Page} 类型的分页对象
	 * @return {@link List<T>} - 返回查询后的结果
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	public Result<PerformanceEnvInfo> findByPage(String propertyNames,
			Object values, Boolean isLike, Page page) {
		PerformanceEnvDAO dao = getDAO();
		Result<PerformanceEnvInfo> result = dao.findByPage(
				PerformanceEnvInfo.class, propertyNames, values, isLike, page);
		return result;
	}

	/**
	 * deleteAll:
	 * <p>
	 * 删除所有的 {@link PerformanceEnvInfo} 告警信息
	 * 
	 * @since v1.01
	 */
	public void deleteAll() {
		PerformanceEnvDAO dao = getDAO();
		dao.deleteAll(PerformanceEnvInfo.class);
	}

	/**
	 * saveBatch:
	 * <p>
	 * 批量保存 {@link PerformanceEnvInfo} 告警信息
	 * 
	 * @param entities -
	 *            {@link PerformanceEnvInfo} 的集合
	 * 
	 * @since v1.01
	 */
	public void saveBatch(List<PerformanceEnvInfo> entities) {
		PerformanceEnvDAO dao = getDAO();
		dao.saveBatch(entities);
	}
}
