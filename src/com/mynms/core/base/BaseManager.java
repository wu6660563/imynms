/*
 * @(#)BaseManager.java     v1.01, 2011-9-2
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.core.base;

import java.util.Enumeration;

import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.PaginationSupport;
import com.mynms.core.Manager;

/**
 * ClassName:BaseManager
 * <p>{@link BaseManager} 基础业务逻辑控制类，为所有业务逻辑控制类顶级父类，
 * 所有业务逻辑控制类都应该继承自 {@link BaseManager} 。</p>
 *
 * <p>{@link BaseManager} 中包含业务逻辑控制类的公共方法：
 *      <li>获取参数的方法。</li>
 *      <li>设置属性的方法。</li>
 * </p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-2 下午12:56:58
 *
 * @see Manager
 */
public class BaseManager implements Manager {


    // Fields

    /**
     * serialVersionUID:
     * <p>序列化ID
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = 3051387500791040048L;

    /**
     * managerAttribute:
     * <p> {@link Manager} 属性
     *
     * @since   v1.01
     */
    protected ManagerAttribute managerAttribute;

    /**
     * managerParameter:
     * <p> {@link Manager} 参数
     *
     * @since   v1.01
     */
    protected ManagerParameter managerParameter;

    /**
     * BaseManager:
     * <p>默认的构造方法，用于构造一个新的 {@link BaseManager} 实例。
     *
     * @since   v1.01
     */
    public BaseManager() {
        setManagerAttribute(new ManagerAttribute());
        setManagerParameter(new ManagerParameter());
    }


    // Getter And Setter

    /**
     * getManagerAttribute:
     * <p>获取 {@link #managerAttribute}
     *
     * @return  ManagerAttribute
     *          - {@link ManagerAttribute} 类型的 {@link Manager} 的属性
     * @since   v1.01
     */
    protected ManagerAttribute getManagerAttribute() {
        return managerAttribute;
    }

    /**
     * setManagerAttribute:
     * <p>设置 {@link #managerAttribute}
     *
     * @param   managerAttribute
     *          - {@link ManagerAttribute} 类型的 {@link Manager} 的属性
     * @since   v1.01
     */
    protected void setManagerAttribute(ManagerAttribute managerAttribute) {
        this.managerAttribute = managerAttribute;
    }

    /**
     * getManagerParameter:
     * <p>获取 {@link #getManagerParameter}
     *
     * @return  ManagerParameter
     *          - {@link ManagerParameter} 类型的 {@link Manager} 的参数
     * @since   v1.01
     */
    protected ManagerParameter getManagerParameter() {
        return managerParameter;
    }

    /**
     * setManagerParameter:
     * <p>设置 {@link #managerParameter}
     *
     * @param   managerParameter
     *          - {@link ManagerParameter} 类型的 {@link Manager} 的参数
     * @since   v1.01
     */
    protected void setManagerParameter(ManagerParameter managerParameter) {
        this.managerParameter = managerParameter;
    }


    // Method

    /**
     * getAttribute:
     * <p>获取名称为 <code>name</code> 的属性值，
     * 如果不存在以 <code>name</code> 为名称的属性，则返回 <code>null</code> 。
     *
     * @param   name
     *          - {@link String} 类型的属性名称
     * @return  {@link Object}
     *          - {@link Object} 类型的属性对象
     *
     * @since   v1.01
     * @see     #setAttribute(String, Object)
     * @see     #removeAttribute(String)
     * @see     com.mynms.core.Manager#getAttribute(java.lang.String)
     */
    public Object getAttribute(String name) {
        return getManagerAttribute().getAttribute(name);
    }

    /**
     * getAttributeNames:
     * <p>获取属性名称的枚举 {@link Enumeration<String>}</p>
     *
     * @return  {@link Enumeration<String>}
     *          - 属性名称的枚举 {@link Enumeration<String>}
     * @since   v1.01
     * @see     com.mynms.core.Manager#getAttributeNames()
     */
    public Enumeration<String> getAttributeNames() {
        return getManagerAttribute().getAttributeNames();
    }

