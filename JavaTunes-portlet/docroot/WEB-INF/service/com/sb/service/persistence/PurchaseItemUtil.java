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

import com.sb.model.PurchaseItem;

import java.util.List;

/**
 * The persistence utility for the purchase item service. This utility wraps {@link PurchaseItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author amifxw0
 * @see PurchaseItemPersistence
 * @see PurchaseItemPersistenceImpl
 * @generated
 */
public class PurchaseItemUtil {
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
	public static void clearCache(PurchaseItem purchaseItem) {
		getPersistence().clearCache(purchaseItem);
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
	public static List<PurchaseItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PurchaseItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PurchaseItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PurchaseItem update(PurchaseItem purchaseItem, boolean merge)
		throws SystemException {
		return getPersistence().update(purchaseItem, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PurchaseItem update(PurchaseItem purchaseItem, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(purchaseItem, merge, serviceContext);
	}

	/**
	* Caches the purchase item in the entity cache if it is enabled.
	*
	* @param purchaseItem the purchase item
	*/
	public static void cacheResult(com.sb.model.PurchaseItem purchaseItem) {
		getPersistence().cacheResult(purchaseItem);
	}

	/**
	* Caches the purchase items in the entity cache if it is enabled.
	*
	* @param purchaseItems the purchase items
	*/
	public static void cacheResult(
		java.util.List<com.sb.model.PurchaseItem> purchaseItems) {
		getPersistence().cacheResult(purchaseItems);
	}

	/**
	* Creates a new purchase item with the primary key. Does not add the purchase item to the database.
	*
	* @param PurchaseItemId the primary key for the new purchase item
	* @return the new purchase item
	*/
	public static com.sb.model.PurchaseItem create(int PurchaseItemId) {
		return getPersistence().create(PurchaseItemId);
	}

	/**
	* Removes the purchase item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PurchaseItemId the primary key of the purchase item
	* @return the purchase item that was removed
	* @throws com.sb.NoSuchPurchaseItemException if a purchase item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.PurchaseItem remove(int PurchaseItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchPurchaseItemException {
		return getPersistence().remove(PurchaseItemId);
	}

	public static com.sb.model.PurchaseItem updateImpl(
		com.sb.model.PurchaseItem purchaseItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(purchaseItem, merge);
	}

	/**
	* Returns the purchase item with the primary key or throws a {@link com.sb.NoSuchPurchaseItemException} if it could not be found.
	*
	* @param PurchaseItemId the primary key of the purchase item
	* @return the purchase item
	* @throws com.sb.NoSuchPurchaseItemException if a purchase item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.PurchaseItem findByPrimaryKey(int PurchaseItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchPurchaseItemException {
		return getPersistence().findByPrimaryKey(PurchaseItemId);
	}

	/**
	* Returns the purchase item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PurchaseItemId the primary key of the purchase item
	* @return the purchase item, or <code>null</code> if a purchase item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.PurchaseItem fetchByPrimaryKey(
		int PurchaseItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(PurchaseItemId);
	}

	/**
	* Returns all the purchase items.
	*
	* @return the purchase items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sb.model.PurchaseItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.sb.model.PurchaseItem> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.sb.model.PurchaseItem> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the purchase items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of purchase items.
	*
	* @return the number of purchase items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PurchaseItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PurchaseItemPersistence)PortletBeanLocatorUtil.locate(com.sb.service.ClpSerializer.getServletContextName(),
					PurchaseItemPersistence.class.getName());

			ReferenceRegistry.registerReference(PurchaseItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PurchaseItemPersistence persistence) {
	}

	private static PurchaseItemPersistence _persistence;
}