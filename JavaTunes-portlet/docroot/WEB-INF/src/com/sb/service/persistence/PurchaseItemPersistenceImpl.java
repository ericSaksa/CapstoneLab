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
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sb.NoSuchPurchaseItemException;

import com.sb.model.PurchaseItem;
import com.sb.model.impl.PurchaseItemImpl;
import com.sb.model.impl.PurchaseItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the purchase item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author amifxw0
 * @see PurchaseItemPersistence
 * @see PurchaseItemUtil
 * @generated
 */
public class PurchaseItemPersistenceImpl extends BasePersistenceImpl<PurchaseItem>
	implements PurchaseItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PurchaseItemUtil} to access the purchase item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PurchaseItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseItemModelImpl.FINDER_CACHE_ENABLED, PurchaseItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseItemModelImpl.FINDER_CACHE_ENABLED, PurchaseItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the purchase item in the entity cache if it is enabled.
	 *
	 * @param purchaseItem the purchase item
	 */
	public void cacheResult(PurchaseItem purchaseItem) {
		EntityCacheUtil.putResult(PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseItemImpl.class, purchaseItem.getPrimaryKey(), purchaseItem);

		purchaseItem.resetOriginalValues();
	}

	/**
	 * Caches the purchase items in the entity cache if it is enabled.
	 *
	 * @param purchaseItems the purchase items
	 */
	public void cacheResult(List<PurchaseItem> purchaseItems) {
		for (PurchaseItem purchaseItem : purchaseItems) {
			if (EntityCacheUtil.getResult(
						PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
						PurchaseItemImpl.class, purchaseItem.getPrimaryKey()) == null) {
				cacheResult(purchaseItem);
			}
			else {
				purchaseItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all purchase items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PurchaseItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PurchaseItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the purchase item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PurchaseItem purchaseItem) {
		EntityCacheUtil.removeResult(PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseItemImpl.class, purchaseItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PurchaseItem> purchaseItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PurchaseItem purchaseItem : purchaseItems) {
			EntityCacheUtil.removeResult(PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
				PurchaseItemImpl.class, purchaseItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new purchase item with the primary key. Does not add the purchase item to the database.
	 *
	 * @param PurchaseItemId the primary key for the new purchase item
	 * @return the new purchase item
	 */
	public PurchaseItem create(int PurchaseItemId) {
		PurchaseItem purchaseItem = new PurchaseItemImpl();

		purchaseItem.setNew(true);
		purchaseItem.setPrimaryKey(PurchaseItemId);

		return purchaseItem;
	}

	/**
	 * Removes the purchase item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PurchaseItemId the primary key of the purchase item
	 * @return the purchase item that was removed
	 * @throws com.sb.NoSuchPurchaseItemException if a purchase item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PurchaseItem remove(int PurchaseItemId)
		throws NoSuchPurchaseItemException, SystemException {
		return remove(Integer.valueOf(PurchaseItemId));
	}

	/**
	 * Removes the purchase item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the purchase item
	 * @return the purchase item that was removed
	 * @throws com.sb.NoSuchPurchaseItemException if a purchase item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseItem remove(Serializable primaryKey)
		throws NoSuchPurchaseItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PurchaseItem purchaseItem = (PurchaseItem)session.get(PurchaseItemImpl.class,
					primaryKey);

			if (purchaseItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPurchaseItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(purchaseItem);
		}
		catch (NoSuchPurchaseItemException nsee) {
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
	protected PurchaseItem removeImpl(PurchaseItem purchaseItem)
		throws SystemException {
		purchaseItem = toUnwrappedModel(purchaseItem);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, purchaseItem);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(purchaseItem);

		return purchaseItem;
	}

	@Override
	public PurchaseItem updateImpl(com.sb.model.PurchaseItem purchaseItem,
		boolean merge) throws SystemException {
		purchaseItem = toUnwrappedModel(purchaseItem);

		boolean isNew = purchaseItem.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, purchaseItem, merge);

			purchaseItem.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseItemImpl.class, purchaseItem.getPrimaryKey(), purchaseItem);

		return purchaseItem;
	}

	protected PurchaseItem toUnwrappedModel(PurchaseItem purchaseItem) {
		if (purchaseItem instanceof PurchaseItemImpl) {
			return purchaseItem;
		}

		PurchaseItemImpl purchaseItemImpl = new PurchaseItemImpl();

		purchaseItemImpl.setNew(purchaseItem.isNew());
		purchaseItemImpl.setPrimaryKey(purchaseItem.getPrimaryKey());

		purchaseItemImpl.setPurchaseItemId(purchaseItem.getPurchaseItemId());
		purchaseItemImpl.setPoId(purchaseItem.getPoId());
		purchaseItemImpl.setItemId(purchaseItem.getItemId());
		purchaseItemImpl.setQuantity(purchaseItem.getQuantity());
		purchaseItemImpl.setUnitPrice(purchaseItem.getUnitPrice());

		return purchaseItemImpl;
	}

	/**
	 * Returns the purchase item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the purchase item
	 * @return the purchase item
	 * @throws com.liferay.portal.NoSuchModelException if a purchase item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the purchase item with the primary key or throws a {@link com.sb.NoSuchPurchaseItemException} if it could not be found.
	 *
	 * @param PurchaseItemId the primary key of the purchase item
	 * @return the purchase item
	 * @throws com.sb.NoSuchPurchaseItemException if a purchase item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PurchaseItem findByPrimaryKey(int PurchaseItemId)
		throws NoSuchPurchaseItemException, SystemException {
		PurchaseItem purchaseItem = fetchByPrimaryKey(PurchaseItemId);

		if (purchaseItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + PurchaseItemId);
			}

			throw new NoSuchPurchaseItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				PurchaseItemId);
		}

		return purchaseItem;
	}

	/**
	 * Returns the purchase item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the purchase item
	 * @return the purchase item, or <code>null</code> if a purchase item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the purchase item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PurchaseItemId the primary key of the purchase item
	 * @return the purchase item, or <code>null</code> if a purchase item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PurchaseItem fetchByPrimaryKey(int PurchaseItemId)
		throws SystemException {
		PurchaseItem purchaseItem = (PurchaseItem)EntityCacheUtil.getResult(PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
				PurchaseItemImpl.class, PurchaseItemId);

		if (purchaseItem == _nullPurchaseItem) {
			return null;
		}

		if (purchaseItem == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				purchaseItem = (PurchaseItem)session.get(PurchaseItemImpl.class,
						Integer.valueOf(PurchaseItemId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (purchaseItem != null) {
					cacheResult(purchaseItem);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PurchaseItemModelImpl.ENTITY_CACHE_ENABLED,
						PurchaseItemImpl.class, PurchaseItemId,
						_nullPurchaseItem);
				}

				closeSession(session);
			}
		}

		return purchaseItem;
	}

	/**
	 * Returns all the purchase items.
	 *
	 * @return the purchase items
	 * @throws SystemException if a system exception occurred
	 */
	public List<PurchaseItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchase items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase items
	 * @param end the upper bound of the range of purchase items (not inclusive)
	 * @return the range of purchase items
	 * @throws SystemException if a system exception occurred
	 */
	public List<PurchaseItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchase items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase items
	 * @param end the upper bound of the range of purchase items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of purchase items
	 * @throws SystemException if a system exception occurred
	 */
	public List<PurchaseItem> findAll(int start, int end,
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

		List<PurchaseItem> list = (List<PurchaseItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PURCHASEITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PURCHASEITEM;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PurchaseItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PurchaseItem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the purchase items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PurchaseItem purchaseItem : findAll()) {
			remove(purchaseItem);
		}
	}

	/**
	 * Returns the number of purchase items.
	 *
	 * @return the number of purchase items
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PURCHASEITEM);

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
	 * Initializes the purchase item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sb.model.PurchaseItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PurchaseItem>> listenersList = new ArrayList<ModelListener<PurchaseItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PurchaseItem>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PurchaseItemImpl.class.getName());
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
	private static final String _SQL_SELECT_PURCHASEITEM = "SELECT purchaseItem FROM PurchaseItem purchaseItem";
	private static final String _SQL_COUNT_PURCHASEITEM = "SELECT COUNT(purchaseItem) FROM PurchaseItem purchaseItem";
	private static final String _ORDER_BY_ENTITY_ALIAS = "purchaseItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PurchaseItem exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PurchaseItemPersistenceImpl.class);
	private static PurchaseItem _nullPurchaseItem = new PurchaseItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PurchaseItem> toCacheModel() {
				return _nullPurchaseItemCacheModel;
			}
		};

	private static CacheModel<PurchaseItem> _nullPurchaseItemCacheModel = new CacheModel<PurchaseItem>() {
			public PurchaseItem toEntityModel() {
				return _nullPurchaseItem;
			}
		};
}