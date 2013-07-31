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
 * This class is a wrapper for {@link PurchaseOrderLocalService}.
 * </p>
 *
 * @author    amifxw0
 * @see       PurchaseOrderLocalService
 * @generated
 */
public class PurchaseOrderLocalServiceWrapper
	implements PurchaseOrderLocalService,
		ServiceWrapper<PurchaseOrderLocalService> {
	public PurchaseOrderLocalServiceWrapper(
		PurchaseOrderLocalService purchaseOrderLocalService) {
		_purchaseOrderLocalService = purchaseOrderLocalService;
	}

	/**
	* Adds the purchase order to the database. Also notifies the appropriate model listeners.
	*
	* @param purchaseOrder the purchase order
	* @return the purchase order that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder addPurchaseOrder(
		com.sb.model.PurchaseOrder purchaseOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseOrderLocalService.addPurchaseOrder(purchaseOrder);
	}

	/**
	* Creates a new purchase order with the primary key. Does not add the purchase order to the database.
	*
	* @param PoId the primary key for the new purchase order
	* @return the new purchase order
	*/
	public com.sb.model.PurchaseOrder createPurchaseOrder(int PoId) {
		return _purchaseOrderLocalService.createPurchaseOrder(PoId);
	}

	/**
	* Deletes the purchase order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PoId the primary key of the purchase order
	* @return the purchase order that was removed
	* @throws PortalException if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder deletePurchaseOrder(int PoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _purchaseOrderLocalService.deletePurchaseOrder(PoId);
	}

	/**
	* Deletes the purchase order from the database. Also notifies the appropriate model listeners.
	*
	* @param purchaseOrder the purchase order
	* @return the purchase order that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder deletePurchaseOrder(
		com.sb.model.PurchaseOrder purchaseOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseOrderLocalService.deletePurchaseOrder(purchaseOrder);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _purchaseOrderLocalService.dynamicQuery();
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
		return _purchaseOrderLocalService.dynamicQuery(dynamicQuery);
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
		return _purchaseOrderLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _purchaseOrderLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _purchaseOrderLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.sb.model.PurchaseOrder fetchPurchaseOrder(int PoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseOrderLocalService.fetchPurchaseOrder(PoId);
	}

	/**
	* Returns the purchase order with the primary key.
	*
	* @param PoId the primary key of the purchase order
	* @return the purchase order
	* @throws PortalException if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder getPurchaseOrder(int PoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _purchaseOrderLocalService.getPurchaseOrder(PoId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _purchaseOrderLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.sb.model.PurchaseOrder> getPurchaseOrders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseOrderLocalService.getPurchaseOrders(start, end);
	}

	/**
	* Returns the number of purchase orders.
	*
	* @return the number of purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public int getPurchaseOrdersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseOrderLocalService.getPurchaseOrdersCount();
	}

	/**
	* Updates the purchase order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param purchaseOrder the purchase order
	* @return the purchase order that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder updatePurchaseOrder(
		com.sb.model.PurchaseOrder purchaseOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseOrderLocalService.updatePurchaseOrder(purchaseOrder);
	}

	/**
	* Updates the purchase order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param purchaseOrder the purchase order
	* @param merge whether to merge the purchase order with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the purchase order that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.sb.model.PurchaseOrder updatePurchaseOrder(
		com.sb.model.PurchaseOrder purchaseOrder, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _purchaseOrderLocalService.updatePurchaseOrder(purchaseOrder,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _purchaseOrderLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_purchaseOrderLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _purchaseOrderLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PurchaseOrderLocalService getWrappedPurchaseOrderLocalService() {
		return _purchaseOrderLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPurchaseOrderLocalService(
		PurchaseOrderLocalService purchaseOrderLocalService) {
		_purchaseOrderLocalService = purchaseOrderLocalService;
	}

	public PurchaseOrderLocalService getWrappedService() {
		return _purchaseOrderLocalService;
	}

	public void setWrappedService(
		PurchaseOrderLocalService purchaseOrderLocalService) {
		_purchaseOrderLocalService = purchaseOrderLocalService;
	}

	private PurchaseOrderLocalService _purchaseOrderLocalService;
}