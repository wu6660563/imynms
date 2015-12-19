/*
 * @(#)PerformanceHostService.java     v1.01, 2012-7-18
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.service;

import java.util.List;

import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.Result;
import com.mynms.core.base.BaseService;
import com.mynms.performance.dao.PerformanceHostDAO;
import com.mynms.performance.model.PerformanceHostInfo;

/**
 * ClassName: PerformanceHostService.java
 * <p>
 * {@link PerformanceHostInfo} 的业务逻辑类。
 * 
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2012-7-18 下午05:46:43
 */
public class PerformanceHostService extends
		BaseService<PerformanceHostInfo, Integer, PerformanceHostDAO> {

	/**
	 * serialVersionUID:
	 * <p>
	 * 序列化 Id
	 * 
	 * @since v1.01
	 */
	private static final long serialVersionUID = 1478986424313183035L;

	/**
	 * findByPage:
	 * <p>
	 * 通过 {@link Page} 对象，分页查询主机性能信息 {@link PerformanceHostInfo} 的列表。
	 * 
	 * @param page -
	 *            {@link Page} 类型的分页对象
	 * @return {@link Result<T>} - 返回查询后的结果
	 * 
	 * @since v1.01
	 */
	public Result<PerformanceHostInfo> findByPage(Page page) {
		PerformanceHostDAO dao = this.getDAO();
		return dao.findByPage(PerformanceHostInfo.class, page);
	}

	/**
	 * findByPage:
	 * <p>
	 * 通过参数 和 {@link Page} 对象，分页查询告警信息 {@link PerformanceHostInfo} 的列表
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
	public Result<PerformanceHostInfo> findByPage(String[] propertyNames,
			Object[] values, Page page) {
		PerformanceHostDAO dao = getDAO();
		Result<PerformanceHostInfo> result = dao.findByPage(
				PerformanceHostInfo.class, propertyNames, values, page);
		return result;
	}

	/**
	 * deleteAll:
	 * <p>
	 * 删除所有的 {@link PerformanceHostInfo} 告警信息
	 * 
	 * @since v1.01
	 */
	public void deleteAll() {
		PerformanceHostDAO dao = getDAO();
		dao.deleteAll(PerformanceHostInfo.class);
	}

	/**
	 * saveBatch:
	 * <p>
	 * 批量保存 {@link PerformanceHostInfo} 告警信息
	 * 
	 * @param entities -
	 *            {@link PerformanceHostInfo} 的集合
	 * 
	 * @since v1.01
	 */
	public void saveBatch(List<PerformanceHostInfo> entities) {
		PerformanceHostDAO dao = getDAO();
		dao.saveBatch(entities);
	}
}
