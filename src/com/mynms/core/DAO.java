/*
 * @(#)Dao.java     v1.01, 2011-9-11
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.Result;
import com.mynms.core.exception.DAOException;

/**
 * ClassName:DAO 数据访问接口
 * <p>
 * {@link DAO} 数据访问接口(Data Access Object)， 用于封装对数据库的操作。每一个 {@link DAO} 实例都应该从
 * {@link com.mynms.core.base.DAOSupportFactory} 中获取一个 {@link DAOSupport}
 * 实例来提供对数据库操作的支持， 而不是直接对数据库进行操作
 * </p>
 * 
 * @param <T> -
 *            必须使用需要处理的 {@link POJO} 的实例作为参数传入。
 * @param <K> -
 *            必须使用需要处理的 {@link POJO} 的实例的主键作为参数传入， 该参数类型必须实现序列化，为实例的主键类型。
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2011-9-11 下午01:29:24
 */
public interface DAO<T extends POJO, K extends Serializable> {

	/**
	 * delete:
	 * <p>
	 * 从数据库中删除 {@link POJO} 的实例。
	 * </p>
	 * 
	 * @param entity -
	 *            POJO 实例
	 * @throws DAOException -
	 *             抛出 {@link DAO} 操作异常
	 * @since v1.01
	 */
	void delete(T entity) throws DAOException;

	/**
	 * deleteAll:
	 * <p>
	 * 从数据库中删除多个 {@link POJO} 的实例。
	 * </p>
	 * 
	 * @param entities -
	 *            {@link POJO} 集合
	 * @throws DAOException -
	 *             抛出 {@link DAO} 操作异常
	 * @since v1.01
	 */
	void deleteAll(Collection<T> entities) throws DAOException;

	/**
	 * deleteAll:
	 * <p>
	 * 从数据库中删除所有 {@link POJO} 的实例。
	 * </p>
	 * 
	 * @param clazz - -
	 *            {@link POJO} 实例
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	void deleteAll(Class<T> clazz) throws DAOException;

	/**
	 * save:
	 * <p>
	 * 保存 {@link POJO} 实例至数据库中。
	 * </p>
	 * 
	 * @param entity -
	 *            POJO 实例
	 * @return {@link K} - {@link K} 类型的主键
	 * @throws DAOException -
	 *             抛出 {@link DAO} 操作异常
	 * @since v1.01
	 */
	K save(T entity) throws DAOException;

	/**
	 * saveBatch:
	 * <p>
	 * 批量保存 {@link POJO} 实例至数据库中。
	 * </p>
	 * 
	 * @param entities -
	 *            POJO 实例的集合
	 * @throws DAOException -
	 *             抛出 {@link DAO} 操作异常
	 * @since v1.01
	 */
	void saveBatch(Collection<T> entities) throws DAOException;

	/**
	 * update:
	 * <p>
	 * 从数据库中删除 {@link POJO} 的实例。
	 * </p>
	 * 
	 * @param entity -
	 *            POJO 实例
	 * @throws DAOException -
	 *             抛出 {@link DAO} 操作异常
	 * @since v1.01
	 */
	void update(T entity) throws DAOException;

	/**
	 * updateBatch:
	 * <p>
	 * 从数据库中批量删除 {@link POJO} 的实例。
	 * </p>
	 * 
	 * @param entities -
	 *            POJO 实例集合
	 * @throws DAOException -
	 *             抛出 {@link DAO} 操作异常
	 * @since v1.01
	 */
	void updateBatch(Collection<T> entities) throws DAOException;

	/**
	 * saveOrUpdate:
	 * <p>
	 * 保存或者修改数据库中 {@link POJO} 的实例。
	 * 
	 * @param entity -
	 *            POJO 实例
	 * @throws DAOException -
	 *             抛出数据库异常
	 * 
	 * @since v1.01
	 */
	void saveOrUpdate(T entity) throws DAOException;

	/**
	 * saveOrUpdateAll:
	 * <p>
	 * 批量保存或者修改数据库中 {@link POJO} 的实例。
	 * 
	 * @param entities -
	 *            POJO 实例集合
	 * @throws DAOException -
	 *             抛出数据库异常
	 * 
	 * @since v1.01
	 */
	void saveOrUpdateAll(Collection<T> entities) throws DAOException;

	/**
	 * find:
	 * <p>
	 * 通过参数从数据库中查找 {@link POJO} 实例的 {@link List}。
	 * </p>
	 * 
	 * @param clazz -
	 *            {@link POJO} 类实例的 {@link Class}
	 * @param prop -
	 *            {@link POJO} 类属性名称
	 * @param value -
	 *            {@link POJO} 类属性对应的值
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	List<T> find(Class<T> clazz, String prop, Object value) throws DAOException;

	/**
	 * find:
	 * <p>
	 * 通过多个参数从数据库中查找 {@link POJO} 实例的 {@link List}。
	 * </p>
	 * 
	 * @param clazz -
	 *            {@link POJO} 类实例的 {@link Class}
	 * @param props -
	 *            {@link POJO} 类属性名称的数组
	 * @param values -
	 *            {@link POJO} 类属性对应的值的数组
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	List<T> find(Class<T> clazz, String[] props, Object[] values)
			throws DAOException;

	/**
	 * find:
	 * <p>
	 * 通过HQL语句查找 {@link POJO} 实例的 {@link List}
	 * </p>
	 * 
	 * @param hql -
	 *            HQL 语句
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	List<T> find(String hql) throws DAOException;

	/**
	 * find:
	 * <p>
	 * 通过HQL语句以及参数值查找 {@link POJO} 实例的 {@link List}
	 * </p>
	 * 
	 * @param hql -
	 *            HQL 语句
	 * @param params -
	 *            {@link POJO} 类属性对应的值的数组，该数组的顺序应该与 HQL 语句中的 参数位置对应
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}
	 * @throws DAOException -
	 *             抛出 {@link DAO} 操作异常
	 * @since v1.01
	 */
	List<T> find(String hql, Object[] params) throws DAOException;

