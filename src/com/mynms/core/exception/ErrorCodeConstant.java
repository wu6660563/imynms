/*
 * @(#)ErrorCodeConstant.java     v1.01, 2012-5-3
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core.exception;

/**
 * ClassName:   ErrorCodeConstant.java
 * <p>{@link ErrorCodeConstant} 错误代码常量，包含所有异常中所有的错误代码。
 * 错误代码用5为的整数代表，其中：
 * <p>1: {@link DBException}
 * <p>   101: {@link DAOException}
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-5-3 下午06:05:02
 */
public class ErrorCodeConstant {

    /**
     * DAO_EXCEPTION_DELETE:
     * <p>从数据库中删除实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_DELETE_ENTITY =
        new ErrorCode(10101, "从数据库中删除实例失败");

    /**
     * DAO_EXCEPTION_DELETE_ALL_ENTITY:
     * <p>从数据库中删除多个实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_DELETE_ALL_ENTITIES =
        new ErrorCode(10102, "从数据库中删除多个实例失败");

    /**
     * DAO_EXCEPTION_SAVE_ENTITY:
     * <p>保存实例至数据库中</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_SAVE_ENTITY =
        new ErrorCode(10104, "保存实例至数据库中失败");

    /**
     * DAO_EXCEPTION_SAVE_ALL_ENTITIES:
     * <p>保存多个实例至数据库中失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_SAVE_ALL_ENTITIES =
        new ErrorCode(10105, "保存多个实例至数据库中失败");

    /**
     * DAO_EXCEPTION_UPDATE_ENTITY:
     * <p>更新数据中实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_UPDATE_ENTITY =
        new ErrorCode(10105, "更新数据中实例失败");

    /**
     * DAO_EXCEPTION_UPDATE_ALL_ENTITIES:
     * <p>更新数据中多个实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_UPDATE_ALL_ENTITIES =
        new ErrorCode(10106, "更新数据中多个实例失败");

    /**
     * DAO_EXCEPTION_UPDATE_ENTITY:
     * <p>保存或更新数据中实例失败
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_SAVE_OR_UPDATE_ENTITY =
        new ErrorCode(10107, "保存或更新数据中实例失败");

    /**
     * DAO_EXCEPTION_UPDATE_ALL_ENTITIES:
     * <p>保存或更新数据中多个实例失败
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_SAVE_OR_UPDATE_ALL_ENTITIES =
        new ErrorCode(10108, "保存或更新数据中多个实例失败");

    /**
     * DAO_EXCEPTION_LOAD_ALL:
     * <p>从数据库中加载所有实例失败
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_LOAD_ALL =
        new ErrorCode(10109, "从数据库中加载所有实例失败");

    /**
     * DAO_EXCEPTION_FIND_BY_RPOPERTY:
     * <p>通过参数从数据库中查找实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_FIND_BY_RPOPERTY =
        new ErrorCode(10110, "通过参数从数据库中查找实例失败");

    /**
     * DAO_EXCEPTION_FIND_BY_RPOPERTIES:
     * <p>通过多个参数从数据库中查找实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_FIND_BY_RPOPERTIES =
        new ErrorCode(10111, "通过多个参数从数据库中查找实例失败");

    /**
     * DAO_EXCEPTION_FIND_BY_HQL:
     * <p>通过 HQL 语句从数据库中查找实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_FIND_BY_HQL =
        new ErrorCode(10112, "通过 HQL 语句从数据库中查找实例失败");

    /**
     * DAO_EXCEPTION_FIND_BY_HQL_AND_PARAMS:
     * <p>通过 HQL 语句以及参数从数据库中查找实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_FIND_BY_HQL_AND_PARAMS =
        new ErrorCode(10113, "通过 HQL 语句以及参数从数据库中查找实例失败");

    /**
     * DAO_EXCEPTION_FIND_BY_ENTITY_ID:
     * <p>通过主键ID从数据库中查找实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_FIND_BY_ENTITY_ID =
        new ErrorCode(10114, "通过主键ID从数据库中查找实例失败");

    /**
     * DAO_EXCEPTION_FIND_BY_PAGE:
     * <p>通过分页查询从数据库中查找实例失败
     *
     * @since   v1.01
     */
    public static final ErrorCode DAO_EXCEPTION_FIND_BY_PAGE =
        new ErrorCode(10114, "通过分页查询从数据库中查找实例失败");
}

