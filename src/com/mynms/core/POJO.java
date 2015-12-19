/*
 * @(#)Model.java     v1.01, 2011-9-17
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.core;

/**
 * ClassName:POJO 数据模型接口
 * <p>{@link POJO} 数据模型接口，用于对数据的封装。</p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-17 上午11:44:12
 */
public interface POJO {

    /**
     * toString:
     * <p>重写 toString 方法，便于以后调试。</p>
     * @return {@link String}
     *          - 返回 {@link POJO} 实例的 {@link String} 表现形式。
     * @see java.lang.Object#toString()
     */
    String toString();
}

