/*
 * @(#)HibernateDAOSupportImpl.java     v1.01, 2012-5-3
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.core.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mynms.common.util.page.Page;
import com.mynms.common.util.page.PaginationSupport;
import com.mynms.common.util.page.Result;
import com.mynms.core.DAOSupport;
import com.mynms.core.POJO;
import com.mynms.core.exception.DAOException;

/**
 * ClassName: HibernateDAOSupportImpl.java {@link HibernateDAOSupportImpl} 通过继承自
 * {@link HibernateDaoSupport} 类来实现 {@link DAOSupport} 。
 * 
 * @param <T> -
 *            必须使用需要处理的 {@link BasePOJO} 的子类作为参数传入。
 * @param <K> -
 *            必须使用需要处理的 {@link BasePOJO} 的子类的主键作为参数传入，
 *            该参数已经实现序列化，为实例的主键类型，保留字段，暂未使用。
 * @author 聂林
 * @version v1.01
 * @since v1.01
 * @Date 2012-5-3 下午04:10:24
 */
public class HibernateDAOSupportImpl<T extends BasePOJO, K extends Serializable>
		extends HibernateDaoSupport implements DAOSupport<T, K> {

	// /**
	// * log:
	// * <p>日志对象</p>
	// *
	// * @since v1.01
	// */
	// private static Log log =
	// LogFactory.getLog(HibernateDAOSupportImpl.class);

	/**
	 * HibernateDAOSupportImpl:
	 * <p>
	 * 默认的构造方法，创建一个 {@link HibernateDAOSupportImpl} 实例。
	 * 
	 * @since v1.01
	 */
	public HibernateDAOSupportImpl() {
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
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 * @see com.mynms.common.Dao#delete(com.mynms.core.POJO)
	 */
	public void delete(T entity) throws DAOException {
		try {
			this.getHibernateTemplate().delete(entity);
		} catch (DataAccessException e) {
			throw new DAOException("", e, DAOException.DELETE_ENTITY);
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
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 * @see com.mynms.common.Dao#deleteAll(java.util.Collection)
	 */
	public void deleteAll(Collection<T> entities) throws DAOException {
		try {
			this.getHibernateTemplate().deleteAll(entities);
		} catch (DataAccessException e) {
			throw new DAOException("", e, DAOException.DELETE_ALL_ENTITIES);
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
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 * @see com.mynms.core.DAO#deleteAll(Class);
	 */
	public void deleteAll(Class<T> clazz) throws DAOException {
		try {
			List<T> list = this.loadAll(clazz);
			this.getHibernateTemplate().deleteAll(list);
		} catch (DataAccessException e) {
			throw new DAOException("", e, DAOException.DELETE_ALL_ENTITIES);
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
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 * @see com.mynms.common.Dao#save(com.mynms.core.POJO)
	 */
	@SuppressWarnings("unchecked")
	public K save(T entity) throws DAOException {
		try {
			return (K) this.getHibernateTemplate().save(entity);
		} catch (DataAccessException e) {
			throw new DAOException("", e, DAOException.SAVE_ENTITY);
		}
	}

	/**
	 * saveBatch:
	 * <p>
	 * 批量保存 {@link POJO} 实例至数据库中。
	 * </p>
	 * 
	 * @param entities -
	 *            POJO 实例的集合
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 * @see com.mynms.common.Dao#saveBatch(java.util.Collection)
	 */
	public void saveBatch(Collection<T> entities) throws DAOException {
		try {
			this.getHibernateTemplate().saveOrUpdateAll(entities);
		} catch (DataAccessException e) {
			throw new DAOException("", e, DAOException.SAVE_ALL_ENTITIES);
		}
	}

	/**
	 * update:
	 * <p>
	 * 从数据库中更新 {@link POJO} 的实例。
	 * </p>
	 * 
	 * @param entity -
	 *            POJO 实例
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 * @see com.mynms.common.Dao#update(com.mynms.core.POJO)
	 */
	public void update(T entity) throws DAOException {
		try {
			this.getHibernateTemplate().update(entity);
		} catch (DataAccessException e) {
			throw new DAOException("", e, DAOException.UPDATE_ENTITY);
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
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 * @see com.mynms.common.Dao#updateBatch(java.util.Collection)
	 */
	public void updateBatch(Collection<T> entities) throws DAOException {
		try {
			this.getHibernateTemplate().saveOrUpdateAll(entities);
		} catch (DataAccessException e) {
			throw new DAOException("", e, DAOException.UPDATE_ALL_ENTITIES);
		}
	}

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
	public void saveOrUpdate(T entity) throws DAOException {
		try {
			this.getHibernateTemplate().saveOrUpdate(entity);
		} catch (DataAccessException e) {
			throw new DAOException("", e, DAOException.SAVE_OR_UPDATE_ENTITY);
		}
	}

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
	public void saveOrUpdateAll(Collection<T> entities) throws DAOException {
		try {
			this.getHibernateTemplate().saveOrUpdateAll(entities);
		} catch (DataAccessException e) {
			throw new DAOException("", e,
					DAOException.SAVE_OR_UPDATE_ALL_ENTITIES);
		}
	}

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
	public List<T> loadAll(Class<T> clazz) throws DAOException {
		try {
			System.out.println(clazz);
			return this.getHibernateTemplate().loadAll(clazz);
		} catch (DataAccessException e) {
			throw new DAOException("", e, DAOException.LOAD_ALL);
		}
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
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	public List<T> find(Class<T> clazz, String prop, Object value)
			throws DAOException {
		return this.find(clazz, new String[] { prop }, new Object[] { value });
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
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	public List<T> find(Class<T> clazz, String[] props, Object[] values)
			throws DAOException {
		try {
			StringBuffer hql = new StringBuffer("from " + clazz.getName()
					+ " entity ");
			String entity = " entity.";
			if (props != null) {
				int i = 0;
				for (String prop : props) {
					if (i == 0) {
						hql.append(" where ");
					}
					if (i == props.length - 1) {
						hql.append(entity + prop + " = ? ");
					} else {
						hql.append(entity + prop + " = ? and ");
					}
					i += 1;
				}
			}
			return this.find(hql.toString(), values);
		} catch (Exception e) {
			throw new DAOException("", e, DAOException.FIND_BY_RPOPERTIES);
		}
	}

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
	@SuppressWarnings("unchecked")
	public List<T> find(String hql) throws DAOException {
		try {
			return this.getHibernateTemplate().find(hql);
		} catch (DataAccessException e) {
			throw new DAOException("", e, DAOException.FIND_BY_HQL);
		}
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
	 * @return {@link List} - 返回 {@link POJO} 实例的 {@link List}
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] params) throws DAOException {
		try {
			return this.getHibernateTemplate().find(hql, params);
		} catch (DataAccessException e) {
			throw new DAOException("", e, DAOException.FIND_BY_HQL_AND_PARAMS);
		}
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
	 *            {@link POJO} 类的 {@link K} 类型 <code>id</code> 的值
	 * @return {@link POJO} - 返回 {@link POJO} 实例
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	public T get(Class<T> clazz, K id) throws DAOException {
		try {
			return this.getHibernateTemplate().get(clazz, id);
		} catch (DataAccessException e) {
			throw new DAOException("", e, DAOException.FIND_BY_ENTITY_ID);
		}
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
	 * @return {@link List<T>} - 返回查询后的结果
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	@SuppressWarnings("unchecked")
	public Result<T> findByPage(final Class<T> clazz, final Page page)
			throws DAOException {
		try {
			return this.getHibernateTemplate().execute(
					new HibernateCallback<Result<T>>() {

						public Result<T> doInHibernate(Session session)
								throws HibernateException, SQLException {
							int firstIndex = (page.getCurrentPage() - 1)
									* page.getPageSize();
							Criteria criteria = session.createCriteria(clazz);
							int totalCount = ((Long) criteria.setProjection(
									Projections.rowCount()).uniqueResult())
									.intValue();
							List<T> list = criteria.setProjection(null)
									.setFirstResult(firstIndex).setMaxResults(
											page.getPageSize()).list();
							Page newPage = PaginationSupport.createPage(page,
									totalCount);
							return new Result<T>(newPage, list);
						}

					});
		} catch (DataAccessResourceFailureException e) {
			throw new DAOException("", e, DAOException.FIND_BY_PAGE);
		} catch (IllegalStateException e) {
			throw new DAOException("", e, DAOException.FIND_BY_PAGE);
		} catch (HibernateException e) {
			throw new DAOException("", e, DAOException.FIND_BY_PAGE);
		}
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
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	public Result<T> findByPage(final Class<T> clazz,
			final String propertyName, final Object value, final Page page)
			throws DAOException {
		return findByPage(clazz, new String[] { propertyName },
				new Object[] { value }, page);
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
			Object value, Boolean isLike, Page page) throws DAOException {
		return findByPage(clazz, new String[] { propertyName },
				new Object[] { value }, new Boolean[] { isLike }, page);
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
	 * @throws DAOException -
	 *             抛出数据库异常
	 * @since v1.01
	 */
	@SuppressWarnings("unchecked")
	public Result<T> findByPage(final Class<T> clazz,
			final String[] propertyNames, final Object[] values, final Page page)
			throws DAOException {
		try {
			return this.getHibernateTemplate().execute(
					new HibernateCallback<Result<T>>() {

						public Result<T> doInHibernate(Session session)
								throws HibernateException, SQLException {
							int firstIndex = (page.getCurrentPage() - 1)
									* page.getPageSize();
							Criteria criteria = session.createCriteria(clazz);
							if (propertyNames != null
									&& propertyNames.length > 0) {
								int i = 0;
								for (String propertyName : propertyNames) {
									criteria = criteria.add(Property.forName(
											propertyName).eq(values[i]));
									i++;
								}
							}

							int totalCount = ((Long) criteria.setProjection(
									Projections.rowCount()).uniqueResult())
									.intValue();

							List<T> list = criteria.setProjection(null)
									.setFirstResult(firstIndex).setMaxResults(
											page.getPageSize()).list();
							Page newPage = PaginationSupport.createPage(page,
									totalCount);
							return new Result<T>(newPage, list);
						}

					});
		} catch (DataAccessResourceFailureException e) {
			throw new DAOException("", e, DAOException.FIND_BY_PAGE);
		} catch (IllegalStateException e) {
			throw new DAOException("", e, DAOException.FIND_BY_PAGE);
		} catch (HibernateException e) {
			throw new DAOException("", e, DAOException.FIND_BY_PAGE);
		}
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
	@SuppressWarnings("unchecked")
	public Result<T> findByPage(final Class<T> clazz,
			final String[] propertyNames, final Object[] values,
			final Boolean[] isLikes, final Page page) throws DAOException {
		try {
			return this.getHibernateTemplate().execute(
					new HibernateCallback<Result<T>>() {

						public Result<T> doInHibernate(Session session)
								throws HibernateException, SQLException {
							int firstIndex = (page.getCurrentPage() - 1)
									* page.getPageSize();
							Criteria criteria = session.createCriteria(clazz);

							if (propertyNames != null
									&& propertyNames.length > 0) {
								int i = 0;
								for (String propertyName : propertyNames) {
									// criteria = criteria.add(
									// Property.forName(propertyName)
									// .eq(values[i]));
									if (isLikes[i]) {
										criteria.add(Restrictions.like(
												propertyName, "%" + values[i]
														+ "%"));
									} else {
										criteria = criteria.add(Property
												.forName(propertyName).eq(
														values[i]));
									}
									i++;
								}
							}

							int totalCount = ((Long) criteria.setProjection(
									Projections.rowCount()).uniqueResult())
									.intValue();

							List<T> list = criteria.setProjection(null)
									.setFirstResult(firstIndex).setMaxResults(
											page.getPageSize()).list();
							Page newPage = PaginationSupport.createPage(page,
									totalCount);
							return new Result<T>(newPage, list);
						}

					});
		} catch (DataAccessResourceFailureException e) {
			throw new DAOException("", e, DAOException.FIND_BY_PAGE);
		} catch (IllegalStateException e) {
			throw new DAOException("", e, DAOException.FIND_BY_PAGE);
		} catch (HibernateException e) {
			throw new DAOException("", e, DAOException.FIND_BY_PAGE);
		}
	}

	// /**
	// * 使用HQL语句进行分页查询操作
	// * offset 第一条记录的索引
	// * pageSize 每页需要显示的记录数
	// * @return 当前页的所有记录
	// */
	// public List<T> findByPage(final String hql,
	// final int offset, final int pageSize){
	// List list = getHibernateTemplate().executeFind(
	// new HibernateCallback() {
	//            
	// public Object doInHibernate(Session session)
	// throws HibernateException,
	// SQLException {
	// List result = session.createQuery(hql).setFirstResult(offset)
	// .setMaxResults(pageSize)
	// .list();
	// return result;
	// }
	// });
	// return list;
	// }
	//        
	// /**
	// * 使用HQL语句进行分页查询操作
	// * value 如果HQL有一个参数需要传人，则value就是传人的参数
	// * offset 第一条记录的索引
	// * pageSize 每页需要显示的记录数
	// * @return 当前页的所有记录
	// */
	// public List findByPage(final String hql, final Object value,
	// final int offset, final int pageSize){
	// //System.out.println("PageDaoHibernate.findByPage()");
	// List list = getHibernateTemplate().executeFind(new HibernateCallback() {
	//                
	// public Object doInHibernate(Session session)
	// throws HibernateException,
	// SQLException {
	// List result = session.createQuery(hql).setFirstResult(offset)
	// .setParameter(0, value)
	// .setMaxResults(pageSize)
	// .list();
	// return result;
	// }
	// });
	// return list;
	// }
	//        
	// /**
	// * 使用HQL语句进行分页查询操作
	// * values 如果HQL有多个参数需要传人，则values就是传人的参数数组
	// * offset 第一条记录的索引
	// * pageSize 每页需要显示的记录数
	// * @return 当前页的所有记录
	// */
	// public List findByPage(final String hql, final Object[] values,
	// final int offset, final int pageSize){
	// List list = getHibernateTemplate().executeFind(
	// new HibernateCallback() {
	//                
	// public Object doInHibernate(Session session)
	// throws HibernateException,
	// SQLException {
	// Query query = session.createQuery(hql);
	// for (int i = 0; i < values.length; i++) {
	// query.setParameter(i, values[i]);
	// }
	// List result = query.setFirstResult(offset)
	// .setMaxResults(pageSize)
	// .list();
	// return result;
	// }
	// });
	// return list;
	// }

}
