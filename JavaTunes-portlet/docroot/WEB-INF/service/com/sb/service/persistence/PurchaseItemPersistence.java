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

import com.sb.model.PurchaseItem;

/**
 * The persistence interface for the purchase item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author amifxw0
 * @see PurchaseItemPersistenceImpl
 * @see PurchaseItemUtil
 * @generated
 */
public interface PurchaseItemPersistence extends BasePersistence<PurchaseItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PurchaseItemUtil} to access the purchase item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the purchase item in the entity cache if it is enabled.
	*
	* @param purchaseItem the purchase item
	*/
	public void cacheResult(com.sb.model.PurchaseItem purchaseItem);

	/**
	* Caches the purchase items in the entity cache if it is enabled.
	*
	* @param purchaseItems the purchase items
	*/
	public void cacheResult(
		java.util.List<com.sb.model.PurchaseItem> purchaseItems);

	/**
	* Creates a new purchase item with the primary key. Does not add the purchase item to the database.
	*
	* @param PurchaseItemId the primary key for the new purchase item
	* @return the new purchase item
	*/
	public com.sb.model.PurchaseItem create(int PurchaseItemId);

	/**
	* Removes the purchase item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PurchaseItemId the primary key of the purchase item
	* @return the purchase item that was removed
	* @throws com.sb.NoSuchPurchaseItemException if a purchase item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseItem remove(int PurchaseItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchPurchaseItemException;

	public com.sb.model.PurchaseItem updateImpl(
		com.sb.model.PurchaseItem purchaseItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the purchase item with the primary key or throws a {@link com.sb.NoSuchPurchaseItemException} if it could not be found.
	*
	* @param PurchaseItemId the primary key of the purchase item
	* @return the purchase item
	* @throws com.sb.NoSuchPurchaseItemException if a purchase item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseItem findByPrimaryKey(int PurchaseItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchPurchaseItemException;

	/**
	* Returns the purchase item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PurchaseItemId the primary key of the purchase item
	* @return the purchase item, or <code>null</code> if a purchase item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseItem fetchByPrimaryKey(int PurchaseItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the purchase items.
	*
	* @return the purchase items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sb.model.PurchaseItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.PurchaseItem> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.PurchaseItem> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the purchase items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of purchase items.
	*
	* @return the number of purchase items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}