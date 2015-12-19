/*
 * @(#)DBException.java     v1.01, 2011-9-17
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.core.exception;

import com.mynms.core.base.BaseException;

/**
 * ClassName:   DBException.java
 * <p>在对数据库进行操作时产生异常时抛出的异常类。</p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-17 下午05:18:09
 */
public class DBException extends BaseException {

    /**
     * serialVersionUID:
     * <p>序列化ID</p>
     *
     * @since v1.01
     */
    private static final long serialVersionUID = -20621801095006382L;

    /**
     * DBException:
     * <p>默认的构造方法，构造一个新的 {@link DBException} 的实例。</p>
     *
     * @since   v1.01
     * @see     com.mynms.core.base.BaseException#BaseException()
     */
    public DBException() {
        super();
    }

    /**
     * DBException:
     * <p>带有消息，产生原因，是否抑制，是否打印堆栈跟踪参数的构造方法，
     * 构造一个新的 {@link DBException} 的实例。</p>
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
     * @see     com.mynms.core.base.BaseException#
     *              BaseException(String, Throwable, boolean, boolean)
     */
    public DBException(String message, Throwable cause,
                    boolean enableSuppression, boolean writableStackTrace,
                    ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode);
    }

    /**
     * DBException:
     * <p>带有消息，产生原因参数的构造方法，
     * 构造一个新的 {@link DBException} 的实例。</p>
     *
     * @param   message
     *          - {@link String} 类型的消息
     * @param   cause
     *          - {@link Throwable} 类型的产生原因
     * @param   errorCode
     *          - {@link ErrorCode} 类型的错误代码
     *
     * @since   v1.01
     * @see     com.mynms.core.base.BaseException#
     *              BaseException(String, Throwable, ErrorCode)
     */
    public DBException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    /**
     * DBException:
     * <p>带有消息参数的构造方法，
     * 构造一个新的 {@link DBException} 的实例。</p>
     *
     * @param   message
     *          - {@link String} 类型的消息
     *
     * @since   v1.01
     * @see      com.mynms.core.base.BaseException#BaseException(String)
     */
    public DBException(String message) {
        super(message);
    }

    /**
     * DBException:
     * <p>带有产生原因参数的构造方法，
     * 构造一个新的 {@link DBException} 的实例。</p>
     *
     * @param   cause
     *          - {@link Throwable} 类型的产生原因
     *
     * @since   v1.01
     * @see     com.mynms.core.base.BaseException#BaseException(Throwable)
     */
    public DBException(Throwable cause) {
        super(cause);
    }

    /**
     * DBException:
     * <p>带有错误代码参数的构造方法，
     * 构造一个新的 {@link DBException} 的实例。</p>
     *
     * @param   errorCode
     *          - {@link ErrorCode} 类型的错误代码
     *
     * @since   v1.01
     * @see     com.mynms.core.base.BaseException#BaseException(ErrorCode)
     */
    public DBException(ErrorCode errorCode) {
        super(errorCode);
    }
}

