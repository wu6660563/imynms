/*
 * @(#)TopologyMapManager.java     v1.01, 2012-6-21
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.topology.manager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;
import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.Result;
import com.mynms.core.base.BaseManager;
import com.mynms.topology.model.TopologyMap;
import com.mynms.topology.service.TopologyMapService;
import com.opensymphony.xwork2.ActionContext;

/**
 * ClassName: TopologyMapManager.java
 * <p>
 * {@link TopologyMapManager} 用于提供服务的逻辑控制
 * 
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2012-6-21 上午11:05:00
 */
public class TopologyMapManager extends BaseManager {

	/**
	 * serialVersionUID:
	 * <p>
	 * 序列化Id
	 * 
	 * @since v1.01
	 */
	private static final long serialVersionUID = 232386047373194157L;

	/**
	 * log:
	 * <p>
	 * 日志
	 * 
	 * @since v1.01
	 */
	private static Log log = LogFactory.getLog(TopologyMapManager.class);

	/**
	 * service:
	 * <p>
	 * {@link TopologyMap} 的业务逻辑类
	 * 
	 * @since v1.01
	 */
	private TopologyMapService service;

	/**
	 * list:
	 * <p>
	 * 处理拓扑图的列表
	 * 
	 * @since v1.01
	 */
	public void list() {
		TopologyMapService alarmInfoService = getService();
		Result<TopologyMap> result = alarmInfoService
				.findByPage(createPageByParameter());
		List<TopologyMap> list = result.getResultList();
		Page page = result.getPage();
		log.info("查询拓扑图的列表数量为：" + list.size());
		// String str[]={"submap1337832089.jsp","submap1337916143.jsp"};
		List<TopologyMap> tologylist = new ArrayList<TopologyMap>();
		for (TopologyMap topologyMap : list) {
			if ("submap1337832089.jsp".equals(topologyMap.getXmlName())) {
				tologylist.add(topologyMap);
			}
			if ("submap1337916143.jsp".equals(topologyMap.getXmlName())) {
				tologylist.add(topologyMap);
			}
		}
		setAttribute("list", tologylist);
		setAttribute("page", page);
	}

	/**
	 * show:
	 * <p>
	 * 展现拓扑图
	 * 
	 * @since v1.01
	 */
	public void show() {
		Integer id = getParameterAsInt("id");
		TopologyMapService alarmInfoService = getService();
		TopologyMap topologyMap = alarmInfoService.findById(id);
		if (topologyMap == null) {
			topologyMap = new TopologyMap();
		} else {
			if (topologyMap.getTopologyBg() != null
					&& !"".equals(topologyMap.getTopologyBg())) {
				// wupinlong add 2013/04/17 先取得ActionContext 取得背景图片的大小
				ActionContext actionContext = ActionContext.getContext();
				ServletContext servletContext = (ServletContext) actionContext
						.get(ServletActionContext.SERVLET_CONTEXT);
				String bgPath = servletContext
						.getRealPath("/resource/image/topo/bg");
				File bgImg = new File(bgPath + File.separator
						+ topologyMap.getTopologyBg());
				try {
					BufferedImage sourceImg = ImageIO.read(new FileInputStream(
							bgImg));
					setAttribute("sourceImg", sourceImg);
				} catch (FileNotFoundException e) {
					log.error("FileNotFoundException", e);
					e.printStackTrace();
				} catch (IOException e) {
					log.error("IOException", e);
					e.printStackTrace();
				}
			}
		}
		setAttribute("topologyMap", topologyMap);
	}

	/**
	 * show:
	 * <p>
	 * 展现拓扑图
	 * 
	 * @since v1.01
	 */
	public void showSubMap() {
		String xmlName = getParameterAsString("xmlName");
		TopologyMapService alarmInfoService = getService();
		TopologyMap topologyMap = alarmInfoService.findByXmlName(xmlName);
		if (topologyMap == null) {
			topologyMap = new TopologyMap();
		} else {
			if (topologyMap.getTopologyBg() != null
					&& !"".equals(topologyMap.getTopologyBg())) {
				// wupinlong add 2013/04/17 先取得ActionContext 取得背景图片的大小
				ActionContext actionContext = ActionContext.getContext();
				ServletContext servletContext = (ServletContext) actionContext
						.get(ServletActionContext.SERVLET_CONTEXT);
				String bgPath = servletContext
						.getRealPath("/resource/image/topo/bg");
				File bgImg = new File(bgPath + File.separator
						+ topologyMap.getTopologyBg());
				try {
					BufferedImage sourceImg = ImageIO.read(new FileInputStream(
							bgImg));
					setAttribute("sourceImg", sourceImg);
				} catch (FileNotFoundException e) {
					log.error("FileNotFoundException", e);
					e.printStackTrace();
				} catch (IOException e) {
					log.error("IOException", e);
					e.printStackTrace();
				}
			}
		}
		setAttribute("topologyMap", topologyMap);
		setAttribute("xmlName", xmlName);
	}

	/**
	 * getService:
	 * <p>
	 * 获取 {@link TopologyMap} 的业务逻辑类
	 * 
	 * @return {@link TopologyMapService} - {@link TopologyMap} 的业务逻辑类
	 * @since v1.01
	 */
	public TopologyMapService getService() {
		return service;
	}

	/**
	 * setService:
	 * <p>
	 * 设置 {@link TopologyMap} 的业务逻辑类
	 * 
	 * @param service -
	 *            {@link TopologyMap} 的业务逻辑类
	 * @since v1.01
	 */
	public void setService(TopologyMapService service) {
		this.service = service;
	}

}