    /**
     * getParameter:
     * * <p>获取名称为 <code>name</code> 的参数，
     * 如果不存在以 <code>name</code> 为名称的参数，则返回 <code>null</code> 。
     *
     * @param   name
     *          - {@link String} 类型的参数名称
     * @return  {@link Object}
     *          - {@link Object} 类型的参数对象
     * @since   v1.01
     * @see     com.mynms.core.Manager#getParameter(java.lang.String)
     */
    public Object getParameter(String name) {
        return getManagerParameter().getParameter(name);
    }

    /**
     * getParameterAsString:
     * <p>获取名称为 <code>name</code> 的参数，并以 {@link String}
     * 类型作为返回值。
     *
     * @param   name
     *          - {@link String} 类型的参数名称
     * @return  {@link String}
     *          - {@link String} 类型的参数对象
     *
     * @since   v1.01
     */
    public String getParameterAsString(String name) {
        String[] parameter = getParameterAsStringArray(name);
        if (parameter == null || parameter.length < 1) {
            return null;
        }
        return parameter[0];
    }

    /**
     * getParameterAsInt:
     * <p>获取名称为 <code>name</code> 的参数，并以 {@link Integer}
     * 类型作为返回值。
     *
     * @param   name
     *          - {@link String} 类型的参数名称
     * @return  {@link Integer}
     *          - {@link Integer} 类型的参数对象
     *
     * @since   v1.01
     */
    public Integer getParameterAsInt(String name) {
        String parameter = getParameterAsString(name);
        if (parameter == null ) {
            return null;
        }
        return Integer.parseInt(parameter);
    }

    /**
     * getParameterAsStringArray:
     * <p>获取名称为 <code>name</code> 的参数，并以 {@link String[]}
     * 类型作为返回值。
     *
     * @param   name
     *          - {@link String} 类型的参数名称
     * @return  {@link String[]}
     *          - {@link String[]} 类型的参数对象
     *
     * @since   v1.01
     */
    public String[] getParameterAsStringArray(String name) {
        return (String[]) getManagerParameter().getParameter(name);
    }

    /**
     * getParameterNames:
     * <p>获取参数名称的枚举 {@link Enumeration<String>}</p>
     *
     * @return  {@link Enumeration}
     *          - 参数名称的枚举 {@link Enumeration}
     * @since   v1.01
     * @see     com.mynms.core.Manager#getParameterNames()
     */
    public Enumeration<String> getParameterNames() {
        return getManagerParameter().getParameterNames();
    }

    /**
     * setAttribute:
     * <p>设置名称为 <code>name</code> 的属性 <code>attribute</code> 。
     *
     * @param   name
     *          - {@link String} 类型的参数名称
     * @param   attribute
     *          - {@link Object} 类型的属性对象
     *
     * @since   v1.01
     * @see     com.mynms.core.Manager#setAttribute(
     *                  java.lang.String, java.lang.Object)
     */
    public void setAttribute(String name, Object attribute) {
        getManagerAttribute().setAttribute(name, attribute);
    }

    /**
     * setParameter:
     * <p>设置名称为 <code>name</code> 的参数 <code>parameter</code> 。
     *
     * @param   name
     *          - {@link String} 类型的参数名称
     * @param   parameter
     *          - {@link Object} 类型的参数对象
     *
     * @since   v1.01
     * @see     com.mynms.core.Manager#setParameter(
     *                  java.lang.String, java.lang.Object)
     */
    public void setParameter(String name, Object parameter) {
        getManagerParameter().setParameter(name, parameter);
    }

    public Page createPageByParameter() {
        int pageSize = 0;
        int currentPage = 0;
        int totalCount = 0;
        try {
            Integer temp = getParameterAsInt("pageSize");
            if (temp != null) {
                pageSize = temp;
            }
            temp = getParameterAsInt("currentPage");
            if (temp != null) {
                currentPage = temp;
            }
            temp = getParameterAsInt("totalCount");
            if (temp != null) {
                totalCount = temp;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return PaginationSupport.createPage(pageSize, currentPage, totalCount);
    }

}

