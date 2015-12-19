/*
 * @(#)PerformanceNetManager.java     v1.01, 2012-7-18
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.manager;

import java.util.ArrayList;
import java.util.List;

import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;
import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.PaginationSupport;
import com.mynms.common.util.page.Result;
import com.mynms.performance.model.PerformanceNetInfo;
import com.mynms.performance.service.PerformanceNetService;

/**
 * ClassName: PerformanceNetManager.java
 * <p>
 * 
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2012-7-18 下午08:41:41
 */
public class PerformanceNetManager extends PerformanceNodeManager {

	/**
	 * serialVersionUID:
	 * <p>
	 * 序列化 Id
	 * 
	 * @since v1.01
	 */
	private static final long serialVersionUID = 2169615826262205244L;

	/**
	 * log:
	 * <p>
	 * 日志
	 * 
	 * @since v1.01
	 */
	private static Log log = LogFactory.getLog(PerformanceNetManager.class);

	/**
	 * service:
	 * <p>
	 * {@link PerformanceNetInfo} 的业务逻辑类
	 * 
	 * @since v1.01
	 */
	protected PerformanceNetService service;

	/**
	 * list:
	 * <p>
	 * 处理主机性能的列表
	 * 
	 * @since v1.01
	 * @see com.mynms.performance.manager.PerformanceNodeManager#list()
	 */
	public void list() {
		Integer nodeId = getParameterAsInt("nodeId");
		String ipAddress = getParameterAsString("ipAddress");
		String[] propertyNames = null;
		Object[] values = null;

		List<String> propertyNameList = new ArrayList<String>();
		List<Object> propertyValueList = new ArrayList<Object>();

		if (nodeId != null && !"".equals(nodeId)) {
			propertyNameList.add("nodeId");
			propertyValueList.add(nodeId);
		}

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
		PerformanceNetService service = this.getService();
		Result<PerformanceNetInfo> result = service.findByPage(propertyNames,
				values, createPageByParameter());
		List<PerformanceNetInfo> list = result.getResultList();
		Page page = result.getPage();
		log.info("查询网络设备性能信息的列表数量为：" + list.size());

		if (ipAddress == null || "".equals(ipAddress)
				|| "null".equals(ipAddress)) {
			ipAddress = "IP";
		}
		setAttribute("ipAddress", ipAddress);
		setAttribute("nodeId", nodeId);
		setAttribute("list", list);
		setAttribute("page", page);
	}

	/**
	 * findById:
	 * <p>
	 * 通过 <code>id</code> 查询
	 * 
	 * @since v1.01
	 */
	public void findById() {
		Integer id = getParameterAsInt("nodeId");
		PerformanceNetService service = this.getService();
		PerformanceNetInfo info = service.findById(id);
		List<PerformanceNetInfo> list = new ArrayList<PerformanceNetInfo>();
		if (info != null) {
			list.add(info);
		}
		Page page = PaginationSupport.createPage(this.createPageByParameter(),
				list.size());
		setAttribute("list", list);
		setAttribute("page", page);
	}

	/**
	 * getService:
	 * <p>
	 * 获取 {@link PerformanceNetInfo} 的业务逻辑类
	 * 
	 * @return {@link PerformanceNetInfo} - {@link PerformanceNetInfo} 的业务逻辑类
	 * @since v1.01
	 */
	public PerformanceNetService getService() {
		return service;
	}

	/**
	 * setService:
	 * <p>
	 * 设置 {@link PerformanceNetInfo} 的业务逻辑类
	 * 
	 * @param service -
	 *            {@link PerformanceNetInfo} 的业务逻辑类
	 * @since v1.01
	 */
	public void setService(PerformanceNetService service) {
		this.service = service;
	}

}
