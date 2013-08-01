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

import com.sb.model.PurchaseOrder;

/**
 * The persistence interface for the purchase order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author amifxw0
 * @see PurchaseOrderPersistenceImpl
 * @see PurchaseOrderUtil
 * @generated
 */
public interface PurchaseOrderPersistence extends BasePersistence<PurchaseOrder> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PurchaseOrderUtil} to access the purchase order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the purchase order in the entity cache if it is enabled.
	*
	* @param purchaseOrder the purchase order
	*/
	public void cacheResult(com.sb.model.PurchaseOrder purchaseOrder);

	/**
	* Caches the purchase orders in the entity cache if it is enabled.
	*
	* @param purchaseOrders the purchase orders
	*/
	public void cacheResult(
		java.util.List<com.sb.model.PurchaseOrder> purchaseOrders);

	/**
	* Creates a new purchase order with the primary key. Does not add the purchase order to the database.
	*
	* @param PoId the primary key for the new purchase order
	* @return the new purchase order
	*/
	public com.sb.model.PurchaseOrder create(int PoId);

	/**
	* Removes the purchase order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PoId the primary key of the purchase order
	* @return the purchase order that was removed
	* @throws com.sb.NoSuchPurchaseOrderException if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder remove(int PoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchPurchaseOrderException;

	public com.sb.model.PurchaseOrder updateImpl(
		com.sb.model.PurchaseOrder purchaseOrder, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the purchase order with the primary key or throws a {@link com.sb.NoSuchPurchaseOrderException} if it could not be found.
	*
	* @param PoId the primary key of the purchase order
	* @return the purchase order
	* @throws com.sb.NoSuchPurchaseOrderException if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder findByPrimaryKey(int PoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchPurchaseOrderException;

	/**
	* Returns the purchase order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PoId the primary key of the purchase order
	* @return the purchase order, or <code>null</code> if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder fetchByPrimaryKey(int PoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the purchase orders where UserId = &#63;.
	*
	* @param UserId the user ID
	* @return the matching purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sb.model.PurchaseOrder> findByOrderByUserId(
		int UserId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the purchase orders where UserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UserId the user ID
	* @param start the lower bound of the range of purchase orders
	* @param end the upper bound of the range of purchase orders (not inclusive)
	* @return the range of matching purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sb.model.PurchaseOrder> findByOrderByUserId(
		int UserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the purchase orders where UserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UserId the user ID
	* @param start the lower bound of the range of purchase orders
	* @param end the upper bound of the range of purchase orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sb.model.PurchaseOrder> findByOrderByUserId(
		int UserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first purchase order in the ordered set where UserId = &#63;.
	*
	* @param UserId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching purchase order
	* @throws com.sb.NoSuchPurchaseOrderException if a matching purchase order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder findByOrderByUserId_First(int UserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchPurchaseOrderException;

	/**
	* Returns the first purchase order in the ordered set where UserId = &#63;.
	*
	* @param UserId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching purchase order, or <code>null</code> if a matching purchase order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder fetchByOrderByUserId_First(int UserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last purchase order in the ordered set where UserId = &#63;.
	*
	* @param UserId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching purchase order
	* @throws com.sb.NoSuchPurchaseOrderException if a matching purchase order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder findByOrderByUserId_Last(int UserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchPurchaseOrderException;

	/**
	* Returns the last purchase order in the ordered set where UserId = &#63;.
	*
	* @param UserId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching purchase order, or <code>null</code> if a matching purchase order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder fetchByOrderByUserId_Last(int UserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the purchase orders before and after the current purchase order in the ordered set where UserId = &#63;.
	*
	* @param PoId the primary key of the current purchase order
	* @param UserId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next purchase order
	* @throws com.sb.NoSuchPurchaseOrderException if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder[] findByOrderByUserId_PrevAndNext(
		int PoId, int UserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchPurchaseOrderException;

	/**
	* Returns all the purchase orders.
	*
	* @return the purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sb.model.PurchaseOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.PurchaseOrder> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.PurchaseOrder> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the purchase orders where UserId = &#63; from the database.
	*
	* @param UserId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrderByUserId(int UserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the purchase orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of purchase orders where UserId = &#63;.
	*
	* @param UserId the user ID
	* @return the number of matching purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrderByUserId(int UserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of purchase orders.
	*
	* @return the number of purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the purchase items associated with the purchase order.
	*
	* @param pk the primary key of the purchase order
	* @return the purchase items associated with the purchase order
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sb.model.PurchaseItem> getPurchaseItems(int pk)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.PurchaseItem> getPurchaseItems(int pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sb.model.PurchaseItem> getPurchaseItems(int pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of purchase items associated with the purchase order.
	*
	* @param pk the primary key of the purchase order
	* @return the number of purchase items associated with the purchase order
	* @throws SystemException if a system exception occurred
	*/
	public int getPurchaseItemsSize(int pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the purchase item is associated with the purchase order.
	*
	* @param pk the primary key of the purchase order
	* @param purchaseItemPK the primary key of the purchase item
	* @return <code>true</code> if the purchase item is associated with the purchase order; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsPurchaseItem(int pk, int purchaseItemPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the purchase order has any purchase items associated with it.
	*
	* @param pk the primary key of the purchase order to check for associations with purchase items
	* @return <code>true</code> if the purchase order has any purchase items associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsPurchaseItems(int pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}