/*
 * @(#)ErrorCode.java     v1.01, 2012-5-3
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core.exception;

import java.io.Serializable;

/**
 * ClassName:   ErrorCode.java
 * <p>{@link ErrorCode} 产生异常所带的错误代码。</p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-5-3 下午04:48:05
 */
public class ErrorCode implements Serializable {

    /**
     * serialVersionUID:
     * <p>序列化ID</p>
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -4501386275814656703L;

    /**
     * errorCode:
     * <p>错误代码</p>
     *
     * @since   v1.01
     */
    private int errorCode;

    /**
     * error:
     * <p>错误信息</p>
     *
     * @since   v1.01
     */
    private String error;

    /**
     * ErrorCode:
     * <p>带有错误代码和错误信息的构造方法，创建一个{@link ErrorCode} 的实例。</p>
    ·*
     * @param   errorCode
     *          - {@link Integer} 类型的错误代码
     * @param   error
     *          - {@link String} 类型的错误信息
     *
     * @since   v1.01
     */
    public ErrorCode(int errorCode, String error) {
        super();
        this.errorCode = errorCode;
        this.error = error;
    }

    /**
     * getErrorCode:
     * <p>获取错误代码</p>
     *
     * @return  {@link Integer}
     *          - {@link Integer} 类型的错误代码
     * @since   v1.01
     */
    public int getErrorCode() {
        return this.errorCode;
    }

    /**
     * setErrorCode:
     * <p>设置错误代码</p>
     *
     * @param   errorCode
     *          - {@link Integer} 类型的错误代码
     * @since   v1.01
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * getError:
     * <p>获取错误信息</p>
     *
     * @return  {@link String}
     *          - {@link String} 类型的错误信息
     * @since   v1.01
     */
    public String getError() {
        return this.error;
    }

    /**
     * setError:
     * <p>设置错误信息</p>
     *
     * @param   error
     *          - {@link String} 类型的错误信息
     * @since   v1.01
     */
    public void setError(String error) {
        this.error = error;
    }

//    public static ErrorCode getInstance(int errorCode) {
//        String error = "";
//        switch (errorCode) {
//        case DAO_EXCEPTION_DELETE_ENTITY:
//            error = "从数据库中删除实例失败";
//            break;
//
//        default:
//            break;
//        }
//        return new ErrorCode(errorCode, error);
//    }

}

