/*
 * @(#)BaseAction.java     v1.01, 2011-8-29
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;
import com.mynms.core.Action;
import com.mynms.core.Manager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ClassName:BaseAction
 * <p>
 * {@link BaseAction} 基础请求处理类，为所有请求处理类顶级父类， 所有请求处理的具体类都应该继承自 {@link BaseAction}
 * 。
 * </p>
 *
 * <p>
 * {@link BaseAction} 包请求处理的具体类的公共方法，比如：
 * <li>{@link #getRequest()}
 * <li>{@link #getResponse()}
 * <li>{@link #executeAction(String)} 等等。
 * </p>
 *
 * <p>
 * 每个具体 {@link Action} 实现类中在处理请求的具体方法中， 应使用 {@link #executeAction(String)}
 * 方法来进行业务逻辑处理。
 * </p>
 *
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2011-8-29 下午11:22:07
 * @see Action
 */
public class BaseAction extends ActionSupport implements Action, SessionAware,
        ServletRequestAware, ServletResponseAware {

    /**
     * 序列化 ID
     *
     * @since v1.01
     */
    private static final long serialVersionUID = 3140258467030986258L;

    /**
     * 日志
     *
     * @since v1.01
     */
    private static Log log = LogFactory.getLog(BaseAction.class);

    /**
     * Manger 对象
     */
    private Manager manager;

    /**
     * HTTP 请求对象
     */
    private HttpServletRequest request;

    /**
     * HTTP 响应对象
     */
    private HttpServletResponse response;

    /**
     * HTTP Session 对象
     */
    private HttpSession session;

    /**
     * getManager:
     * <p>
     * 获取业务逻辑控制类
     * </p>
     *
     * @return {@link Manager} - 业务逻辑控制类
     * @since v1.01
     */
    public Manager getManager() {
        return this.manager;
    }

    /**
     * setManager:
     * <p>
     * 设置业务逻辑控制类
     * </p>
     *
     * @param manager
     *            - 业务逻辑控制类
     * @since v1.01
     */
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    /**
     * getRequest:
     * <p>
     * 获取 HTTP 请求对象
     * </p>
     *
     * @return {@link HttpServletRequest} - HTTP 请求对象
     * @since v1.01
     */
    public HttpServletRequest getRequest() {
        if (this.request == null) {
            this.request = ServletActionContext.getRequest();
        }
        return this.request;
    }

    /**
     * setRequest:
     * <p>
     * 设置 HTTP 请求对象
     * </p>
     *
     * @param request
     *            - HTTP 请求对象
     * @since v1.01
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * getResponse:
     * <p>
     * 获取 HTTP 请求响应对象
     * </p>
     *
     * @return {@link HttpServletResponse} - HTTP 请求响应对象
     * @since v1.01
     */
    public HttpServletResponse getResponse() {
        if (this.response == null) {
            this.response = ServletActionContext.getResponse();
        }
        return this.response;
    }

    /**
     * setResponse:
     * <p>
     * 设置HTTP 请求响应对象
     * </p>
     *
     * @param response
     *            - HTTP 请求响应对象
     * @since v1.01
     */
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * getSession:
     * <p>
     * 获取 HTTP Session 对象
     * </p>
     *
     * @return {@link HttpSession} - HTTP Session 对象
     * @since v1.01
     */
    public HttpSession getSession() {
        if (this.session == null) {
            this.session = this.getRequest().getSession();
        }
        return this.session;
    }

    /**
     * setSession:
     * <p>
     * 设置 HTTP Session 对象
     * </p>
     *
     * @param session
     *            - HTTP Session 对象
     * @since v1.01
     */
    public void setSession(HttpSession session) {
        this.session = session;
    }

    /**
     * getParameter:
     * <p>
     * 获取 HTTP 请求 {@link HttpServletRequest} 中的参数。 该参数的名称为 name ， 类型为
     * {@link String} 。
     * </p>
     *
     * @param name
     *            - HTTP 请求 {@link HttpServletRequest} 中的参数名称
     * @return {@link String} - HTTP 请求 {@link HttpServletRequest} 中的参数， 该参数类型为
     *         {@link String} 。
     * @see HttpServletRequest#getParameter(String)
     * @since v1.01
     */
    public String getParameter(String name) {
        return this.getRequest().getParameter(name);
    }

    /**
     * getParameterValues:
     * <p>
     * 获取 HTTP 请求 {@link HttpServletRequest} 中的参数。 该参数的名称为 name ， 类型为
     * {@link String[]} 。
     * </p>
     *
     * @param name
     *            - HTTP 请求 {@link HttpServletRequest} 中的参数名称
     * @return {@link String[]} - HTTP 请求 {@link HttpServletRequest} 中的参数，
     *         该参数类型为 {@link String[]} 。
     * @see HttpServletRequest#getParameterValues(String)
     * @since v1.01
     */
    public String[] getParameterValues(String name) {
        return this.getRequest().getParameterValues(name);
    }

    /**
     * getAttribute:
     * <p>获取 HTTP 请求 {@link HttpServletRequest} 中的属性。
     *
     * @param   name
     *          - 属性名称
     * @return  {@link Object}
     *          - {@link Object} 类型的属性
     *
     * @since   v1.01
     */
    public Object getAttribute(String name) {
        return getRequest().getAttribute(name);
    }

    /**
     * setAttribute:
     * <p>设置 HTTP 请求 {@link HttpServletRequest} 中的属性。</p>
     *
     * @param   name
     *          - 属性名称
     * @param   attribute
     *          - {@link Object} 类型的属性
     * @since   v1.01
     */
    public void setAttribute(String name, Object attribute) {
        getRequest().setAttribute(name, attribute);
    }

    /**
     * executeAction:
     * <p>
     * 调用业务逻辑控制 {@link Manager} 的方法进行处理请求。
     * </p>
     *
     * @param methodName
     *            - 业务逻辑控制 {@link Manager} 的方法名
     * @since v1.01
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected final void executeAction(String methodName) {
        try {
            // 设置 Manager 的参数和属性
            setManagerParameterFromRequest();
            setManagerAttributeFromRequest();
            setManagerAttributeFromSession();

            // 获取处理请求 manager
            Manager manager = this.getManager();
            // 调用业务逻辑控制中名称为 methodeName 的方法类处理请求
            Class managerClass = manager.getClass();
            Method managerMethod = managerClass.getMethod(methodName);
            if (log.isDebugEnabled()) {
                log.debug("执行：" + managerClass.getCanonicalName() + "的方法："
                        + managerMethod.getName());
            }
            managerMethod.invoke(manager);
            setRequestAttributeFromManager();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * setManagerParamterFromRequest:
     * <p>将{@link HttpServletRequest} 中的参数设置到
     * {@link Manager} 实例 中。
     *
     * @since   v1.01
     */
    @SuppressWarnings("unchecked")
    public void setManagerParameterFromRequest() {
        Enumeration<String> parameterEnumeration =
                        this.getRequest().getParameterNames();
        if (parameterEnumeration != null) {
            while (parameterEnumeration.hasMoreElements()) {
                String name = parameterEnumeration.nextElement();
                Object parameter =
                        this.getRequest().getParameterMap().get(name);
                setManagerParameter(name, parameter);
            }
        }
    }

    /**
     * setManagerAttributeFromRequest:
     * <p>将{@link HttpServletRequest} 中的属性设置到
     * {@link Manager} 实例 中。
     *
     * @since   v1.01
     */
    @SuppressWarnings("unchecked")
    public void setManagerAttributeFromRequest() {
        Enumeration<String> attributeEnumeration =
                        this.getRequest().getAttributeNames();
        if (attributeEnumeration != null) {
            while (attributeEnumeration.hasMoreElements()) {
                String name = attributeEnumeration.nextElement();
                Object attribute = this.getRequest().getAttribute(name);
                setManagerAttribute(name, attribute);
            }
        }
    }

    /**
     * setManagerAttributeFromSession:
     * <p>将{@link HttpSession} 中的属性设置到
     * {@link Manager} 实例 中。
     *
     * @since   v1.01
     */
    @SuppressWarnings("unchecked")
    public void setManagerAttributeFromSession() {
        Enumeration<String> attributeEnumeration =
                        this.getSession().getAttributeNames();
        if (attributeEnumeration != null) {
            while (attributeEnumeration.hasMoreElements()) {
                String name = attributeEnumeration.nextElement();
                Object attribute = this.getRequest().getAttribute(name);
                setManagerAttribute(name, attribute);
            }
        }
    }

    /**
     * setRequestAttributeFromManager:
     * <p>将 {@link Manager} 实例中的属性设置到 {@link HttpServletRequest} 中
     *
     * @since   v1.01
     */
    public void setRequestAttributeFromManager() {
        Enumeration<String> attributeEnumeration =
                this.getManager().getAttributeNames();
        if (attributeEnumeration != null) {
            while (attributeEnumeration.hasMoreElements()) {
                String name = attributeEnumeration.nextElement();
                Object attribute = this.getManager().getAttribute(name);
                setAttribute(name, attribute);
            }
        }
    }

    /**
     * setManagerAttribute:
     * <p>设置 {@link Manager} 实例的属性</p>
     *
     * @param   name
     *          - 属性名称
     * @param   attribute
     *          - {@link Object} 类型的属性
     * @since   v1.01
     */
    public void setManagerAttribute(String name, Object attribute) {
        this.getManager().setAttribute(name, attribute);
    }

    /**
     * setManagerParameter:
     * <p>设置 {@link Manager} 实例的参数</p>
     *
     * @param   name
     *          - 参数名称
     * @param   parameter
     *  ·       - {@link Object} 类型的参数
     * @since   v1.01
     */
    public void setManagerParameter(String name, Object parameter) {
        this.getManager().setParameter(name, parameter);
    }

    /**
     * setServletResponse:
     * <p>
     * 用于实现 Struts2 与 Spring 整合后， Spring 对 Struts2 的 Action 的
     * {@link HttpServletResponse} 注入。
     * </p>
     *
     * @param arg0
     *            - {@link HttpServletResponse}
     * @see org.apache.struts2.interceptor.ServletResponseAware#
     *      setServletResponse(javax.servlet.http.HttpServletResponse)
     * @since v1.01
     */
    public void setServletResponse(HttpServletResponse arg0) {
        this.setResponse(arg0);
    }

    /**
     * setServletRequest:
     * <p>
     * 用于实现 Struts2 与 Spring 整合后， Spring 对 Struts2 的 Action 的
     * {@link HttpServletRequest} 注入。
     * </p>
     *
     * @param arg0
     *            - {@link HttpServletRequest}
     * @see org.apache.struts2.interceptor.ServletRequestAware#
     *      setServletRequest(javax.servlet.http.HttpServletRequest)
     * @since v1.01
     */
    public void setServletRequest(HttpServletRequest arg0) {
        this.setRequest(arg0);
    }

    /**
     * setSession:
     * <p>
     * 用于实现 Struts2 与 Spring 整合后， Spring 对 Struts2 的 Action 的
     * {@link HttpSession} 注入。
     * </p>
     *
     * @param arg0
     *            - {@link HttpSession} 的属性 {@link Map}
     * @see org.apache.struts2.interceptor.SessionAware#
     *      setSession(java.util.Map)
     * @since v1.01
     */
    public void setSession(Map<String, Object> arg0) {
        // 不做任何事
    }

}
