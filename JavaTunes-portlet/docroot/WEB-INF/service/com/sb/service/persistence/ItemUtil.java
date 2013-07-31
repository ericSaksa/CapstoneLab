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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sb.model.Item;

import java.util.List;

/**
 * The persistence utility for the item service. This utility wraps {@link ItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author amifxw0
 * @see ItemPersistence
 * @see ItemPersistenceImpl
 * @generated
 */
public class ItemUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Item item) {
		getPersistence().clearCache(item);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Item> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Item> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Item> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Item update(Item item, boolean merge)
		throws SystemException {
		return getPersistence().update(item, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Item update(Item item, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(item, merge, serviceContext);
	}

	/**
	* Caches the item in the entity cache if it is enabled.
	*
	* @param item the item
	*/
	public static void cacheResult(com.sb.model.Item item) {
		getPersistence().cacheResult(item);
	}

	/**
	* Caches the items in the entity cache if it is enabled.
	*
	* @param items the items
	*/
	public static void cacheResult(java.util.List<com.sb.model.Item> items) {
		getPersistence().cacheResult(items);
	}

	/**
	* Creates a new item with the primary key. Does not add the item to the database.
	*
	* @param ItemId the primary key for the new item
	* @return the new item
	*/
	public static com.sb.model.Item create(int ItemId) {
		return getPersistence().create(ItemId);
	}

	/**
	* Removes the item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ItemId the primary key of the item
	* @return the item that was removed
	* @throws com.sb.NoSuchItemException if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Item remove(int ItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchItemException {
		return getPersistence().remove(ItemId);
	}

	public static com.sb.model.Item updateImpl(com.sb.model.Item item,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(item, merge);
	}

	/**
	* Returns the item with the primary key or throws a {@link com.sb.NoSuchItemException} if it could not be found.
	*
	* @param ItemId the primary key of the item
	* @return the item
	* @throws com.sb.NoSuchItemException if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Item findByPrimaryKey(int ItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchItemException {
		return getPersistence().findByPrimaryKey(ItemId);
	}

	/**
	* Returns the item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ItemId the primary key of the item
	* @return the item, or <code>null</code> if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.Item fetchByPrimaryKey(int ItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ItemId);
	}

	/**
	* Returns all the items.
	*
	* @return the items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sb.model.Item> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.sb.model.Item> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.sb.model.Item> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of items.
	*
	* @return the number of items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the item band memberses associated with the item.
	*
	* @param pk the primary key of the item
	* @return the item band memberses associated with the item
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sb.model.ItemBandMembers> getItemBandMemberses(
		int pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getItemBandMemberses(pk);
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
	public static java.util.List<com.sb.model.ItemBandMembers> getItemBandMemberses(
		int pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getItemBandMemberses(pk, start, end);
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
	public static java.util.List<com.sb.model.ItemBandMembers> getItemBandMemberses(
		int pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getItemBandMemberses(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of item band memberses associated with the item.
	*
	* @param pk the primary key of the item
	* @return the number of item band memberses associated with the item
	* @throws SystemException if a system exception occurred
	*/
	public static int getItemBandMembersesSize(int pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getItemBandMembersesSize(pk);
	}

	/**
	* Returns <code>true</code> if the item band members is associated with the item.
	*
	* @param pk the primary key of the item
	* @param itemBandMembersPK the primary key of the item band members
	* @return <code>true</code> if the item band members is associated with the item; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsItemBandMembers(int pk, int itemBandMembersPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsItemBandMembers(pk, itemBandMembersPK);
	}

	/**
	* Returns <code>true</code> if the item has any item band memberses associated with it.
	*
	* @param pk the primary key of the item to check for associations with item band memberses
	* @return <code>true</code> if the item has any item band memberses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsItemBandMemberses(int pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsItemBandMemberses(pk);
	}

	/**
	* Returns all the inventories associated with the item.
	*
	* @param pk the primary key of the item
	* @return the inventories associated with the item
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sb.model.Inventory> getInventories(int pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getInventories(pk);
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
	public static java.util.List<com.sb.model.Inventory> getInventories(
		int pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getInventories(pk, start, end);
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
	public static java.util.List<com.sb.model.Inventory> getInventories(
		int pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getInventories(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of inventories associated with the item.
	*
	* @param pk the primary key of the item
	* @return the number of inventories associated with the item
	* @throws SystemException if a system exception occurred
	*/
	public static int getInventoriesSize(int pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getInventoriesSize(pk);
	}

	/**
	* Returns <code>true</code> if the inventory is associated with the item.
	*
	* @param pk the primary key of the item
	* @param inventoryPK the primary key of the inventory
	* @return <code>true</code> if the inventory is associated with the item; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsInventory(int pk, int inventoryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsInventory(pk, inventoryPK);
	}

	/**
	* Returns <code>true</code> if the item has any inventories associated with it.
	*
	* @param pk the primary key of the item to check for associations with inventories
	* @return <code>true</code> if the item has any inventories associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsInventories(int pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsInventories(pk);
	}

	public static ItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ItemPersistence)PortletBeanLocatorUtil.locate(com.sb.service.ClpSerializer.getServletContextName(),
					ItemPersistence.class.getName());

			ReferenceRegistry.registerReference(ItemUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ItemPersistence persistence) {
	}

	private static ItemPersistence _persistence;
}