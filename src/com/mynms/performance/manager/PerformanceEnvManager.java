/*
 * @(#)PerformanceEnvManager.java     v1.01, 2012-7-23
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.performance.manager;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;
import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.Result;
import com.mynms.performance.model.PerformanceEnvInfo;
import com.mynms.performance.service.PerformanceEnvService;

/**
 * ClassName: PerformanceEnvManager.java
 * <p>
 * {@link PerformanceEnvManager} 机房环境信息的 {@link Manager} ， 用于处理机房信息页面的业务服务控制类。
 * 
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2012-7-23 上午11:54:04
 */
public class PerformanceEnvManager extends PerformanceNodeManager {

	/**
	 * serialVersionUID:
	 * <p>
	 * 序列化 Id
	 * 
	 * @since v1.01
	 */
	private static final long serialVersionUID = 6375922727542328089L;

	/**
	 * log:
	 * <p>
	 * 日志
	 * 
	 * @since v1.01
	 */
	private static Log log = LogFactory.getLog(PerformanceEnvManager.class);

	/**
	 * service:
	 * <p>
	 * {@link PerformanceEnvInfo} 的业务逻辑类
	 * 
	 * @since v1.01
	 */
	protected PerformanceEnvService service;

	/**
	 * list:
	 * <p>
	 * 处理机房环境信息的列表
	 * 
	 * @since v1.01
	 * @see com.mynms.performance.manager.PerformanceNodeManager#list()
	 */
	public void list() {
		String name = getParameterAsString("name");
		PerformanceEnvService service = this.getService();
		Result<PerformanceEnvInfo> result = null;
		try {
			if(name!=null){
				name=URLDecoder.decode(URLDecoder.decode(name, "utf-8"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (name != null && !"请输入设备名称".equals(name) && !"".equals(name)
				&& !"null".equals(name)) {
			result = service.findByPage("name", name, true,
					createPageByParameter());
		} else {
			result = service.findByPage(createPageByParameter());
		}

		List<PerformanceEnvInfo> list = result.getResultList();
		Page page = result.getPage();
		log.info("查询机房环境信息的列表数量为：" + list.size());
		if (name == null || "".equals(name) || "null".equals(name)) {
			name = "请输入设备名称";
		}
		setAttribute("name", name);
		setAttribute("list", list);
		setAttribute("page", page);
	}

	/**
	 * getService:
	 * <p>
	 * 获取 {@link PerformanceEnvInfo} 的业务逻辑类
	 * 
	 * @return {@link PerformanceEnvService} - {@link PerformanceEnvInfo} 的业务逻辑类
	 * @since v1.01
	 */
	public PerformanceEnvService getService() {
		return service;
	}

	/**
	 * setService:
	 * <p>
	 * 设置 {@link PerformanceEnvInfo} 的业务逻辑类
	 * 
	 * @param service -
	 *            {@link PerformanceEnvInfo} 的业务逻辑类
	 * @since v1.01
	 */
	public void setService(PerformanceEnvService service) {
		this.service = service;
	}

}
