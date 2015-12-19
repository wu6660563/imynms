/*
 * @(#)BaseVo.java     v1.01, 2011-9-17
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.core.base;

import java.io.Serializable;

import com.mynms.core.POJO;

/**
 * ClassName:BasePOJO 基础数据模型类
 * <p>{@link BasePOJO} 基础数据模型类，用于对数据的封装。</p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-17 上午11:53:23
 */
public abstract class BasePOJO implements POJO , Serializable {

    /**
     * serialVersionUID:序列化ID
     *
     * @since v1.01
     */
    private static final long serialVersionUID = -8933405241019696999L;

    /**
     * toString:
     * <p>重写 toString 方法，便于以后调试。</p>
     *
     * @return {@link String}
     *          - 返回 {@link POJO} 实例的 {@link String} 表现形式。
     * @see java.lang.Object#toString()
     * @see POJO#toString()
     */
    public abstract String toString();

}

