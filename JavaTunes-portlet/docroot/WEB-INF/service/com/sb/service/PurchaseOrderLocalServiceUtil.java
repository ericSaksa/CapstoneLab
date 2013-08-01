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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the purchase order local service. This utility wraps {@link com.sb.service.impl.PurchaseOrderLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author amifxw0
 * @see PurchaseOrderLocalService
 * @see com.sb.service.base.PurchaseOrderLocalServiceBaseImpl
 * @see com.sb.service.impl.PurchaseOrderLocalServiceImpl
 * @generated
 */
public class PurchaseOrderLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sb.service.impl.PurchaseOrderLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the purchase order to the database. Also notifies the appropriate model listeners.
	*
	* @param purchaseOrder the purchase order
	* @return the purchase order that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.PurchaseOrder addPurchaseOrder(
		com.sb.model.PurchaseOrder purchaseOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPurchaseOrder(purchaseOrder);
	}

	/**
	* Creates a new purchase order with the primary key. Does not add the purchase order to the database.
	*
	* @param PoId the primary key for the new purchase order
	* @return the new purchase order
	*/
	public static com.sb.model.PurchaseOrder createPurchaseOrder(int PoId) {
		return getService().createPurchaseOrder(PoId);
	}

	/**
	* Deletes the purchase order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PoId the primary key of the purchase order
	* @return the purchase order that was removed
	* @throws PortalException if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.PurchaseOrder deletePurchaseOrder(int PoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePurchaseOrder(PoId);
	}

	/**
	* Deletes the purchase order from the database. Also notifies the appropriate model listeners.
	*
	* @param purchaseOrder the purchase order
	* @return the purchase order that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.PurchaseOrder deletePurchaseOrder(
		com.sb.model.PurchaseOrder purchaseOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePurchaseOrder(purchaseOrder);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.sb.model.PurchaseOrder fetchPurchaseOrder(int PoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPurchaseOrder(PoId);
	}

	/**
	* Returns the purchase order with the primary key.
	*
	* @param PoId the primary key of the purchase order
	* @return the purchase order
	* @throws PortalException if a purchase order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.PurchaseOrder getPurchaseOrder(int PoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPurchaseOrder(PoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.sb.model.PurchaseOrder> getPurchaseOrders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPurchaseOrders(start, end);
	}

	/**
	* Returns the number of purchase orders.
	*
	* @return the number of purchase orders
	* @throws SystemException if a system exception occurred
	*/
	public static int getPurchaseOrdersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPurchaseOrdersCount();
	}

	/**
	* Updates the purchase order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param purchaseOrder the purchase order
	* @return the purchase order that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.PurchaseOrder updatePurchaseOrder(
		com.sb.model.PurchaseOrder purchaseOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePurchaseOrder(purchaseOrder);
	}

	/**
	* Updates the purchase order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param purchaseOrder the purchase order
	* @param merge whether to merge the purchase order with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the purchase order that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sb.model.PurchaseOrder updatePurchaseOrder(
		com.sb.model.PurchaseOrder purchaseOrder, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePurchaseOrder(purchaseOrder, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.sb.model.PurchaseItem> getItems(
		int orderId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItems(orderId);
	}

	public static java.util.List<com.sb.model.PurchaseOrder> findByOrderByUserId(
		int UserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sb.NoSuchPurchaseOrderException {
		return getService().findByOrderByUserId(UserId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PurchaseOrderLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PurchaseOrderLocalService.class.getName());

			if (invokableLocalService instanceof PurchaseOrderLocalService) {
				_service = (PurchaseOrderLocalService)invokableLocalService;
			}
			else {
				_service = new PurchaseOrderLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PurchaseOrderLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(PurchaseOrderLocalService service) {
	}

	private static PurchaseOrderLocalService _service;
}