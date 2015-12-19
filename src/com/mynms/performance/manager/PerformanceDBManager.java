/*
 * @(#)PerformanceDBManager.java     v1.01, 2012-7-18
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.manager;

import java.util.ArrayList;
import java.util.List;

import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;
import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.Result;
import com.mynms.performance.model.PerformanceDBInfo;
import com.mynms.performance.service.PerformanceDBService;

/**
 * ClassName: PerformanceDBManager.java
 * <p>
 * 
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2012-7-18 下午08:59:30
 */
public class PerformanceDBManager extends PerformanceNodeManager {

	/**
	 * serialVersionUID:
	 * <p>
	 * 序列化 Id
	 * 
	 * @since v1.01
	 */
	private static final long serialVersionUID = 1948101875456761680L;

	/**
	 * log:
	 * <p>
	 * 日志
	 * 
	 * @since v1.01
	 */
	private static Log log = LogFactory.getLog(PerformanceDBManager.class);

	/**
	 * service:
	 * <p>
	 * {@link PerformanceDBInfo} 的业务逻辑类
	 * 
	 * @since v1.01
	 */
	protected PerformanceDBService service;

	/**
	 * list:
	 * <p>
	 * 处理主机性能的列表
	 * 
	 * @since v1.01
	 * @see com.mynms.performance.manager.PerformanceNodeManager#list()
	 */
	public void list() {
		String ipAddress = getParameterAsString("ipAddress");
		String[] propertyNames = null;
		Object[] values = null;
		List<String> propertyNameList = new ArrayList<String>();
		List<Object> propertyValueList = new ArrayList<Object>();

		if (ipAddress != null && !"".equals(ipAddress)
				&& !"IP".equals(ipAddress) && !"null".equals(ipAddress)) {
			propertyNameList.add("ipAddress");
			propertyValueList.add(ipAddress);
		}
		propertyNames = new String[propertyNameList.size()];
		for (int i = 0; i < propertyNameList.size(); i++) {
			propertyNames[i] = propertyNameList.get(i);
		}
		values = propertyValueList.toArray();

		PerformanceDBService service = this.getService();
		Result<PerformanceDBInfo> result = service.findByPage(propertyNames,
				values, createPageByParameter());
		List<PerformanceDBInfo> list = result.getResultList();
		Page page = result.getPage();
		log.info("查询数据库性能信息的列表数量为：" + list.size());

		if (ipAddress == null || "".equals(ipAddress)
				|| "null".equals(ipAddress)) {
			ipAddress = "IP";
		}
		setAttribute("ipAddress", ipAddress);
		setAttribute("list", list);
		setAttribute("page", page);
	}

	/**
	 * getService:
	 * <p>
	 * 获取 {@link PerformanceDBInfo} 的业务逻辑类
	 * 
	 * @return {@link PerformanceDBInfo} - {@link PerformanceDBInfo} 的业务逻辑类
	 * @since v1.01
	 */
	public PerformanceDBService getService() {
		return service;
	}

	/**
	 * setService:
	 * <p>
	 * 设置 {@link PerformanceDBInfo} 的业务逻辑类
	 * 
	 * @param service -
	 *            {@link PerformanceDBInfo} 的业务逻辑类
	 * @since v1.01
	 */
	public void setService(PerformanceDBService service) {
		this.service = service;
	}
}
