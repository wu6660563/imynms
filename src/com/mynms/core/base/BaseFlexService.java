/*
 * @(#)BaseFlexService.java     v1.01, 2011-12-8
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.core.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;
import com.mynms.core.FlexService;
import com.mynms.core.Manager;

import flex.messaging.FlexContext;

/**
 * ClassName:BaseFlexService
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-12-8 上午01:03:06
 */
/**
 * ClassName:   BaseFlexService.java
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-5-10 下午12:35:06
 */
public class BaseFlexService implements FlexService {

    /**
     * serialVersionUID:
     * <p>序列化 ID</p>
     *
     * @since v1.01
     */
    private static final long serialVersionUID = 1707102898940225396L;

    /**
     * 日志
     *
     * @since v1.01
     */
    private static Log log = LogFactory.getLog(BaseFlexService.class);

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
     * @return {@link Manager}
     *          - 业务逻辑控制类
     * @since v1.01
     * @see com.mynms.core.FlexService#getManager()
     */
    public Manager getManager() {
        return manager;
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
     * @see com.mynms.core.FlexService#setManager(com.mynms.core.Manager)
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
     * @see com.mynms.core.FlexService#getRequest()
     */
    public HttpServletRequest getRequest() {
        if (request == null) {
            request = FlexContext.getHttpRequest();
        }
        return request;
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
     * @see com.mynms.core.FlexService#setRequest(
     *                          javax.servlet.http.HttpServletRequest)
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
     * @return {@link HttpServletResponse}
     *          - HTTP 请求响应对象
     * @since v1.01
     * @see com.mynms.core.FlexService#getResponse()
     */
    public HttpServletResponse getResponse() {
        if (response == null) {
            response = FlexContext.getHttpResponse();
        }
        return response;
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
     * @see com.mynms.core.FlexService#setResponse(
     *                          javax.servlet.http.HttpServletResponse)
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
     * @return {@link HttpSession}
     *          - HTTP Session 对象
     * @since v1.01
     * @see com.mynms.core.FlexService#getSession()
     */
    public HttpSession getSession() {
        if (session == null) {
            session = getRequest().getSession();
        }
        return session;
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
     * @see com.mynms.core.FlexService#setSession(
     *                      javax.servlet.http.HttpSession)
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
     * @see com.mynms.core.FlexService#getParameter(java.lang.String)
     * @since v1.01
     */
    public String getParameter(String name) {
        return getRequest().getParameter(name);
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
     * @see com.mynms.core.FlexService#getParameterValues(java.lang.String)
     * @since v1.01
     */
    public String[] getParameterValues(String name) {
        return getRequest().getParameterValues(name);
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
}

