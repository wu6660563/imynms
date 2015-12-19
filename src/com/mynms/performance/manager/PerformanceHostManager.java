/*
 * @(#)PerformanceHostManager.java     v1.01, 2012-7-18
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
import com.mynms.performance.model.PerformanceHostInfo;
import com.mynms.performance.service.PerformanceHostService;

/**
 * ClassName: PerformanceHostManager.java
 * <p>
 * 
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2012-7-18 下午06:19:50
 */
public class PerformanceHostManager extends PerformanceNodeManager {

	/**
	 * serialVersionUID:
	 * <p>
	 * 序列化 Id
	 * 
	 * @since v1.01
	 */
	private static final long serialVersionUID = -1580561700094274504L;

	/**
	 * log:
	 * <p>
	 * 日志
	 * 
	 * @since v1.01
	 */
	private static Log log = LogFactory.getLog(PerformanceHostManager.class);

	/**
	 * service:
	 * <p>
	 * {@link PerformanceHostInfo} 的业务逻辑类
	 * 
	 * @since v1.01
	 */
	protected PerformanceHostService service;

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

		PerformanceHostService service = this.getService();
		Result<PerformanceHostInfo> result = service.findByPage(propertyNames,
				values, createPageByParameter());
		List<PerformanceHostInfo> list = result.getResultList();
		Page page = result.getPage();
		log.info("查询主机性能信息的列表数量为：" + list.size());

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
	 * 获取 {@link PerformanceHostInfo} 的业务逻辑类
	 * 
	 * @return {@link PerformanceHostService} - {@link PerformanceHostInfo}
	 *         的业务逻辑类
	 * @since v1.01
	 */
	public PerformanceHostService getService() {
		return service;
	}

	/**
	 * setService:
	 * <p>
	 * 设置 {@link PerformanceHostInfo} 的业务逻辑类
	 * 
	 * @param service -
	 *            {@link PerformanceHostInfo} 的业务逻辑类
	 * @since v1.01
	 */
	public void setService(PerformanceHostService service) {
		this.service = service;
	}

}
