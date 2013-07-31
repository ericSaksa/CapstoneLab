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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sb.model.Item;

/**
 * The persistence interface for the item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author amifxw0
 * @see ItemPersistenceImpl
 * @see ItemUtil
 * @generated
 */
public interface ItemPersistence extends BasePersistence<Item> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ItemUtil} to access the item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the item in the entity cache if it is enabled.
	*
	* @param item the item
	*/
	public void cacheResult(com.sb.model.Item item);

	/**
	* Caches the items in the entity cache if it is enabled.
	*
	* @param items the items
	*/
	public void cacheResult(java.util.List<com.sb.model.Item> items);

	/**
	* Creates a new item with the primary key. Does not add the item to the database.
	*
	* @param ItemId the primary key for the new item
	* @return the new item
	*/
	public com.sb.model.Item create(int ItemId);

	/**
	* Removes the item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ItemId the primary key of the item
	* @return the item that was removed
	* @throws com.sb.NoSuchItemException if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.Item remove(int ItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchItemException;

	public com.sb.model.Item updateImpl(com.sb.model.Item item, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item with the primary key or throws a {@link com.sb.NoSuchItemException} if it could not be found.
	*
	* @param ItemId the primary key of the item
	* @return the item
	* @throws com.sb.NoSuchItemException if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.Item findByPrimaryKey(int ItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchItemException;

	/**
	* Returns the item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ItemId the primary key of the item
	* @return the item, or <code>null</code> if a item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.Item fetchByPrimaryKey(int ItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the items.
	*
	* @return the items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sb.model.Item> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.Item> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.Item> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of items.
	*
	* @return the number of items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item band memberses associated with the item.
	*
	* @param pk the primary key of the item
	* @return the item band memberses associated with the item
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sb.model.ItemBandMembers> getItemBandMemberses(
		int pk) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.ItemBandMembers> getItemBandMemberses(
		int pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.ItemBandMembers> getItemBandMemberses(
		int pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item band memberses associated with the item.
	*
	* @param pk the primary key of the item
	* @return the number of item band memberses associated with the item
	* @throws SystemException if a system exception occurred
	*/
	public int getItemBandMembersesSize(int pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the item band members is associated with the item.
	*
	* @param pk the primary key of the item
	* @param itemBandMembersPK the primary key of the item band members
	* @return <code>true</code> if the item band members is associated with the item; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsItemBandMembers(int pk, int itemBandMembersPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the item has any item band memberses associated with it.
	*
	* @param pk the primary key of the item to check for associations with item band memberses
	* @return <code>true</code> if the item has any item band memberses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsItemBandMemberses(int pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the inventories associated with the item.
	*
	* @param pk the primary key of the item
	* @return the inventories associated with the item
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sb.model.Inventory> getInventories(int pk)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.Inventory> getInventories(int pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.Inventory> getInventories(int pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of inventories associated with the item.
	*
	* @param pk the primary key of the item
	* @return the number of inventories associated with the item
	* @throws SystemException if a system exception occurred
	*/
	public int getInventoriesSize(int pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the inventory is associated with the item.
	*
	* @param pk the primary key of the item
	* @param inventoryPK the primary key of the inventory
	* @return <code>true</code> if the inventory is associated with the item; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsInventory(int pk, int inventoryPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the item has any inventories associated with it.
	*
	* @param pk the primary key of the item to check for associations with inventories
	* @return <code>true</code> if the item has any inventories associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsInventories(int pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}