	/**
	 * get:
	 * <p>
	 * 通过 id 从数据库中查找 {@link POJO} 实例。如果没有匹配的则返回 <code>null</code> 。
	 * </p>
	 * 
	 * @param clazz -
	 *            {@link POJO} 类实例的 {@link Class}
	 * @param id -
	 *            {@link POJO} 类的 {@link K} 类型 <code>id</code> 的值
	 * @return {@link POJO} - 返回 {@link POJO} 实例
	 * @throws DAOException -
	 *             抛出 {@link DAO} 操作异常
	 * @since v1.01
	 */
	T get(Class<T> clazz, K id) throws DAOException;

	/**
	 * loadAll:
	 * <p>
	 * 从数据库中加载所有实例
	 * 
	 * @param clazz -
	 *            POJO 实例
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	List<T> loadAll(Class<T> clazz) throws DAOException;

	/**
	 * findByPage:
	 * <p>
	 * 通过{@link POJO} 类实例的 {@link Class} 对象， 以及 {@link Page} 对象，分页查询结果集。
	 * 
	 * @param clazz -
	 *            {@link POJO} 类实例的 {@link Class}
	 * @param page -
	 *            {@link Page} 类型的分页对象
	 * @return {@link List<T>} - 返回查询后的结果
	 * @throws DAOException -
	 *             抛出数据库异常
	 * 
	 * @since v1.01
	 */
	Result<T> findByPage(Class<T> clazz, Page page) throws DAOException;

	/**
	 * findByPage:
	 * <p>
	 * <通过{@link POJO} 类实例的 {@link Class} 对象，查询条件的参数名称和对应参数值 以及 {@link Page}
	 * 对象，分页查询结果集。
	 * 
	 * @param clazz -
	 *            {@link POJO} 类实例的 {@link Class}
	 * @param propertyName -
	 *            查询条件的参数名称
	 * @param value -
	 *            查询条件对应的参数值
	 * @param page -
	 *            {@link Page} 类型的分页对象
	 * @return {@link List<T>} - 返回查询后的结果
	 * @throws DAOException -
	 *             抛出数据库异常
	 * 
	 * @since v1.01
	 */
	Result<T> findByPage(Class<T> clazz, String propertyName, Object value,
			Page page) throws DAOException;

	/**
	 * findByPage:
	 * <p>
	 * <通过{@link POJO} 类实例的 {@link Class} 对象，查询条件的参数名称和对应参数值 以及 {@link Page}
	 * 对象，分页查询结果集。
	 * 
	 * @param clazz -
	 *            {@link POJO} 类实例的 {@link Class}
	 * @param propertyName -
	 *            查询条件的参数名称
	 * @param value -
	 *            查询条件对应的参数值
	 * @param isLike -
	 *            查询条件是否使用like模糊查询
	 * @param page -
	 *            {@link Page} 类型的分页对象
	 * @return {@link List<T>} - 返回查询后的结果
	 * @throws DAOException -
	 *             抛出数据库异常
	 * 
	 * @since v1.01
	 */
	Result<T> findByPage(Class<T> clazz, String propertyName, Object value,
			Boolean isLike, Page page) throws DAOException;

	/**
	 * findByPage:
	 * <p>
	 * <通过{@link POJO} 类实例的 {@link Class} 对象，查询条件的多个参数名称和对应参数值 以及 {@link Page}
	 * 对象，分页查询结果集。
	 * 
	 * @param clazz -
	 *            {@link POJO} 类实例的 {@link Class}
	 * @param propertyNames -
	 *            查询条件的参数名称数组
	 * @param values -
	 *            查询条件对应的参数值数组
	 * @param page -
	 *            {@link Page} 类型的分页对象
	 * @return {@link List<T>} - 返回查询后的结果
	 * @throws DAOException -
	 *             抛出数据库异常
	 * 
	 * @since v1.01
	 */
	Result<T> findByPage(Class<T> clazz, String[] propertyNames,
			Object[] values, Page page) throws DAOException;

	/**
	 * findByPage:
	 * <p>
	 * <通过{@link POJO} 类实例的 {@link Class} 对象，查询条件的多个参数名称和对应参数值 以及 {@link Page}
	 * 对象，分页查询结果集。
	 * 
	 * @param clazz -
	 *            {@link POJO} 类实例的 {@link Class}
	 * @param propertyNames -
	 *            查询条件的参数名称数组
	 * @param values -
	 *            查询条件对应的参数值数组
	 * @param isLikes -
	 *            查询条件对应的参数的模糊查询条件数组
	 * @param page -
	 *            {@link Page} 类型的分页对象
	 * @return {@link List<T>} - 返回查询后的结果
	 * @throws DAOException -
	 *             抛出数据库异常
	 * 
	 * @since v1.01
	 */
	Result<T> findByPage(Class<T> clazz, String[] propertyNames,
			Object[] values, Boolean[] isLikes, Page page) throws DAOException;
}
