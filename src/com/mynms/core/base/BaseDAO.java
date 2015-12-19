/*
 * @(#)BaseDAO.java     v1.01, 2011-9-11
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core.base;

import com.mynms.common.util.log.Log;
import com.mynms.common.util.log.LogFactory;
import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.Result;
import com.mynms.core.DAO;
import com.mynms.core.DAOSupport;
import com.mynms.core.POJO;
import com.mynms.core.exception.DAOException;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * ClassName:BaseDAO 基础数据访问类
 * <p>
 * {@link BaseDAO} 数据访问类，其继承自 {@link HibernateDaoSupport} 类，
 * 所有对数据库的访问操作，都应该集成自该类，其提供了一系列通用的访问数据的方法，包括：
 * <li>查看数据的操作， 如：{@link #findListByProperty(Class, String, Object)}</li>
 * <li>保存数据的操作， 如：{@link #save(BasePOJO)} 和 {@link #saveBatch(Collection)}</li>
 * <li>更新数据的操作， 如：{@link #update(BasePOJO)} 和 {@link #updateBatch(Collection)}</li>
 * <li>删除数据的操作， 如：{@link #delete(BasePOJO)} 和 {@link #deleteAll(Collection)}</li>
 * 
 * @param <T> -
 *            必须使用需要处理的 {@link BasePOJO} 的子类作为参数传入。
 * @param <K> -
 *            必须使用需要处理的 {@link BasePOJO} 的子类的主键作为参数传入，
 *            该参数已经实现序列化，为实例的主键类型，保留字段，暂未使用。
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2011-9-11 下午05:00:13
 */
