/*
 * @(#)TopologyMapAction.java     v1.01, 2012-6-28
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.topology.action;

import com.mynms.core.base.BaseAction;

/**
 * ClassName:   TopologyMapAction.java
 * <p> {@link TopologyMapAction} 拓扑图的 {@link Action},
 * 用于处理拓扑图页面展示的跳转。
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-6-28 下午10:08:30
 */
public class TopologyMapAction extends BaseAction {

    /**
     * serialVersionUID:
     * <p>序列化Id
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -7302693887582911713L;

    /**
     * list:
     * <p>获取拓扑图列表信息
     *
     * @return  {@link String}
     *          - 拓扑图列表页面
     *
     * @since   v1.01
     */
    public String list(){
        executeAction("list");
        return "list";
    }

    /**
     * show:
     * <p>展现拓扑图
     *
     * @return  {@link String}
     *          - 拓扑页面
     *
     * @since   v1.01
     */
    public String show() {
        executeAction("show");
        return "show";
    }
    
    /**
     * showSubMap:
     * <p>展现拓扑图
     *
     * @return  {@link String}
     *          - 拓扑页面
     *
     * @since   v1.01
     */
    public String showSubMap() {
        executeAction("showSubMap");
        return "show";
    }
}

