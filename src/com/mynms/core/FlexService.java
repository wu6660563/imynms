/*
 * @(#)FlexService.java     v1.01, 2011-12-14
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.core;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName:FlexService
 * <p>{@link FlexService} Flex 远程通信接口，用于接受页面
 *  Flex 与后台通信，接收页面 Flex 提交的参数，
 * 然后通过 {@link Manager} 业务逻辑控制类进行处理请求。</p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-12-14 下午11:47:11
 */
public interface FlexService extends Serializable {

    /**
     * getManager:
     * <p>获取业务逻辑控制类</p>
     *
     * @return {@link Manager}
     *          - 业务逻辑控制类
     * @since  v1.01
     */
    Manager getManager();

    /**
     * setManager:
     * <p>设置业务逻辑控制类</p>
     *
     * @param  manager
     *          - 业务逻辑控制类
     * @since  v1.01
     */
    void setManager(Manager manager);

    /**
     * getRequest:
     * <p>获取 HTTP 请求对象</p>
     *
     * @return {@link HttpServletRequest}
     *          - HTTP 请求对象
     * @since  v1.01
     */
    HttpServletRequest getRequest();

    /**
     * setRequest:
     * <p>设置 HTTP 请求对象</p>
     *
     * @param request
     *          - HTTP 请求对象
     * @since  v1.01
     */
    void setRequest(HttpServletRequest request);

    /**
     * getResponse:
     * <p>获取 HTTP 请求响应对象</p>
     *
     * @return {@link HttpServletResponse}
     *          - HTTP 请求响应对象
     * @since  v1.01
     */
    HttpServletResponse getResponse();

    /**
     * setResponse:
     * <p>设置HTTP 请求响应对象</p>
     *
     * @param  response
     *          - HTTP 请求响应对象
     * @since  v1.01
     */
    void setResponse(HttpServletResponse response);

    /**
     * getSession:
     * <p>获取 HTTP Session 对象</p>
     *
     * @return {@link HttpSession}
     *          - HTTP Session 对象
     * @since  v1.01
     */
    HttpSession getSession();

    /**
     * setSession:
     * <p>设置 HTTP Session 对象</p>
     *
     * @param session
     *          - HTTP Session 对象
     * @since  v1.01
     */
    void setSession(HttpSession session);

    /**
     * getParameter:
     * <p>获取 HTTP 请求 {@link HttpServletRequest} 中的参数。
     * 该参数的名称为 name ， 类型为 {@link String} 。 </p>
     *
     * @param name
     *          -  HTTP 请求 {@link HttpServletRequest} 中的参数名称
     * @return {@link String}
     *          - HTTP 请求 {@link HttpServletRequest} 中的参数，
     *            该参数类型为 {@link String} 。
     * @see HttpServletRequest#getParameter(String)
     * @since  v1.01
     */
    String getParameter(String name);

    /**
     * getParameterValues:
     * <p>获取 HTTP 请求 {@link HttpServletRequest} 中的参数。
     * 该参数的名称为 name ， 类型为 {@link String[]} 。 </p>
     *
     * @param name
     *          -  HTTP 请求 {@link HttpServletRequest} 中的参数名称
     * @return {@link String[]}
     *          - HTTP 请求 {@link HttpServletRequest} 中的参数，
     *            该参数类型为 {@link String[]} 。
     * @see HttpServletRequest#getParameterValues(String)
     * @since  v1.01
     */
    String[] getParameterValues(String name);
}

