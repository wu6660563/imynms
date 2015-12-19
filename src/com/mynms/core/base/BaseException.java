/*
 * @(#)BaseException.java     v1.01, 2011-9-17
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
*/


package com.mynms.core.base;

import com.mynms.core.exception.ErrorCode;

/**
 * ClassName:BaseException 基础异常类
 * <p>该类为基础异常类，所有异常</p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-17 下午05:16:36
 */
public class BaseException extends Exception {

    /**
     * serialVersionUID:序列化id
     *
     * @since v1.01
     */
    private static final long serialVersionUID = -5356139574722243031L;

    /**
     * errorCode:
     * <p>错误代码</p>
     *
     * @since   v1.01
     */
    protected ErrorCode errorCode;

    /**
     * BaseException:
     * <p>默认的构造方法，构造一个新的 {@link BaseException} 的实例。</p>
     *
     * @since   v1.01
     * @see     java.lang.Exception#Exception()
     */
    public BaseException() {
        super();
    }

    /**
     * BaseException:
     * <p>带有消息，产生原因，是否抑制，是否打印堆栈跟踪，错误代码参数的构造方法，
     * 构造一个新的 {@link BaseException} 的实例。</p>
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
     * @see     java.lang.Exception#
     *              Exception(String, Throwable, boolean, boolean)
     */
    public BaseException(String message, Throwable cause,
                    boolean enableSuppression, boolean writableStackTrace,
                    ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        setErrorCode(errorCode);
    }

    /**
     * BaseException:
     * <p>带有消息，产生原因，错误代码参数的构造方法，
     * 构造一个新的 {@link BaseException} 的实例。</p>
     *
     * @param   message
     *          - {@link String} 类型的消息
     * @param   cause
     *          - {@link Throwable} 类型的产生原因
     * @param   errorCode
     *          - {@link ErrorCode} 类型的错误代码
     *
     * @since   v1.01
     * @see     java.lang.Exception#Exception(String, Throwable)
     */
    public BaseException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        setErrorCode(errorCode);
    }

    /**
     * BaseException:
     * <p>带有消息参数的构造方法，
     * 构造一个新的 {@link BaseException} 的实例。</p>
     *
     * @param   message
     *          - {@link String} 类型的消息
     *
     * @since   v1.01
     * @see     java.lang.Exception#Exception(String)
     */
    public BaseException(String message) {
        super(message);
    }

    /**
     * BaseException:
     * <p>带有产生原因参数的构造方法，
     * 构造一个新的 {@link BaseException} 的实例。</p>
     *
     * @param   cause
     *          - {@link Throwable} 类型的产生原因
     *
     * @since   v1.01
     * @see     java.lang.Exception#Exception(Throwable)
     */
    public BaseException(Throwable cause) {
        super(cause);
    }

    /**
     * BaseException:
     * <p>带有错误代码参数的构造方法，
     * 构造一个新的 {@link BaseException} 的实例。</p>
     *
     * @param   errorCode
     *          - {@link ErrorCode} 类型的错误代码
     *
     * @since   v1.01
     * @see     java.lang.Exception#Exception()
     */
    public BaseException(ErrorCode errorCode) {
        super();
        setErrorCode(errorCode);
    }

    /**
     * getErrorCode:
     * <p>获取错误代码
     *
     * @return  {@link ErrorCode}
     *          - {@link ErrorCode} 类型的错误代码
     * @since   v1.01
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * setErrorCode:
     * <p>设置错误代码
     *
     * @param   errorCode
     *          - {@link ErrorCode} 类型的错误代码
     * @since   v1.01
     */
    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}

