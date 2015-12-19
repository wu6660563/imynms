/*
 * @(#)DAOException.java     v1.01, 2012-5-2
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core.exception;

/**
 * ClassName:   DAOException.java
 * <p>在使用 {@link DAO} 类产生异常时抛出的异常类。</p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-23 下午08:13:25
 */
public class DAOException extends DBException {

    /**
     * DELETE:
     * <p>从数据库中删除实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DELETE_ENTITY =
        ErrorCodeConstant.DAO_EXCEPTION_DELETE_ENTITY;

    /**
     * DELETE_ALL_ENTITY:
     * <p>从数据库中删除多个实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode DELETE_ALL_ENTITIES =
        ErrorCodeConstant.DAO_EXCEPTION_DELETE_ALL_ENTITIES;

    /**
     * SAVE_ENTITY:
     * <p>保存实例至数据库中</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode SAVE_ENTITY =
        ErrorCodeConstant.DAO_EXCEPTION_SAVE_ENTITY;

    /**
     * SAVE_ALL_ENTITIES:
     * <p>保存多个实例至数据库中失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode SAVE_ALL_ENTITIES =
        ErrorCodeConstant.DAO_EXCEPTION_SAVE_ALL_ENTITIES;

    /**
     * UPDATE_ENTITY:
     * <p>更新数据中实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode UPDATE_ENTITY =
        ErrorCodeConstant.DAO_EXCEPTION_UPDATE_ENTITY;

    /**
     * UPDATE_ALL_ENTITIES:
     * <p>更新数据中多个实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode UPDATE_ALL_ENTITIES =
        ErrorCodeConstant.DAO_EXCEPTION_UPDATE_ALL_ENTITIES;

    /**
     * SAVE_OR_UPDATE_ENTITY:
     * <p>保存或更新数据中实例失败
     *
     * @since   v1.01
     */
    public static final ErrorCode SAVE_OR_UPDATE_ENTITY =
        ErrorCodeConstant.DAO_EXCEPTION_SAVE_OR_UPDATE_ENTITY;

    /**
     * SAVE_OR_UPDATE_ALL_ENTITIES:
     * <p>保存或更新数据中多个实例失败
     *
     * @since   v1.01
     */
    public static final ErrorCode SAVE_OR_UPDATE_ALL_ENTITIES =
        ErrorCodeConstant.DAO_EXCEPTION_SAVE_OR_UPDATE_ALL_ENTITIES;

    /**
     * FIND_BY_RPOPERTY:
     * <p>通过参数从数据库中查找实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode FIND_BY_RPOPERTY =
        ErrorCodeConstant.DAO_EXCEPTION_FIND_BY_RPOPERTY;

    /**
     * LOAD_ALL:
     * <p>从数据库中加载所有实例失败
     *
     * @since   v1.01
     */
    public static final ErrorCode LOAD_ALL =
        ErrorCodeConstant.DAO_EXCEPTION_LOAD_ALL;

    /**
     * FIND_BY_RPOPERTIES:
     * <p>通过多个参数从数据库中查找实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode FIND_BY_RPOPERTIES =
        ErrorCodeConstant.DAO_EXCEPTION_FIND_BY_RPOPERTIES;

    /**
     * FIND_BY_HQL:
     * <p>通过 HQL 语句从数据库中查找实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode FIND_BY_HQL =
        ErrorCodeConstant.DAO_EXCEPTION_FIND_BY_HQL;

    /**
     * FIND_BY_HQL_AND_PARAMS:
     * <p>通过 HQL 语句以及参数从数据库中查找实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode FIND_BY_HQL_AND_PARAMS =
        ErrorCodeConstant.DAO_EXCEPTION_FIND_BY_HQL_AND_PARAMS;


    /**
     * FIND_BY_ENTITY_ID:
     * <p>通过主键ID从数据库中查找实例失败</p>
     *
     * @since   v1.01
     */
    public static final ErrorCode FIND_BY_ENTITY_ID =
        ErrorCodeConstant.DAO_EXCEPTION_FIND_BY_ENTITY_ID;

    /**
     * FIND_BY_PAGE:
     * <p>通过分页查询从数据库中查找实例失败
     *
     * @since   v1.01
     */
    public static final ErrorCode FIND_BY_PAGE =
        ErrorCodeConstant.DAO_EXCEPTION_FIND_BY_PAGE;
    /**
     * serialVersionUID:
     * <p>序列化ID</p>
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = 8324959993808793128L;

    /**
     * DAOException:
     * <p>默认的构造方法，构造一个新的 {@link DAOException} 的实例。</p>
     *
     * @since   v1.01
     * @see     com.mynms.core.exception.DBException#DBException()
     */
    public DAOException() {
        super();
    }

    /**
     * DAOException:
     * <p>带有消息，产生原因，是否抑制，是否打印堆栈跟踪参数的构造方法，
     * 构造一个新的 {@link DAOException} 的实例。</p>
     *
     * @param   message
     *          - {@link String} 类型的消息
     * @param   cause
     *          - {@link Throwable} 类型的产生原因
     * @param   enableSuppression
     *          - {@link Boolean} 类型的是否抑制
     * @param   writableStackTrace
     *          - {@link Boolean} 类型的是否打印堆栈跟踪
     * @param   errorCode
     *          - {@link ErrorCode} 类型的错误代码
     *
     * @since   v1.01
     * @see     com.mynms.core.exception.DBException#
     *              DBException(String, Throwable, boolean, boolean, ErrorCode)
     */
    public DAOException(String message, Throwable cause,
                    boolean enableSuppression, boolean writableStackTrace,
                    ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode);
    }

    /**
     * DAOException:
     * <p>带有消息，产生原因参数的构造方法，
     * 构造一个新的 {@link DAOException} 的实例。</p>
     *
     * @param   message
     *          - {@link String} 类型的消息
     * @param   cause
     *          - {@link Throwable} 类型的产生原因
     * @param   errorCode
     *          - {@link ErrorCode} 类型的错误代码
     *
     * @since   v1.01
     * @see     com.mynms.core.exception.DBException#
     *              DBException(String, Throwable, ErrorCode)
     */
    public DAOException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    /**
     * DAOException:
     * <p>带有消息参数的构造方法，
     * 构造一个新的 {@link DAOException} 的实例。</p>
     *
     * @param   message
     *          - {@link String} 类型的消息
     *
     * @since   v1.01
     * @see      com.mynms.core.exception.DBException#DBException(String)
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * DAOException:
     * <p>带有产生原因参数的构造方法，
     * 构造一个新的 {@link DAOException} 的实例。</p>
     *
     * @param   cause
     *          - {@link Throwable} 类型的产生原因
     *
     * @since   v1.01
     * @see     com.mynms.core.exception.DBException#DBException(Throwable)
     */
    public DAOException(Throwable cause) {
        super(cause);
    }

    /**
     * DAOException:
     * <p>带有错误代码参数的构造方法，
     * 构造一个新的 {@link DAOException} 的实例。</p>
     *
     * @param   errorCode
     *          - {@link ErrorCode} 类型的错误代码
     *
     * @since   v1.01
     * @see     com.mynms.core.exception.DBException#DBException(ErrorCode)
     */
    public DAOException(ErrorCode errorCode) {
        super(errorCode);
    }

}

