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

package com.sb.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PurchaseItemLocalService}.
 * </p>
 *
 * @author    amifxw0
 * @see       PurchaseItemLocalService
 * @generated
 */
public class PurchaseItemLocalServiceWrapper implements PurchaseItemLocalService,
	ServiceWrapper<PurchaseItemLocalService> {
	public PurchaseItemLocalServiceWrapper(
		PurchaseItemLocalService purchaseItemLocalService) {
		_purchaseItemLocalService = purchaseItemLocalService;
	}

	/**
	* Adds the purchase item to the database. Also notifies the appropriate model listeners.
	*
	* @param purchaseItem the purchase item
	* @return the purchase item that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseItem addPurchaseItem(
		com.sb.model.PurchaseItem purchaseItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.addPurchaseItem(purchaseItem);
	}

	/**
	* Creates a new purchase item with the primary key. Does not add the purchase item to the database.
	*
	* @param PurchaseItemId the primary key for the new purchase item
	* @return the new purchase item
	*/
	public com.sb.model.PurchaseItem createPurchaseItem(int PurchaseItemId) {
		return _purchaseItemLocalService.createPurchaseItem(PurchaseItemId);
	}

	/**
	* Deletes the purchase item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PurchaseItemId the primary key of the purchase item
	* @return the purchase item that was removed
	* @throws PortalException if a purchase item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseItem deletePurchaseItem(int PurchaseItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.deletePurchaseItem(PurchaseItemId);
	}

	/**
	* Deletes the purchase item from the database. Also notifies the appropriate model listeners.
	*
	* @param purchaseItem the purchase item
	* @return the purchase item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseItem deletePurchaseItem(
		com.sb.model.PurchaseItem purchaseItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.deletePurchaseItem(purchaseItem);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _purchaseItemLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.sb.model.PurchaseItem fetchPurchaseItem(int PurchaseItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.fetchPurchaseItem(PurchaseItemId);
	}

	/**
	* Returns the purchase item with the primary key.
	*
	* @param PurchaseItemId the primary key of the purchase item
	* @return the purchase item
	* @throws PortalException if a purchase item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseItem getPurchaseItem(int PurchaseItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.getPurchaseItem(PurchaseItemId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.sb.model.PurchaseItem> getPurchaseItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.getPurchaseItems(start, end);
	}

	/**
	* Returns the number of purchase items.
	*
	* @return the number of purchase items
	* @throws SystemException if a system exception occurred
	*/
	public int getPurchaseItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.getPurchaseItemsCount();
	}

	/**
	* Updates the purchase item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param purchaseItem the purchase item
	* @return the purchase item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseItem updatePurchaseItem(
		com.sb.model.PurchaseItem purchaseItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.updatePurchaseItem(purchaseItem);
	}

	/**
	* Updates the purchase item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param purchaseItem the purchase item
	* @param merge whether to merge the purchase item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the purchase item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseItem updatePurchaseItem(
		com.sb.model.PurchaseItem purchaseItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseItemLocalService.updatePurchaseItem(purchaseItem, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _purchaseItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_purchaseItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _purchaseItemLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PurchaseItemLocalService getWrappedPurchaseItemLocalService() {
		return _purchaseItemLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPurchaseItemLocalService(
		PurchaseItemLocalService purchaseItemLocalService) {
		_purchaseItemLocalService = purchaseItemLocalService;
	}

	public PurchaseItemLocalService getWrappedService() {
		return _purchaseItemLocalService;
	}

	public void setWrappedService(
		PurchaseItemLocalService purchaseItemLocalService) {
		_purchaseItemLocalService = purchaseItemLocalService;
	}

	private PurchaseItemLocalService _purchaseItemLocalService;
}