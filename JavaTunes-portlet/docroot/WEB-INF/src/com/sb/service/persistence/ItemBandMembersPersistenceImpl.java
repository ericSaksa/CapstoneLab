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

import com.sb.NoSuchItemBandMembersException;

import com.sb.model.ItemBandMembers;
import com.sb.model.impl.ItemBandMembersImpl;
import com.sb.model.impl.ItemBandMembersModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the item band members service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author amifxw0
 * @see ItemBandMembersPersistence
 * @see ItemBandMembersUtil
 * @generated
 */
public class ItemBandMembersPersistenceImpl extends BasePersistenceImpl<ItemBandMembers>
	implements ItemBandMembersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ItemBandMembersUtil} to access the item band members persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ItemBandMembersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
			ItemBandMembersModelImpl.FINDER_CACHE_ENABLED,
			ItemBandMembersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
			ItemBandMembersModelImpl.FINDER_CACHE_ENABLED,
			ItemBandMembersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
			ItemBandMembersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the item band members in the entity cache if it is enabled.
	 *
	 * @param itemBandMembers the item band members
	 */
	public void cacheResult(ItemBandMembers itemBandMembers) {
		EntityCacheUtil.putResult(ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
			ItemBandMembersImpl.class, itemBandMembers.getPrimaryKey(),
			itemBandMembers);

		itemBandMembers.resetOriginalValues();
	}

	/**
	 * Caches the item band memberses in the entity cache if it is enabled.
	 *
	 * @param itemBandMemberses the item band memberses
	 */
	public void cacheResult(List<ItemBandMembers> itemBandMemberses) {
		for (ItemBandMembers itemBandMembers : itemBandMemberses) {
			if (EntityCacheUtil.getResult(
						ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
						ItemBandMembersImpl.class,
						itemBandMembers.getPrimaryKey()) == null) {
				cacheResult(itemBandMembers);
			}
			else {
				itemBandMembers.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all item band memberses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ItemBandMembersImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ItemBandMembersImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item band members.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ItemBandMembers itemBandMembers) {
		EntityCacheUtil.removeResult(ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
			ItemBandMembersImpl.class, itemBandMembers.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ItemBandMembers> itemBandMemberses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ItemBandMembers itemBandMembers : itemBandMemberses) {
			EntityCacheUtil.removeResult(ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
				ItemBandMembersImpl.class, itemBandMembers.getPrimaryKey());
		}
	}

	/**
	 * Creates a new item band members with the primary key. Does not add the item band members to the database.
	 *
	 * @param ItemBandMemberId the primary key for the new item band members
	 * @return the new item band members
	 */
	public ItemBandMembers create(int ItemBandMemberId) {
		ItemBandMembers itemBandMembers = new ItemBandMembersImpl();

		itemBandMembers.setNew(true);
		itemBandMembers.setPrimaryKey(ItemBandMemberId);

		return itemBandMembers;
	}

	/**
	 * Removes the item band members with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ItemBandMemberId the primary key of the item band members
	 * @return the item band members that was removed
	 * @throws com.sb.NoSuchItemBandMembersException if a item band members with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ItemBandMembers remove(int ItemBandMemberId)
		throws NoSuchItemBandMembersException, SystemException {
		return remove(Integer.valueOf(ItemBandMemberId));
	}

	/**
	 * Removes the item band members with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item band members
	 * @return the item band members that was removed
	 * @throws com.sb.NoSuchItemBandMembersException if a item band members with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemBandMembers remove(Serializable primaryKey)
		throws NoSuchItemBandMembersException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ItemBandMembers itemBandMembers = (ItemBandMembers)session.get(ItemBandMembersImpl.class,
					primaryKey);

			if (itemBandMembers == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemBandMembersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(itemBandMembers);
		}
		catch (NoSuchItemBandMembersException nsee) {
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
	protected ItemBandMembers removeImpl(ItemBandMembers itemBandMembers)
		throws SystemException {
		itemBandMembers = toUnwrappedModel(itemBandMembers);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, itemBandMembers);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(itemBandMembers);

		return itemBandMembers;
	}

	@Override
	public ItemBandMembers updateImpl(
		com.sb.model.ItemBandMembers itemBandMembers, boolean merge)
		throws SystemException {
		itemBandMembers = toUnwrappedModel(itemBandMembers);

		boolean isNew = itemBandMembers.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, itemBandMembers, merge);

			itemBandMembers.setNew(false);
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

		EntityCacheUtil.putResult(ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
			ItemBandMembersImpl.class, itemBandMembers.getPrimaryKey(),
			itemBandMembers);

		return itemBandMembers;
	}

	protected ItemBandMembers toUnwrappedModel(ItemBandMembers itemBandMembers) {
		if (itemBandMembers instanceof ItemBandMembersImpl) {
			return itemBandMembers;
		}

		ItemBandMembersImpl itemBandMembersImpl = new ItemBandMembersImpl();

		itemBandMembersImpl.setNew(itemBandMembers.isNew());
		itemBandMembersImpl.setPrimaryKey(itemBandMembers.getPrimaryKey());

		itemBandMembersImpl.setItemBandMemberId(itemBandMembers.getItemBandMemberId());
		itemBandMembersImpl.setItemId(itemBandMembers.getItemId());
		itemBandMembersImpl.setMember(itemBandMembers.getMember());

		return itemBandMembersImpl;
	}

	/**
	 * Returns the item band members with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item band members
	 * @return the item band members
	 * @throws com.liferay.portal.NoSuchModelException if a item band members with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemBandMembers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the item band members with the primary key or throws a {@link com.sb.NoSuchItemBandMembersException} if it could not be found.
	 *
	 * @param ItemBandMemberId the primary key of the item band members
	 * @return the item band members
	 * @throws com.sb.NoSuchItemBandMembersException if a item band members with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ItemBandMembers findByPrimaryKey(int ItemBandMemberId)
		throws NoSuchItemBandMembersException, SystemException {
		ItemBandMembers itemBandMembers = fetchByPrimaryKey(ItemBandMemberId);

		if (itemBandMembers == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ItemBandMemberId);
			}

			throw new NoSuchItemBandMembersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ItemBandMemberId);
		}

		return itemBandMembers;
	}

	/**
	 * Returns the item band members with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item band members
	 * @return the item band members, or <code>null</code> if a item band members with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemBandMembers fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the item band members with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ItemBandMemberId the primary key of the item band members
	 * @return the item band members, or <code>null</code> if a item band members with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ItemBandMembers fetchByPrimaryKey(int ItemBandMemberId)
		throws SystemException {
		ItemBandMembers itemBandMembers = (ItemBandMembers)EntityCacheUtil.getResult(ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
				ItemBandMembersImpl.class, ItemBandMemberId);

		if (itemBandMembers == _nullItemBandMembers) {
			return null;
		}

		if (itemBandMembers == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				itemBandMembers = (ItemBandMembers)session.get(ItemBandMembersImpl.class,
						Integer.valueOf(ItemBandMemberId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (itemBandMembers != null) {
					cacheResult(itemBandMembers);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
						ItemBandMembersImpl.class, ItemBandMemberId,
						_nullItemBandMembers);
				}

				closeSession(session);
			}
		}

		return itemBandMembers;
	}

	/**
	 * Returns all the item band memberses.
	 *
	 * @return the item band memberses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ItemBandMembers> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item band memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of item band memberses
	 * @param end the upper bound of the range of item band memberses (not inclusive)
	 * @return the range of item band memberses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ItemBandMembers> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the item band memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of item band memberses
	 * @param end the upper bound of the range of item band memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of item band memberses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ItemBandMembers> findAll(int start, int end,
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

		List<ItemBandMembers> list = (List<ItemBandMembers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ITEMBANDMEMBERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEMBANDMEMBERS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ItemBandMembers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ItemBandMembers>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the item band memberses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ItemBandMembers itemBandMembers : findAll()) {
			remove(itemBandMembers);
		}
	}

	/**
	 * Returns the number of item band memberses.
	 *
	 * @return the number of item band memberses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ITEMBANDMEMBERS);

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
	 * Initializes the item band members persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sb.model.ItemBandMembers")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ItemBandMembers>> listenersList = new ArrayList<ModelListener<ItemBandMembers>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ItemBandMembers>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ItemBandMembersImpl.class.getName());
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
	private static final String _SQL_SELECT_ITEMBANDMEMBERS = "SELECT itemBandMembers FROM ItemBandMembers itemBandMembers";
	private static final String _SQL_COUNT_ITEMBANDMEMBERS = "SELECT COUNT(itemBandMembers) FROM ItemBandMembers itemBandMembers";
	private static final String _ORDER_BY_ENTITY_ALIAS = "itemBandMembers.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ItemBandMembers exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ItemBandMembersPersistenceImpl.class);
	private static ItemBandMembers _nullItemBandMembers = new ItemBandMembersImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ItemBandMembers> toCacheModel() {
				return _nullItemBandMembersCacheModel;
			}
		};

	private static CacheModel<ItemBandMembers> _nullItemBandMembersCacheModel = new CacheModel<ItemBandMembers>() {
			public ItemBandMembers toEntityModel() {
				return _nullItemBandMembers;
			}
		};
}