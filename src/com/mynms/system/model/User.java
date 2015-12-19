/*
 * @(#)User.java     v1.01, 2012-5-1
 *
 * Copyright (c) 2012, TNT All Rights Reserved.
 */

package com.mynms.system.model;

import com.mynms.core.base.BasePOJO;

/**
 * ClassName:   User.java
 * <p>用户，记录系统中用户信息</p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2011-9-23 下午08:13:25
 */
public class User extends BasePOJO {

    /**
     * serialVersionUID:
     * <p>序列化ID</p>
     *
     * @since   v1.01
     */
    private static final long serialVersionUID = -3276893728472876257L;

    // Fields

    /**
     * id:
     * <p>用户标示</p>
     *
     * @since   v1.01
     */
    private int id;

    /**
     * userCode:
     * <p>用户编号</p>
     *
     * @since   v1.01
     */
    private String userCode;

    /**
     * userName:
     * <p>用户名</p>
     *
     * @since   v1.01
     */
    private String userName;

    /**
     * password:
     * <p>密码</p>
     *
     * @since   v1.01
     */
    private String password;

    /**
     * phoneNumber:
     * <p>电话号码，发送电话告警时使用</p>
     *
     * @since   v1.01
     */
    private String phoneNumber;

    /**
     * mobileNumber:
     * <p>手机号码，发送短信告警时使用</p>
     *
     * @since   v1.01
     */
    private String mobileNumber;

    /**
     * email:
     * <p>电子邮箱，发送电子邮件告警时使用</p>
     *
     * @since   v1.01
     */
    private String email;

    /**
     * createTime:
     * <p>创建时间，以'yyyy-MM-dd HH:mm:ss'形式存放</p>
     *
     * @since   v1.01
     */
    private String createTime;

    /**
     * userRole:
     * <p>用户所属角色的对应关系类，从而获取用户所属角色</p>
     *
     * @since   v1.01
     */
    private UserRole userRole;

    /**
     * User:
     * <p>默认的构造方法，构造一个新 {@link User} 的实例</p>
     *
     * @since   v1.01
     */
    public User() {
    }

    /**
     * getId:
     * <p>获取用户标示</p>
     *
     * @return  {@link Integer}
     *          - {@link Integer} 类型的用户标示
     * @since   v1.01
     */
    public int getId() {
        return id;
    }

    /**
     * setId:
     * <p>设置用户标示</p>
     *
     * @param   id
     *          - {@link Integer} 类型的用户标示
     * @since   v1.01
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getUserCode:
     * <p>获取用户编号</p>
     *
     * @return  {@link String}
     *          - {@link String} 类型的用户编号
     * @since   v1.01
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * setUserCode:
     * <p>设置用户编号</p>
     *
     * @param  userCode
     *          - {@link String} 类型的用户编号
     * @since   v1.01
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * getUserName:
     * <p>获取用户名</p>
     *
     * @return  {@link String}
     *          - {@link String} 类型的用户名
     * @since   v1.01
     */
    public String getUserName() {
        return userName;
    }

    /**
     * setUserName:
     * <p>设置用户名</p>
     *
     * @param   userName
     *          - {@link String} 类型的用户名
     * @since   v1.01
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * getPassword:
     * <p>获取密码</p>
     *
     * @return  {@link String}
     *          - {@link String} 类型的密码
     * @since   v1.01
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword:
     * <p>设置密码</p>
     *
     * @param   password
     *          - {@link String} 类型的密码
     * @since   v1.01
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getPhoneNumber:
     * <p>获取电话号码，发送电话告警时使用</p>
     *
     * @return  {@link String}
     *          - {@link String} 类型的电话号码
     * @since   v1.01
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * setPhoneNumber:
     * <p>设置电话号码，发送电话告警时使用</p>
     *
     * @param   phoneNumber
     *          - {@link String} 类型的电话号码
     * @since   v1.01
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * getMobileNumber:
     * <p>获取手机号码，发送短信告警时使用</p>
     *
     * @return  {@link String}
     *          - {@link String} 类型的手机号码
     * @since   v1.01
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * setMobileNumber:
     * <p>设置手机号码，发送短信告警时使用</p>
     *
     * @param   mobileNumber
     *          - {@link String} 类型的电话号码
     * @since   v1.01
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * getEmail:
     * <p>获取电子邮箱，发送电子邮箱告警时使用</p>
     *
     * @return  {@link String}
     *          - {@link String} 类型的电子邮箱
     * @since   v1.01
     */
    public String getEmail() {
        return email;
    }

    /**
     * setEmail:
     * <p>设置电子邮箱，发送电子邮箱告警时使用</p>
     *
     * @param  email
     *          - {@link String} 类型的电子邮箱
     * @since   v1.01
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getCreateTime:
     * <p>获取创建时间，以'yyyy-MM-dd HH:mm:ss'形式存放</p>
     *
     * @return  {@link String}
     *          - {@link String} 类型的创建时间
     * @since   v1.01
     */
    public String getCreateTime() {
        return createTime;
    }


    /**
     * setCreateTime:
     * <p>设置创建时间，以'yyyy-MM-dd HH:mm:ss'形式存放</p>
     *
     * @param  createTime
     *          - {@link String} 类型的创建时间
     * @since   v1.01
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * getUserRole:
     * <p>获取用户所属角色的对应关系类，从而获取用户所属角色</p>
     *
     * @return  {@link UserRole}
     *          - {@link UserRole} 的用户所属角色的对应关系
     * @since   v1.01
     */
    public UserRole getUserRole() {
        return userRole;
    }

    /**
     * setUserRole:
     * <p>设置用户所属角色的对应关系类，从而获取用户所属角色</p>
     *
     * @param  userRole
     *          - {@link UserRole} 的用户所属角色的对应关系
     * @since   v1.01
     */
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    /**
     * toString:
     * <p>{@link User} 实例的 {@link String} 表现形式。</p>
     *
     * @return  {@link String}
     *          - 返回 {@link User} 实例的 {@link String} 表现形式。
     * @since   v1.01
     * @see     com.mynms.core.base.BasePOJO#toString()
     */
    @Override
    public String toString() {
        return this.id + "\t" + this.userCode + "\t" + this.userName + "\t"
                + this.password + "\t" + this.phoneNumber + "\t"
                + this.mobileNumber + "\t" + this.email + "\t"
                + this.createTime;
    }

}

