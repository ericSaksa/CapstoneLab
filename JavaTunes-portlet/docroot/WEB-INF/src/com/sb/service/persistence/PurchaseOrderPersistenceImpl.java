/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sb.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sb.NoSuchPurchaseOrderException;

import com.sb.model.PurchaseOrder;
import com.sb.model.impl.PurchaseOrderImpl;
import com.sb.model.impl.PurchaseOrderModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the purchase order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author amifxw0
 * @see PurchaseOrderPersistence
 * @see PurchaseOrderUtil
 * @generated
 */
public class PurchaseOrderPersistenceImpl extends BasePersistenceImpl<PurchaseOrder>
	implements PurchaseOrderPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PurchaseOrderUtil} to access the purchase order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PurchaseOrderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_ORDERBYUSERID = new FinderPath(PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOrderModelImpl.FINDER_CACHE_ENABLED,
			PurchaseOrderImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByOrderByUserId", new String[] { Integer.class.getName() },
			PurchaseOrderModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORDERBYUSERID = new FinderPath(PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrderByUserId",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOrderModelImpl.FINDER_CACHE_ENABLED,
			PurchaseOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOrderModelImpl.FINDER_CACHE_ENABLED,
			PurchaseOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the purchase order in the entity cache if it is enabled.
	 *
	 * @param purchaseOrder the purchase order
	 */
	public void cacheResult(PurchaseOrder purchaseOrder) {
		EntityCacheUtil.putResult(PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOrderImpl.class, purchaseOrder.getPrimaryKey(),
			purchaseOrder);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORDERBYUSERID,
			new Object[] { Integer.valueOf(purchaseOrder.getUserId()) },
			purchaseOrder);

		purchaseOrder.resetOriginalValues();
	}

	/**
	 * Caches the purchase orders in the entity cache if it is enabled.
	 *
	 * @param purchaseOrders the purchase orders
	 */
	public void cacheResult(List<PurchaseOrder> purchaseOrders) {
		for (PurchaseOrder purchaseOrder : purchaseOrders) {
			if (EntityCacheUtil.getResult(
						PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
						PurchaseOrderImpl.class, purchaseOrder.getPrimaryKey()) == null) {
				cacheResult(purchaseOrder);
			}
			else {
				purchaseOrder.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all purchase orders.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PurchaseOrderImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PurchaseOrderImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the purchase order.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PurchaseOrder purchaseOrder) {
		EntityCacheUtil.removeResult(PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOrderImpl.class, purchaseOrder.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(purchaseOrder);
	}

	@Override
	public void clearCache(List<PurchaseOrder> purchaseOrders) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PurchaseOrder purchaseOrder : purchaseOrders) {
			EntityCacheUtil.removeResult(PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
				PurchaseOrderImpl.class, purchaseOrder.getPrimaryKey());

			clearUniqueFindersCache(purchaseOrder);
		}
	}

	protected void clearUniqueFindersCache(PurchaseOrder purchaseOrder) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORDERBYUSERID,
			new Object[] { Integer.valueOf(purchaseOrder.getUserId()) });
	}

	/**
	 * Creates a new purchase order with the primary key. Does not add the purchase order to the database.
	 *
	 * @param PoId the primary key for the new purchase order
	 * @return the new purchase order
	 */
	public PurchaseOrder create(int PoId) {
		PurchaseOrder purchaseOrder = new PurchaseOrderImpl();

		purchaseOrder.setNew(true);
		purchaseOrder.setPrimaryKey(PoId);

		return purchaseOrder;
	}

	/**
	 * Removes the purchase order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PoId the primary key of the purchase order
	 * @return the purchase order that was removed
	 * @throws com.sb.NoSuchPurchaseOrderException if a purchase order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PurchaseOrder remove(int PoId)
		throws NoSuchPurchaseOrderException, SystemException {
		return remove(Integer.valueOf(PoId));
	}

	/**
	 * Removes the purchase order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the purchase order
	 * @return the purchase order that was removed
	 * @throws com.sb.NoSuchPurchaseOrderException if a purchase order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOrder remove(Serializable primaryKey)
		throws NoSuchPurchaseOrderException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PurchaseOrder purchaseOrder = (PurchaseOrder)session.get(PurchaseOrderImpl.class,
					primaryKey);

			if (purchaseOrder == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPurchaseOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(purchaseOrder);
		}
		catch (NoSuchPurchaseOrderException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PurchaseOrder removeImpl(PurchaseOrder purchaseOrder)
		throws SystemException {
		purchaseOrder = toUnwrappedModel(purchaseOrder);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, purchaseOrder);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(purchaseOrder);

		return purchaseOrder;
	}

	@Override
	public PurchaseOrder updateImpl(com.sb.model.PurchaseOrder purchaseOrder,
		boolean merge) throws SystemException {
		purchaseOrder = toUnwrappedModel(purchaseOrder);

		boolean isNew = purchaseOrder.isNew();

		PurchaseOrderModelImpl purchaseOrderModelImpl = (PurchaseOrderModelImpl)purchaseOrder;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, purchaseOrder, merge);

			purchaseOrder.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PurchaseOrderModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOrderImpl.class, purchaseOrder.getPrimaryKey(),
			purchaseOrder);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORDERBYUSERID,
				new Object[] { Integer.valueOf(purchaseOrder.getUserId()) },
				purchaseOrder);
		}
		else {
			if ((purchaseOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ORDERBYUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(purchaseOrderModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORDERBYUSERID,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORDERBYUSERID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORDERBYUSERID,
					new Object[] { Integer.valueOf(purchaseOrder.getUserId()) },
					purchaseOrder);
			}
		}

		return purchaseOrder;
	}

	protected PurchaseOrder toUnwrappedModel(PurchaseOrder purchaseOrder) {
		if (purchaseOrder instanceof PurchaseOrderImpl) {
			return purchaseOrder;
		}

		PurchaseOrderImpl purchaseOrderImpl = new PurchaseOrderImpl();

		purchaseOrderImpl.setNew(purchaseOrder.isNew());
		purchaseOrderImpl.setPrimaryKey(purchaseOrder.getPrimaryKey());

		purchaseOrderImpl.setPoId(purchaseOrder.getPoId());
		purchaseOrderImpl.setStatus(purchaseOrder.getStatus());
		purchaseOrderImpl.setOrderDate(purchaseOrder.getOrderDate());
		purchaseOrderImpl.setUserId(purchaseOrder.getUserId());

		return purchaseOrderImpl;
	}

	/**
	 * Returns the purchase order with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the purchase order
	 * @return the purchase order
	 * @throws com.liferay.portal.NoSuchModelException if a purchase order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOrder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the purchase order with the primary key or throws a {@link com.sb.NoSuchPurchaseOrderException} if it could not be found.
	 *
	 * @param PoId the primary key of the purchase order
	 * @return the purchase order
	 * @throws com.sb.NoSuchPurchaseOrderException if a purchase order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PurchaseOrder findByPrimaryKey(int PoId)
		throws NoSuchPurchaseOrderException, SystemException {
		PurchaseOrder purchaseOrder = fetchByPrimaryKey(PoId);

		if (purchaseOrder == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + PoId);
			}

			throw new NoSuchPurchaseOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				PoId);
		}

		return purchaseOrder;
	}

	/**
	 * Returns the purchase order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the purchase order
	 * @return the purchase order, or <code>null</code> if a purchase order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOrder fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the purchase order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PoId the primary key of the purchase order
	 * @return the purchase order, or <code>null</code> if a purchase order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PurchaseOrder fetchByPrimaryKey(int PoId) throws SystemException {
		PurchaseOrder purchaseOrder = (PurchaseOrder)EntityCacheUtil.getResult(PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
				PurchaseOrderImpl.class, PoId);

		if (purchaseOrder == _nullPurchaseOrder) {
			return null;
		}

		if (purchaseOrder == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				purchaseOrder = (PurchaseOrder)session.get(PurchaseOrderImpl.class,
						Integer.valueOf(PoId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (purchaseOrder != null) {
					cacheResult(purchaseOrder);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
						PurchaseOrderImpl.class, PoId, _nullPurchaseOrder);
				}

				closeSession(session);
			}
		}

		return purchaseOrder;
	}

	/**
	 * Returns the purchase order where UserId = &#63; or throws a {@link com.sb.NoSuchPurchaseOrderException} if it could not be found.
	 *
	 * @param UserId the user ID
	 * @return the matching purchase order
	 * @throws com.sb.NoSuchPurchaseOrderException if a matching purchase order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PurchaseOrder findByOrderByUserId(int UserId)
		throws NoSuchPurchaseOrderException, SystemException {
		PurchaseOrder purchaseOrder = fetchByOrderByUserId(UserId);

		if (purchaseOrder == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("UserId=");
			msg.append(UserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPurchaseOrderException(msg.toString());
		}

		return purchaseOrder;
	}

	/**
	 * Returns the purchase order where UserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param UserId the user ID
	 * @return the matching purchase order, or <code>null</code> if a matching purchase order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PurchaseOrder fetchByOrderByUserId(int UserId)
		throws SystemException {
		return fetchByOrderByUserId(UserId, true);
	}

	/**
	 * Returns the purchase order where UserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param UserId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching purchase order, or <code>null</code> if a matching purchase order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PurchaseOrder fetchByOrderByUserId(int UserId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { UserId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ORDERBYUSERID,
					finderArgs, this);
		}

		if (result instanceof PurchaseOrder) {
			PurchaseOrder purchaseOrder = (PurchaseOrder)result;

			if ((UserId != purchaseOrder.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_PURCHASEORDER_WHERE);

			query.append(_FINDER_COLUMN_ORDERBYUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(UserId);

				List<PurchaseOrder> list = q.list();

				result = list;

				PurchaseOrder purchaseOrder = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORDERBYUSERID,
						finderArgs, list);
				}
				else {
					purchaseOrder = list.get(0);

					cacheResult(purchaseOrder);

					if ((purchaseOrder.getUserId() != UserId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORDERBYUSERID,
							finderArgs, purchaseOrder);
					}
				}

				return purchaseOrder;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORDERBYUSERID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (PurchaseOrder)result;
			}
		}
	}

	/**
	 * Returns all the purchase orders.
	 *
	 * @return the purchase orders
	 * @throws SystemException if a system exception occurred
	 */
	public List<PurchaseOrder> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchase orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase orders
	 * @param end the upper bound of the range of purchase orders (not inclusive)
	 * @return the range of purchase orders
	 * @throws SystemException if a system exception occurred
	 */
	public List<PurchaseOrder> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchase orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase orders
	 * @param end the upper bound of the range of purchase orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of purchase orders
	 * @throws SystemException if a system exception occurred
	 */
	public List<PurchaseOrder> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<PurchaseOrder> list = (List<PurchaseOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PURCHASEORDER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PURCHASEORDER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PurchaseOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PurchaseOrder>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes the purchase order where UserId = &#63; from the database.
	 *
	 * @param UserId the user ID
	 * @return the purchase order that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public PurchaseOrder removeByOrderByUserId(int UserId)
		throws NoSuchPurchaseOrderException, SystemException {
		PurchaseOrder purchaseOrder = findByOrderByUserId(UserId);

		return remove(purchaseOrder);
	}

	/**
	 * Removes all the purchase orders from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PurchaseOrder purchaseOrder : findAll()) {
			remove(purchaseOrder);
		}
	}

	/**
	 * Returns the number of purchase orders where UserId = &#63;.
	 *
	 * @param UserId the user ID
	 * @return the number of matching purchase orders
	 * @throws SystemException if a system exception occurred
	 */
	public int countByOrderByUserId(int UserId) throws SystemException {
		Object[] finderArgs = new Object[] { UserId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORDERBYUSERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PURCHASEORDER_WHERE);

			query.append(_FINDER_COLUMN_ORDERBYUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(UserId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORDERBYUSERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of purchase orders.
	 *
	 * @return the number of purchase orders
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PURCHASEORDER);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns all the purchase items associated with the purchase order.
	 *
	 * @param pk the primary key of the purchase order
	 * @return the purchase items associated with the purchase order
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.sb.model.PurchaseItem> getPurchaseItems(int pk)
		throws SystemException {
		return getPurchaseItems(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the purchase items associated with the purchase order.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the purchase order
	 * @param start the lower bound of the range of purchase orders
	 * @param end the upper bound of the range of purchase orders (not inclusive)
	 * @return the range of purchase items associated with the purchase order
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.sb.model.PurchaseItem> getPurchaseItems(int pk, int start,
		int end) throws SystemException {
		return getPurchaseItems(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_PURCHASEITEMS = new FinderPath(com.sb.model.impl.PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
			com.sb.model.impl.PurchaseItemModelImpl.FINDER_CACHE_ENABLED,
			com.sb.model.impl.PurchaseItemImpl.class,
			com.sb.service.persistence.PurchaseItemPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getPurchaseItems",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_PURCHASEITEMS.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the purchase items associated with the purchase order.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the purchase order
	 * @param start the lower bound of the range of purchase orders
	 * @param end the upper bound of the range of purchase orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of purchase items associated with the purchase order
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.sb.model.PurchaseItem> getPurchaseItems(int pk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<com.sb.model.PurchaseItem> list = (List<com.sb.model.PurchaseItem>)FinderCacheUtil.getResult(FINDER_PATH_GET_PURCHASEITEMS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETPURCHASEITEMS.concat(ORDER_BY_CLAUSE)
											   .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETPURCHASEITEMS;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("PurchaseItem",
					com.sb.model.impl.PurchaseItemImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.sb.model.PurchaseItem>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_PURCHASEITEMS,
						finderArgs);
				}
				else {
					purchaseItemPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_PURCHASEITEMS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_PURCHASEITEMS_SIZE = new FinderPath(com.sb.model.impl.PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
			com.sb.model.impl.PurchaseItemModelImpl.FINDER_CACHE_ENABLED,
			com.sb.model.impl.PurchaseItemImpl.class,
			com.sb.service.persistence.PurchaseItemPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getPurchaseItemsSize", new String[] { Integer.class.getName() });

	static {
		FINDER_PATH_GET_PURCHASEITEMS_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of purchase items associated with the purchase order.
	 *
	 * @param pk the primary key of the purchase order
	 * @return the number of purchase items associated with the purchase order
	 * @throws SystemException if a system exception occurred
	 */
	public int getPurchaseItemsSize(int pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_PURCHASEITEMS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETPURCHASEITEMSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_PURCHASEITEMS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_PURCHASEITEM = new FinderPath(com.sb.model.impl.PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
			com.sb.model.impl.PurchaseItemModelImpl.FINDER_CACHE_ENABLED,
			com.sb.model.impl.PurchaseItemImpl.class,
			com.sb.service.persistence.PurchaseItemPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsPurchaseItem",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns <code>true</code> if the purchase item is associated with the purchase order.
	 *
	 * @param pk the primary key of the purchase order
	 * @param purchaseItemPK the primary key of the purchase item
	 * @return <code>true</code> if the purchase item is associated with the purchase order; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsPurchaseItem(int pk, int purchaseItemPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, purchaseItemPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_PURCHASEITEM,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsPurchaseItem.contains(pk,
							purchaseItemPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_PURCHASEITEM,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the purchase order has any purchase items associated with it.
	 *
	 * @param pk the primary key of the purchase order to check for associations with purchase items
	 * @return <code>true</code> if the purchase order has any purchase items associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsPurchaseItems(int pk) throws SystemException {
		if (getPurchaseItemsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the purchase order persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sb.model.PurchaseOrder")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PurchaseOrder>> listenersList = new ArrayList<ModelListener<PurchaseOrder>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PurchaseOrder>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsPurchaseItem = new ContainsPurchaseItem();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PurchaseOrderImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = InventoryPersistence.class)
	protected InventoryPersistence inventoryPersistence;
	@BeanReference(type = ItemPersistence.class)
	protected ItemPersistence itemPersistence;
	@BeanReference(type = ItemBandMembersPersistence.class)
	protected ItemBandMembersPersistence itemBandMembersPersistence;
	@BeanReference(type = PurchaseItemPersistence.class)
	protected PurchaseItemPersistence purchaseItemPersistence;
	@BeanReference(type = PurchaseOrderPersistence.class)
	protected PurchaseOrderPersistence purchaseOrderPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	protected ContainsPurchaseItem containsPurchaseItem;

	protected class ContainsPurchaseItem {
		protected ContainsPurchaseItem() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSPURCHASEITEM,
					new int[] { java.sql.Types.INTEGER, java.sql.Types.INTEGER },
					RowMapper.COUNT);
		}

		protected boolean contains(int PoId, int PurchaseItemId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Integer(PoId), new Integer(PurchaseItemId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_PURCHASEORDER = "SELECT purchaseOrder FROM PurchaseOrder purchaseOrder";
	private static final String _SQL_SELECT_PURCHASEORDER_WHERE = "SELECT purchaseOrder FROM PurchaseOrder purchaseOrder WHERE ";
	private static final String _SQL_COUNT_PURCHASEORDER = "SELECT COUNT(purchaseOrder) FROM PurchaseOrder purchaseOrder";
	private static final String _SQL_COUNT_PURCHASEORDER_WHERE = "SELECT COUNT(purchaseOrder) FROM PurchaseOrder purchaseOrder WHERE ";
	private static final String _SQL_GETPURCHASEITEMS = "SELECT {PurchaseItem.*} FROM PurchaseItem INNER JOIN PurchaseOrder ON (PurchaseOrder.PoId = PurchaseItem.PoId) WHERE (PurchaseOrder.PoId = ?)";
	private static final String _SQL_GETPURCHASEITEMSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM PurchaseItem WHERE PoId = ?";
	private static final String _SQL_CONTAINSPURCHASEITEM = "SELECT COUNT(*) AS COUNT_VALUE FROM PurchaseItem WHERE PoId = ? AND PurchaseItemId = ?";
	private static final String _FINDER_COLUMN_ORDERBYUSERID_USERID_2 = "purchaseOrder.UserId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "purchaseOrder.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PurchaseOrder exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PurchaseOrder exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PurchaseOrderPersistenceImpl.class);
	private static PurchaseOrder _nullPurchaseOrder = new PurchaseOrderImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PurchaseOrder> toCacheModel() {
				return _nullPurchaseOrderCacheModel;
			}
		};

	private static CacheModel<PurchaseOrder> _nullPurchaseOrderCacheModel = new CacheModel<PurchaseOrder>() {
			public PurchaseOrder toEntityModel() {
				return _nullPurchaseOrder;
			}
		};
}