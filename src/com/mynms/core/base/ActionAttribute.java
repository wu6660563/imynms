
package com.mynms.core.base;

import java.util.Enumeration;
import java.util.Hashtable;



/**
 * ClassName:ActionAttribute 请求操作的属性类
 * <p>请求操作的属性类，用于连接前台 与 后台逻辑控制类{@link Manager} 的参数与属性传递。</p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-21 下午07:53:28
 */
public class ActionAttribute {

    /**
     * 参数 {@link Map} 对象，用于保存前端传入的参数
     */ 
    private Hashtable<String, Object> parameterMap = null;

    /**
     * 属性 {@link Map} 对象，用于保存后台返回的结果
     */
    private Hashtable<String, Object> attributeMap = null;

    /**
     * ActionAttribute:
     * <p>默认的构造方法，创建 {@link ActionAttribute} 的实例。</p>
     *
     * @since   v1.01
     */
    public ActionAttribute() {
        super();
        parameterMap = new Hashtable<String, Object>();
        attributeMap = new Hashtable<String, Object>();
    }

    /**
     * getParameterMap:
     * <p>获取参数 {@link Map} 对象。</p>
     *
     * @return  {@link Hashtable}
     *          - 参数 {@link Map} 对象
     * @since   v1.01
     */
    protected Hashtable<String, Object> getParameterMap() {
        return parameterMap;
    }

    /**
     * getAttributeMap:
     * <p>获取属性 {@link Map} 对象。</p>
     *
     * @return  {@link Map}
     *          - 参数 {@link Map} 对象
     * @since   v1.01
     */
    protected Hashtable<String, Object> getAttributeMap() {
        return attributeMap;
    }


    /**
     * getAttribute:
     * <p>获取属性值，
     * 该属性名称为 <code>name</code> ，
     * 如果不存在以 <code>name</code> 为名称的属性，则返回 <code>null</code> 。</p>
     *
     * @param   name
     *          - 类型为 {@link String} 的属性名称
     * @return  {@link Object}
     *          - 属性对象
     *
     * @since   v1.01
     * @see     #setAttribute(String, Object)
     * @see     #removeAttribute(String)
     */
    public Object getAttribute(String name) {
        return getAttributeMap().get(name);
    }

    /**
     * getAttributeNames:
     * <p>获取属性名称的枚举 {@link Enumeration}</p>
     *
     * @return  {@link Enumeration}
     *          - 属性名称的枚举 {@link Enumeration}
     * @since  v1.01
     */
    public Enumeration<Object> getAttributeNames() {
        return getAttributeMap().elements();

    }

    /**
     * getParameter:
     * <p>获取前台传入的参数，
     * 该参数值的类型为 {@link String}</p>
     *
     * @param name
     *          - 前台传入的参数名称
     * @return {@link String}
     *          - 前台传入的参数值，
     *            该参数类型为 {@link String} 。
     * @since  v1.01
     */
    public String getParameter(String name) {
        return (String) getParameterMap().get(name);
    }

    /**
     * getParameterNames:
     * <p>获取前台传入参数名称的枚举 {@link Enumeration}</p>
     *
     * @return {@link Enumeration}
     *          - 前台传入参数名称的枚举 {@link Enumeration}
     * @since  v1.01
     */
    public Enumeration<Object> getParameterNames() {
        return getParameterMap().elements();

    }

    /**
     * getParameterValues:
     * <p>获取前台传入的参数，
     * 该参数类型为 {@link String} 的数组。</p>
     *
     * @param name
     *          - 前台传入的参数名称
     * @return {@link String}
     *          - 前台传入的参数，
     *            该参数类型为 {@link String} 的数组。
     * @since  v1.01
     */
    public String[] getParameterValues(String name) {
        return (String[]) getParameterMap().get(name);
    }

    /**
     * removeRequestAttribute:
     * <p>删除属性，该属性名称为 <code>name</code> 。
     *
     * @param   name
     *          - 属性名称
     * @since   v1.01
     */
    public void removeAttribute(String name) {
        getAttributeMap().remove(name);
    }

    /**
     * setAttribute:
     * <p>设置属性。</p>
     *
     * @param   name
     *          - 属性名称
     * @param   object
     *          - 属性对象
     * @since   v1.01
     * @see     #getAttribute(String)
     * @see     #removeAttribute(String)
     */
    public void setAttribute(String name, Object object) {
        getAttributeMap().put(name, object);
    }

}

