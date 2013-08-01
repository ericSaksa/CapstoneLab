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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sb.NoSuchItemException;

import com.sb.model.Item;
import com.sb.model.impl.ItemImpl;
import com.sb.model.impl.ItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author amifxw0
 * @see ItemPersistence
 * @see ItemUtil
 * @generated
 */
public class ItemPersistenceImpl extends BasePersistenceImpl<Item>
	implements ItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ItemUtil} to access the item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, ItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLE = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTIST = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, ItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArtist",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_ARTIST = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByArtist",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, ItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, ItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the item in the entity cache if it is enabled.
	 *
	 * @param item the item
	 */
	public void cacheResult(Item item) {
		EntityCacheUtil.putResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemImpl.class, item.getPrimaryKey(), item);

		item.resetOriginalValues();
	}

	/**
	 * Caches the items in the entity cache if it is enabled.
	 *
	 * @param items the items
	 */
	public void cacheResult(List<Item> items) {
		for (Item item : items) {
			if (EntityCacheUtil.getResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
						ItemImpl.class, item.getPrimaryKey()) == null) {
				cacheResult(item);
			}
			else {
				item.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Item item) {
		EntityCacheUtil.removeResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemImpl.class, item.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Item> items) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Item item : items) {
			EntityCacheUtil.removeResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
				ItemImpl.class, item.getPrimaryKey());
		}
	}

	/**
	 * Creates a new item with the primary key. Does not add the item to the database.
	 *
	 * @param ItemId the primary key for the new item
	 * @return the new item
	 */
	public Item create(int ItemId) {
		Item item = new ItemImpl();

		item.setNew(true);
		item.setPrimaryKey(ItemId);

		return item;
	}

	/**
	 * Removes the item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ItemId the primary key of the item
	 * @return the item that was removed
	 * @throws com.sb.NoSuchItemException if a item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item remove(int ItemId) throws NoSuchItemException, SystemException {
		return remove(Integer.valueOf(ItemId));
	}

	/**
	 * Removes the item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item
	 * @return the item that was removed
	 * @throws com.sb.NoSuchItemException if a item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Item remove(Serializable primaryKey)
		throws NoSuchItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Item item = (Item)session.get(ItemImpl.class, primaryKey);

			if (item == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(item);
		}
		catch (NoSuchItemException nsee) {
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
	protected Item removeImpl(Item item) throws SystemException {
		item = toUnwrappedModel(item);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, item);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(item);

		return item;
	}

	@Override
	public Item updateImpl(com.sb.model.Item item, boolean merge)
		throws SystemException {
		item = toUnwrappedModel(item);

		boolean isNew = item.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, item, merge);

			item.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemImpl.class, item.getPrimaryKey(), item);

		return item;
	}

	protected Item toUnwrappedModel(Item item) {
		if (item instanceof ItemImpl) {
			return item;
		}

		ItemImpl itemImpl = new ItemImpl();

		itemImpl.setNew(item.isNew());
		itemImpl.setPrimaryKey(item.getPrimaryKey());

		itemImpl.setItemId(item.getItemId());
		itemImpl.setNum(item.getNum());
		itemImpl.setTitle(item.getTitle());
		itemImpl.setArtist(item.getArtist());
		itemImpl.setReleaseDate(item.getReleaseDate());
		itemImpl.setListPrice(item.getListPrice());
		itemImpl.setPrice(item.getPrice());
		itemImpl.setVersion(item.getVersion());

		return itemImpl;
	}

	/**
	 * Returns the item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item
	 * @return the item
	 * @throws com.liferay.portal.NoSuchModelException if a item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Item findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the item with the primary key or throws a {@link com.sb.NoSuchItemException} if it could not be found.
	 *
	 * @param ItemId the primary key of the item
	 * @return the item
	 * @throws com.sb.NoSuchItemException if a item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item findByPrimaryKey(int ItemId)
		throws NoSuchItemException, SystemException {
		Item item = fetchByPrimaryKey(ItemId);

		if (item == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ItemId);
			}

			throw new NoSuchItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ItemId);
		}

		return item;
	}

	/**
	 * Returns the item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item
	 * @return the item, or <code>null</code> if a item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Item fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ItemId the primary key of the item
	 * @return the item, or <code>null</code> if a item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item fetchByPrimaryKey(int ItemId) throws SystemException {
		Item item = (Item)EntityCacheUtil.getResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
				ItemImpl.class, ItemId);

		if (item == _nullItem) {
			return null;
		}

		if (item == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				item = (Item)session.get(ItemImpl.class, Integer.valueOf(ItemId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (item != null) {
					cacheResult(item);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
						ItemImpl.class, ItemId, _nullItem);
				}

				closeSession(session);
			}
		}

		return item;
	}

	/**
	 * Returns all the items where Title LIKE &#63;.
	 *
	 * @param Title the title
	 * @return the matching items
	 * @throws SystemException if a system exception occurred
	 */
	public List<Item> findByTitle(String Title) throws SystemException {
		return findByTitle(Title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the items where Title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param Title the title
	 * @param start the lower bound of the range of items
	 * @param end the upper bound of the range of items (not inclusive)
	 * @return the range of matching items
	 * @throws SystemException if a system exception occurred
	 */
	public List<Item> findByTitle(String Title, int start, int end)
		throws SystemException {
		return findByTitle(Title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the items where Title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param Title the title
	 * @param start the lower bound of the range of items
	 * @param end the upper bound of the range of items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching items
	 * @throws SystemException if a system exception occurred
	 */
	public List<Item> findByTitle(String Title, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
		finderArgs = new Object[] { Title, start, end, orderByComparator };

		List<Item> list = (List<Item>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Item item : list) {
				if (!Validator.equals(Title, item.getTitle())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ITEM_WHERE);

			if (Title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else {
				if (Title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_TITLE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (Title != null) {
					qPos.add(Title);
				}

				list = (List<Item>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first item in the ordered set where Title LIKE &#63;.
	 *
	 * @param Title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item
	 * @throws com.sb.NoSuchItemException if a matching item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item findByTitle_First(String Title,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		Item item = fetchByTitle_First(Title, orderByComparator);

		if (item != null) {
			return item;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("Title=");
		msg.append(Title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
	}

	/**
	 * Returns the first item in the ordered set where Title LIKE &#63;.
	 *
	 * @param Title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item, or <code>null</code> if a matching item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item fetchByTitle_First(String Title,
		OrderByComparator orderByComparator) throws SystemException {
		List<Item> list = findByTitle(Title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item in the ordered set where Title LIKE &#63;.
	 *
	 * @param Title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item
	 * @throws com.sb.NoSuchItemException if a matching item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item findByTitle_Last(String Title,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		Item item = fetchByTitle_Last(Title, orderByComparator);

		if (item != null) {
			return item;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("Title=");
		msg.append(Title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
	}

	/**
	 * Returns the last item in the ordered set where Title LIKE &#63;.
	 *
	 * @param Title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item, or <code>null</code> if a matching item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item fetchByTitle_Last(String Title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitle(Title);

		List<Item> list = findByTitle(Title, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the items before and after the current item in the ordered set where Title LIKE &#63;.
	 *
	 * @param ItemId the primary key of the current item
	 * @param Title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item
	 * @throws com.sb.NoSuchItemException if a item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item[] findByTitle_PrevAndNext(int ItemId, String Title,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		Item item = findByPrimaryKey(ItemId);

		Session session = null;

		try {
			session = openSession();

			Item[] array = new ItemImpl[3];

			array[0] = getByTitle_PrevAndNext(session, item, Title,
					orderByComparator, true);

			array[1] = item;

			array[2] = getByTitle_PrevAndNext(session, item, Title,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Item getByTitle_PrevAndNext(Session session, Item item,
		String Title, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEM_WHERE);

		if (Title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else {
			if (Title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (Title != null) {
			qPos.add(Title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(item);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Item> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the items where Artist LIKE &#63;.
	 *
	 * @param Artist the artist
	 * @return the matching items
	 * @throws SystemException if a system exception occurred
	 */
	public List<Item> findByArtist(String Artist) throws SystemException {
		return findByArtist(Artist, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the items where Artist LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param Artist the artist
	 * @param start the lower bound of the range of items
	 * @param end the upper bound of the range of items (not inclusive)
	 * @return the range of matching items
	 * @throws SystemException if a system exception occurred
	 */
	public List<Item> findByArtist(String Artist, int start, int end)
		throws SystemException {
		return findByArtist(Artist, start, end, null);
	}

	/**
	 * Returns an ordered range of all the items where Artist LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param Artist the artist
	 * @param start the lower bound of the range of items
	 * @param end the upper bound of the range of items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching items
	 * @throws SystemException if a system exception occurred
	 */
	public List<Item> findByArtist(String Artist, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTIST;
		finderArgs = new Object[] { Artist, start, end, orderByComparator };

		List<Item> list = (List<Item>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Item item : list) {
				if (!Validator.equals(Artist, item.getArtist())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ITEM_WHERE);

			if (Artist == null) {
				query.append(_FINDER_COLUMN_ARTIST_ARTIST_1);
			}
			else {
				if (Artist.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ARTIST_ARTIST_3);
				}
				else {
					query.append(_FINDER_COLUMN_ARTIST_ARTIST_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (Artist != null) {
					qPos.add(Artist);
				}

				list = (List<Item>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first item in the ordered set where Artist LIKE &#63;.
	 *
	 * @param Artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item
	 * @throws com.sb.NoSuchItemException if a matching item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item findByArtist_First(String Artist,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		Item item = fetchByArtist_First(Artist, orderByComparator);

		if (item != null) {
			return item;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("Artist=");
		msg.append(Artist);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
	}

	/**
	 * Returns the first item in the ordered set where Artist LIKE &#63;.
	 *
	 * @param Artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item, or <code>null</code> if a matching item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item fetchByArtist_First(String Artist,
		OrderByComparator orderByComparator) throws SystemException {
		List<Item> list = findByArtist(Artist, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item in the ordered set where Artist LIKE &#63;.
	 *
	 * @param Artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item
	 * @throws com.sb.NoSuchItemException if a matching item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item findByArtist_Last(String Artist,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		Item item = fetchByArtist_Last(Artist, orderByComparator);

		if (item != null) {
			return item;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("Artist=");
		msg.append(Artist);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
	}

	/**
	 * Returns the last item in the ordered set where Artist LIKE &#63;.
	 *
	 * @param Artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item, or <code>null</code> if a matching item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item fetchByArtist_Last(String Artist,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByArtist(Artist);

		List<Item> list = findByArtist(Artist, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the items before and after the current item in the ordered set where Artist LIKE &#63;.
	 *
	 * @param ItemId the primary key of the current item
	 * @param Artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item
	 * @throws com.sb.NoSuchItemException if a item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Item[] findByArtist_PrevAndNext(int ItemId, String Artist,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		Item item = findByPrimaryKey(ItemId);

		Session session = null;

		try {
			session = openSession();

			Item[] array = new ItemImpl[3];

			array[0] = getByArtist_PrevAndNext(session, item, Artist,
					orderByComparator, true);

			array[1] = item;

			array[2] = getByArtist_PrevAndNext(session, item, Artist,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Item getByArtist_PrevAndNext(Session session, Item item,
		String Artist, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEM_WHERE);

		if (Artist == null) {
			query.append(_FINDER_COLUMN_ARTIST_ARTIST_1);
		}
		else {
			if (Artist.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ARTIST_ARTIST_3);
			}
			else {
				query.append(_FINDER_COLUMN_ARTIST_ARTIST_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (Artist != null) {
			qPos.add(Artist);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(item);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Item> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the items.
	 *
	 * @return the items
	 * @throws SystemException if a system exception occurred
	 */
	public List<Item> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of items
	 * @param end the upper bound of the range of items (not inclusive)
	 * @return the range of items
	 * @throws SystemException if a system exception occurred
	 */
	public List<Item> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of items
	 * @param end the upper bound of the range of items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of items
	 * @throws SystemException if a system exception occurred
	 */
	public List<Item> findAll(int start, int end,
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

		List<Item> list = (List<Item>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEM;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Item>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Item>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the items where Title LIKE &#63; from the database.
	 *
	 * @param Title the title
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTitle(String Title) throws SystemException {
		for (Item item : findByTitle(Title)) {
			remove(item);
		}
	}

	/**
	 * Removes all the items where Artist LIKE &#63; from the database.
	 *
	 * @param Artist the artist
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByArtist(String Artist) throws SystemException {
		for (Item item : findByArtist(Artist)) {
			remove(item);
		}
	}

	/**
	 * Removes all the items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Item item : findAll()) {
			remove(item);
		}
	}

	/**
	 * Returns the number of items where Title LIKE &#63;.
	 *
	 * @param Title the title
	 * @return the number of matching items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTitle(String Title) throws SystemException {
		Object[] finderArgs = new Object[] { Title };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ITEM_WHERE);

			if (Title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else {
				if (Title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_TITLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (Title != null) {
					qPos.add(Title);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of items where Artist LIKE &#63;.
	 *
	 * @param Artist the artist
	 * @return the number of matching items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByArtist(String Artist) throws SystemException {
		Object[] finderArgs = new Object[] { Artist };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ARTIST,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ITEM_WHERE);

			if (Artist == null) {
				query.append(_FINDER_COLUMN_ARTIST_ARTIST_1);
			}
			else {
				if (Artist.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ARTIST_ARTIST_3);
				}
				else {
					query.append(_FINDER_COLUMN_ARTIST_ARTIST_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (Artist != null) {
					qPos.add(Artist);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ARTIST,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of items.
	 *
	 * @return the number of items
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ITEM);

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
	 * Returns all the item band memberses associated with the item.
	 *
	 * @param pk the primary key of the item
	 * @return the item band memberses associated with the item
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.sb.model.ItemBandMembers> getItemBandMemberses(int pk)
		throws SystemException {
		return getItemBandMemberses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the item band memberses associated with the item.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the item
	 * @param start the lower bound of the range of items
	 * @param end the upper bound of the range of items (not inclusive)
	 * @return the range of item band memberses associated with the item
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.sb.model.ItemBandMembers> getItemBandMemberses(int pk,
		int start, int end) throws SystemException {
		return getItemBandMemberses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ITEMBANDMEMBERSES = new FinderPath(com.sb.model.impl.ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
			com.sb.model.impl.ItemBandMembersModelImpl.FINDER_CACHE_ENABLED,
			com.sb.model.impl.ItemBandMembersImpl.class,
			com.sb.service.persistence.ItemBandMembersPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getItemBandMemberses",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_ITEMBANDMEMBERSES.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the item band memberses associated with the item.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the item
	 * @param start the lower bound of the range of items
	 * @param end the upper bound of the range of items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of item band memberses associated with the item
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.sb.model.ItemBandMembers> getItemBandMemberses(int pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<com.sb.model.ItemBandMembers> list = (List<com.sb.model.ItemBandMembers>)FinderCacheUtil.getResult(FINDER_PATH_GET_ITEMBANDMEMBERSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETITEMBANDMEMBERSES.concat(ORDER_BY_CLAUSE)
												   .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETITEMBANDMEMBERSES;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("Item_BandMembers",
					com.sb.model.impl.ItemBandMembersImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.sb.model.ItemBandMembers>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_ITEMBANDMEMBERSES,
						finderArgs);
				}
				else {
					itemBandMembersPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_ITEMBANDMEMBERSES,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ITEMBANDMEMBERSES_SIZE = new FinderPath(com.sb.model.impl.ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
			com.sb.model.impl.ItemBandMembersModelImpl.FINDER_CACHE_ENABLED,
			com.sb.model.impl.ItemBandMembersImpl.class,
			com.sb.service.persistence.ItemBandMembersPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getItemBandMembersesSize", new String[] { Integer.class.getName() });

	static {
		FINDER_PATH_GET_ITEMBANDMEMBERSES_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of item band memberses associated with the item.
	 *
	 * @param pk the primary key of the item
	 * @return the number of item band memberses associated with the item
	 * @throws SystemException if a system exception occurred
	 */
	public int getItemBandMembersesSize(int pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ITEMBANDMEMBERSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETITEMBANDMEMBERSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_ITEMBANDMEMBERSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ITEMBANDMEMBERS = new FinderPath(com.sb.model.impl.ItemBandMembersModelImpl.ENTITY_CACHE_ENABLED,
			com.sb.model.impl.ItemBandMembersModelImpl.FINDER_CACHE_ENABLED,
			com.sb.model.impl.ItemBandMembersImpl.class,
			com.sb.service.persistence.ItemBandMembersPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsItemBandMembers",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns <code>true</code> if the item band members is associated with the item.
	 *
	 * @param pk the primary key of the item
	 * @param itemBandMembersPK the primary key of the item band members
	 * @return <code>true</code> if the item band members is associated with the item; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsItemBandMembers(int pk, int itemBandMembersPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, itemBandMembersPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ITEMBANDMEMBERS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsItemBandMembers.contains(pk,
							itemBandMembersPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ITEMBANDMEMBERS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the item has any item band memberses associated with it.
	 *
	 * @param pk the primary key of the item to check for associations with item band memberses
	 * @return <code>true</code> if the item has any item band memberses associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsItemBandMemberses(int pk) throws SystemException {
		if (getItemBandMembersesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Returns all the inventories associated with the item.
	 *
	 * @param pk the primary key of the item
	 * @return the inventories associated with the item
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.sb.model.Inventory> getInventories(int pk)
		throws SystemException {
		return getInventories(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the inventories associated with the item.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the item
	 * @param start the lower bound of the range of items
	 * @param end the upper bound of the range of items (not inclusive)
	 * @return the range of inventories associated with the item
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.sb.model.Inventory> getInventories(int pk, int start,
		int end) throws SystemException {
		return getInventories(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_INVENTORIES = new FinderPath(com.sb.model.impl.InventoryModelImpl.ENTITY_CACHE_ENABLED,
			com.sb.model.impl.InventoryModelImpl.FINDER_CACHE_ENABLED,
			com.sb.model.impl.InventoryImpl.class,
			com.sb.service.persistence.InventoryPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getInventories",
			new String[] {
				Integer.class.getName(), "java.lang.Integer",
				"java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_INVENTORIES.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the inventories associated with the item.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the item
	 * @param start the lower bound of the range of items
	 * @param end the upper bound of the range of items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of inventories associated with the item
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.sb.model.Inventory> getInventories(int pk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<com.sb.model.Inventory> list = (List<com.sb.model.Inventory>)FinderCacheUtil.getResult(FINDER_PATH_GET_INVENTORIES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETINVENTORIES.concat(ORDER_BY_CLAUSE)
											 .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETINVENTORIES;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("inventory", com.sb.model.impl.InventoryImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.sb.model.Inventory>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_INVENTORIES,
						finderArgs);
				}
				else {
					inventoryPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_INVENTORIES,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_INVENTORIES_SIZE = new FinderPath(com.sb.model.impl.InventoryModelImpl.ENTITY_CACHE_ENABLED,
			com.sb.model.impl.InventoryModelImpl.FINDER_CACHE_ENABLED,
			com.sb.model.impl.InventoryImpl.class,
			com.sb.service.persistence.InventoryPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getInventoriesSize", new String[] { Integer.class.getName() });

	static {
		FINDER_PATH_GET_INVENTORIES_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of inventories associated with the item.
	 *
	 * @param pk the primary key of the item
	 * @return the number of inventories associated with the item
	 * @throws SystemException if a system exception occurred
	 */
	public int getInventoriesSize(int pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_INVENTORIES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETINVENTORIESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_INVENTORIES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_INVENTORY = new FinderPath(com.sb.model.impl.InventoryModelImpl.ENTITY_CACHE_ENABLED,
			com.sb.model.impl.InventoryModelImpl.FINDER_CACHE_ENABLED,
			com.sb.model.impl.InventoryImpl.class,
			com.sb.service.persistence.InventoryPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsInventory",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns <code>true</code> if the inventory is associated with the item.
	 *
	 * @param pk the primary key of the item
	 * @param inventoryPK the primary key of the inventory
	 * @return <code>true</code> if the inventory is associated with the item; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsInventory(int pk, int inventoryPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, inventoryPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_INVENTORY,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsInventory.contains(pk,
							inventoryPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_INVENTORY,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the item has any inventories associated with it.
	 *
	 * @param pk the primary key of the item to check for associations with inventories
	 * @return <code>true</code> if the item has any inventories associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsInventories(int pk) throws SystemException {
		if (getInventoriesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sb.model.Item")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Item>> listenersList = new ArrayList<ModelListener<Item>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Item>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsItemBandMembers = new ContainsItemBandMembers();

		containsInventory = new ContainsInventory();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ItemImpl.class.getName());
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
	protected ContainsItemBandMembers containsItemBandMembers;
	protected ContainsInventory containsInventory;

	protected class ContainsItemBandMembers {
		protected ContainsItemBandMembers() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSITEMBANDMEMBERS,
					new int[] { java.sql.Types.INTEGER, java.sql.Types.INTEGER },
					RowMapper.COUNT);
		}

		protected boolean contains(int ItemId, int ItemBandMemberId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Integer(ItemId), new Integer(ItemBandMemberId)
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

	protected class ContainsInventory {
		protected ContainsInventory() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSINVENTORY,
					new int[] { java.sql.Types.INTEGER, java.sql.Types.INTEGER },
					RowMapper.COUNT);
		}

		protected boolean contains(int ItemId, int InvId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Integer(ItemId), new Integer(InvId)
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

	private static final String _SQL_SELECT_ITEM = "SELECT item FROM Item item";
	private static final String _SQL_SELECT_ITEM_WHERE = "SELECT item FROM Item item WHERE ";
	private static final String _SQL_COUNT_ITEM = "SELECT COUNT(item) FROM Item item";
	private static final String _SQL_COUNT_ITEM_WHERE = "SELECT COUNT(item) FROM Item item WHERE ";
	private static final String _SQL_GETITEMBANDMEMBERSES = "SELECT {Item_BandMembers.*} FROM Item_BandMembers INNER JOIN item ON (item.ItemId = Item_BandMembers.ItemId) WHERE (item.ItemId = ?)";
	private static final String _SQL_GETITEMBANDMEMBERSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM Item_BandMembers WHERE ItemId = ?";
	private static final String _SQL_CONTAINSITEMBANDMEMBERS = "SELECT COUNT(*) AS COUNT_VALUE FROM Item_BandMembers WHERE ItemId = ? AND ItemBandMemberId = ?";
	private static final String _SQL_GETINVENTORIES = "SELECT {inventory.*} FROM inventory INNER JOIN item ON (item.ItemId = inventory.ItemId) WHERE (item.ItemId = ?)";
	private static final String _SQL_GETINVENTORIESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM inventory WHERE ItemId = ?";
	private static final String _SQL_CONTAINSINVENTORY = "SELECT COUNT(*) AS COUNT_VALUE FROM inventory WHERE ItemId = ? AND InvId = ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "item.Title LIKE NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "item.Title LIKE ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(item.Title IS NULL OR item.Title LIKE ?)";
	private static final String _FINDER_COLUMN_ARTIST_ARTIST_1 = "item.Artist LIKE NULL";
	private static final String _FINDER_COLUMN_ARTIST_ARTIST_2 = "item.Artist LIKE ?";
	private static final String _FINDER_COLUMN_ARTIST_ARTIST_3 = "(item.Artist IS NULL OR item.Artist LIKE ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "item.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Item exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Item exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ItemPersistenceImpl.class);
	private static Item _nullItem = new ItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Item> toCacheModel() {
				return _nullItemCacheModel;
			}
		};

	private static CacheModel<Item> _nullItemCacheModel = new CacheModel<Item>() {
			public Item toEntityModel() {
				return _nullItem;
			}
		};
}