public class BaseDAO<T extends BasePOJO, K extends Serializable> implements
		DAO<T, K> {

	/**
	 * log:
	 * <p>
	 * 日志对象
	 * </p>
	 * 
	 * @since v1.01
	 */
	private static Log log = LogFactory.getLog(BaseDAO.class);

	/**
	 * daoSupport:
	 * <p>
	 * {@link DAO} 支持接口 {@link DAOSupport} 的实例
	 * 
	 * @since v1.01
	 */
	protected DAOSupport<T, K> daoSupport;

	/**
	 * BaseDAO:
	 * <p>
	 * 默认的构造方法，创建一个 {@link BaseDAO} 实例。
	 * 
	 * @since v1.01
	 */
	public BaseDAO() {
		super();
	}

	/**
	 * delete:
	 * <p>
	 * 从数据库中删除 {@link POJO} 的实例。
	 * </p>
	 * 
	 * @param entity -
	 *            POJO 实例
	 * 
	 * @since v1.01
	 * @see com.mynms.common.Dao#delete(com.mynms.core.POJO)
	 */
	public void delete(T entity) {
		try {
			this.getDaoSupport().delete(entity);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
	}

	/**
	 * deleteAll:
	 * <p>
	 * 从数据库中删除多个 {@link POJO} 的实例。
	 * </p>
	 * 
	 * @param entities -
	 *            {@link POJO} 集合
	 * 
	 * @since v1.01
	 * @see com.mynms.common.Dao#deleteAll(java.util.Collection)
	 */
	public void deleteAll(Collection<T> entities) {
		try {
			this.getDaoSupport().deleteAll((Collection<T>) entities);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
	}

	/**
	 * deleteAll:
	 * <p>
	 * 从数据库中删除所有 {@link POJO} 的实例。
	 * </p>
	 * 
	 * @param clazz - -
	 *            {@link POJO} 实例
	 * @since v1.01
	 * @see com.mynms.core.DAO#deleteAll(Class);
	 */
	public void deleteAll(Class<T> clazz) {
		try {
			this.getDaoSupport().deleteAll(clazz);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
	}

	/**
	 * save:
	 * <p>
	 * 保存 {@link POJO} 实例至数据库中。
	 * </p>
	 * 
	 * @param entity -
	 *            POJO 实例
	 * @return {@link K} - {@link K} 类型的主键
	 * 
	 * @since v1.01
	 * @see com.mynms.common.Dao#save(com.mynms.core.POJO)
	 */
	public K save(T entity) {
		try {
			return this.getDaoSupport().save(entity);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
		return null;
	}

	/**
	 * saveBatch:
	 * <p>
	 * 批量保存 {@link POJO} 实例至数据库中。
	 * </p>
	 * 
	 * @param entities -
	 *            POJO 实例的集合
	 * 
	 * @since v1.01
	 * @see com.mynms.common.Dao#saveBatch(java.util.Collection)
	 */
	public void saveBatch(Collection<T> entities) {
		try {
			this.getDaoSupport().saveBatch((Collection<T>) entities);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
	}

	/**
	 * update:
	 * <p>
	 * 从数据库中删除 {@link POJO} 的实例。
	 * </p>
	 * 
	 * @param entity -
	 *            POJO 实例
	 * @since v1.01
	 * @see com.mynms.common.Dao#update(com.mynms.core.POJO)
	 */
	public void update(T entity) {
		try {
			this.getDaoSupport().update(entity);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
	}

	/**
	 * updateBatch:
	 * <p>
	 * 从数据库中批量删除 {@link POJO} 的实例。
	 * </p>
	 * 
	 * @param entities -
	 *            POJO 实例集合
	 * 
	 * @since v1.01
	 * @see com.mynms.common.Dao#updateBatch(java.util.Collection)
	 */
	public void updateBatch(Collection<T> entities) {
		try {
			this.getDaoSupport().updateBatch((Collection<T>) entities);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
	}

	/**
	 * saveOrUpdate:
	 * <p>
	 * 保存或者修改数据库中 {@link POJO} 的实例。
	 * 
	 * @param entity -
	 *            POJO 实例
	 * 
	 * @since v1.01
	 */
	public void saveOrUpdate(T entity) {
		try {
			this.getDaoSupport().saveOrUpdate(entity);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
	}

	/**
	 * saveOrUpdateAll:
	 * <p>
	 * 批量保存或者修改数据库中 {@link POJO} 的实例。
	 * 
	 * @param entities -
	 *            POJO 实例集合
	 * 
	 * @since v1.01
	 */
	public void saveOrUpdateAll(Collection<T> entities) {
		try {
			this.getDaoSupport().saveOrUpdateAll(entities);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
	}

	/**
	 * loadAll:
	 * <p>
	 * 从数据库中加载所有实例
	 * 
	 * @param clazz -
	 *            POJO 实例
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}, 如果出现异常则返回 null
	 * 
	 * @since v1.01
	 */
	public List<T> loadAll(Class<T> clazz) {
		try {
			return this.getDaoSupport().loadAll(clazz);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
		return null;
	}

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
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}，如果未找到或者出错则返回<code>null</code>
	 * 
	 * @since v1.01
	 */
	public List<T> find(Class<T> clazz, String prop, Object value) {
		try {
			return this.getDaoSupport().find(clazz, prop, value);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
		return null;
	}

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
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}，如果未找到或者出错则返回<code>null</code>
	 * 
	 * @since v1.01
	 */
	public List<T> find(Class<T> clazz, String[] props, Object[] values) {
		try {
			return this.getDaoSupport().find(clazz, props, values);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
		return null;
	}

	/**
	 * find:
	 * <p>
	 * 通过HQL语句查找 {@link POJO} 实例的 {@link List}
	 * 
	 * @param hql -
	 *            HQL 语句
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}
	 * @since v1.01
	 */
	public List<T> find(String hql) {
		try {
			return this.getDaoSupport().find(hql);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
		return null;
	}

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
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}，如果未找到或者出错则返回<code>null</code>
	 * 
	 * @since v1.01
	 */
	public List<T> find(String hql, Object[] params) {
		try {
			return this.getDaoSupport().find(hql, params);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
		return null;
	}

	/**
	 * findByPage:
	 * <p>
	 * 通过{@link POJO} 类实例的 {@link Class} 对象， 以及 {@link Page} 对象，分页查询结果集。
	 * 
	 * @param clazz -
	 *            {@link POJO} 类实例的 {@link Class}
	 * @param page -
	 *            {@link Page} 类型的分页对象
	 * @return {@link Result<T>} - 返回查询后的结果
	 * 
	 * @since v1.01
	 * @see com.mynms.core.DAO#findByPage(java.lang.Class,
	 *      com.mynms.common.util.page.Page)
	 */
	public Result<T> findByPage(Class<T> clazz, Page page) {
		try {
			return this.getDaoSupport().findByPage(clazz, page);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
		return null;
	}

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
	 * 
	 * @since v1.01
	 * @see com.mynms.core.DAO#findByPage(Class, String, Object, Page)
	 */
	public Result<T> findByPage(Class<T> clazz, String propertyName,
			Object value, Page page) {
		try {
			return this.getDaoSupport().findByPage(clazz, propertyName, value,
					page);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
		return null;
	}

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
	 *            是否使用模糊查询
	 * @param page -
	 *            {@link Page} 类型的分页对象
	 * @return {@link List<T>} - 返回查询后的结果
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	public Result<T> findByPage(Class<T> clazz, String propertyName,
			Object value, Boolean isLike, Page page) {
		try {
			return this.getDaoSupport().findByPage(clazz, propertyName, value,
					isLike, page);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
		return null;
	}

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
	 * 
	 * @since v1.01
	 */
	public Result<T> findByPage(Class<T> clazz, String[] propertyNames,
			Object[] values, Page page) {
		try {
			return this.getDaoSupport().findByPage(clazz, propertyNames,
					values, page);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
		return null;
	}

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
	public Result<T> findByPage(Class<T> clazz, String[] propertyNames,
			Object[] values, Boolean[] isLikes, Page page) {
		try {
			return this.getDaoSupport().findByPage(clazz, propertyNames,
					values, isLikes, page);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
		return null;
	}

	/**
	 * get:
	 * <p>
	 * 通过 id 从数据库中查找 {@link POJO} 实例。如果没有匹配的则返回 <code>null</code> 。
	 * </p>
	 * 
	 * @param clazz -
	 *            {@link POJO} 类实例的 {@link Class}
	 * @param id -
	 *            {@link POJO} 类的 {@link String} 类型 <code>id</code> 的值
	 * @return {@link POJO} - 返回 {@link POJO} 实例，如果未找到或者出错则返回<code>null</code>
	 * @since v1.01
	 */
	public T get(Class<T> clazz, K id) {
		try {
			return this.getDaoSupport().get(clazz, id);
		} catch (DAOException e) {
			log.error(e.getErrorCode().getErrorCode() + ":"
					+ e.getErrorCode().getError(), e);
		}
		return null;
	}

	/**
	 * getDaoSupport:
	 * <p>
	 * 获取 {@link DAOSupport} 实例
	 * 
	 * @return DAOSupport<BasePOJO,Serializable> - {@link DAOSupport} 类的实例
	 * @since v1.01
	 */
	public DAOSupport<T, K> getDaoSupport() {
		return daoSupport;
	}

	/**
	 * setDaoSupport:
	 * <p>
	 * 设置 {@link DAOSupport} 实例
	 * 
	 * @param daoSupport -
	 *            {@link DAOSupport} 实例
	 * @since v1.01
	 */
	public void setDaoSupport(DAOSupport<T, K> daoSupport) {
		this.daoSupport = daoSupport;
	}

}
