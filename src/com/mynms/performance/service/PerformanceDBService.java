/*
 * @(#)PerformanceDBService.java     v1.01, 2012-7-18
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.service;

import java.util.List;

import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.Result;
import com.mynms.core.base.BaseService;
import com.mynms.performance.dao.PerformanceDBDAO;
import com.mynms.performance.model.PerformanceDBInfo;

/**
 * ClassName: PerformanceDBService.java
 * <p>
 * {@link PerformanceDBInfo} 的业务逻辑类。
 * 
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2012-7-18 下午05:45:49
 */
public class PerformanceDBService extends
		BaseService<PerformanceDBInfo, Integer, PerformanceDBDAO> {

	/**
	 * serialVersionUID:
	 * <p>
	 * 序列化 Id
	 * 
	 * @since v1.01
	 */
	private static final long serialVersionUID = -4980163732470712782L;

	/**
	 * findByPage:
	 * <p>
	 * 通过 {@link Page} 对象，分页查询数据库性能信息 {@link PerformanceDBInfo} 的列表。
	 * 
	 * @param page -
	 *            {@link Page} 类型的分页对象
	 * @return {@link Result<T>} - 返回查询后的结果
	 * 
	 * @since v1.01
	 */
	public Result<PerformanceDBInfo> findByPage(Page page) {
		PerformanceDBDAO dao = this.getDAO();
		return dao.findByPage(PerformanceDBInfo.class, page);
	}

	/**
	 * findByPage:
	 * <p>
	 * 通过参数 和 {@link Page} 对象，分页查询告警信息 {@link PerformanceDBInfo} 的列表
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
	public Result<PerformanceDBInfo> findByPage(String[] propertyNames,
			Object[] values, Page page) {
		PerformanceDBDAO dao = getDAO();
		Result<PerformanceDBInfo> result = dao.findByPage(
				PerformanceDBInfo.class, propertyNames, values, page);
		return result;
	}

	/**
	 * deleteAll:
	 * <p>
	 * 删除所有的 {@link PerformanceDBInfo} 告警信息
	 * 
	 * @since v1.01
	 */
	public void deleteAll() {
		PerformanceDBDAO dao = getDAO();
		dao.deleteAll(PerformanceDBInfo.class);
	}

	/**
	 * saveBatch:
	 * <p>
	 * 批量保存 {@link PerformanceDBInfo} 告警信息
	 * 
	 * @param entities -
	 *            {@link PerformanceDBInfo} 的集合
	 * 
	 * @since v1.01
	 */
	public void saveBatch(List<PerformanceDBInfo> entities) {
		PerformanceDBDAO dao = getDAO();
		dao.saveBatch(entities);
	}
}
